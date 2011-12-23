package ca.agnate.RepairDispenser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class RDBlockListener extends BlockListener {
    
    RepairDispenser plugin;
    
    public RDBlockListener(RepairDispenser plugin) {
        this.plugin = plugin;
    }
    
    public void onBlockDispense (BlockDispenseEvent event) {
        //plugin.getServer().getPlayer("agnate").getInventory().addItem( new ItemStack (Material.DIAMOND_CHESTPLATE, 1, (short) (Material.DIAMOND_CHESTPLATE.getMaxDurability() - 1) ) );
        
        Block block = event.getBlock();
        
        // If there's no block (for some reason), quit.
        if ( block == null ) { return; }
        if ( block.getType().equals( Material.DISPENSER ) == false ) { return; }
        
        Dispenser dispenser = (Dispenser) block.getState();
        ItemStack[] inv = dispenser.getInventory().getContents();
        List<ItemStack> repairList = new LinkedList<ItemStack> ();
        List<ItemStack> rawList = new LinkedList<ItemStack> ();
        
        // Check for any repairable items.
        for (ItemStack invItem : inv) {
            if ( Repairable.isRepairable( invItem ) ) {
                repairList.add( invItem );
            }
            else if ( Repairable.isRawMaterial( invItem ) ) {
                rawList.add( invItem );
            }
        }
        
        // If there's nothing to repair, no need to intercept Dispenser.
        if ( repairList.size() <= 0 ) {
            return;
        }
        
        // If there are no raw materials for the repair items, no need to do anything.
        if ( rawList.size() <= 0 ) {
            return;
        }
        
        boolean canRepair = false;
        LinkedList<ItemStack> usefulRawList = new LinkedList<ItemStack> ();
        ItemStack repairItem = null;
        Repairable repairInfo = null;
        
        // Might have to loop through more than 1 repairable before we find a suitable repair.
        do {
            // If there is more than 1 repairable, grab the first one we find.
            repairItem = repairList.remove(0);
            
            // If it's not damaged, don't pick this item.
            if ( repairItem.getDurability() <= 0 ) { continue; }
            
            // Grab the repair info.
            repairInfo = Repairable.getRepairable( repairItem );
            
            // If there is no repair info, continue with the next repairItem.
            if ( repairInfo == null ) { continue; }
            
            // Check if there are any raw materials for this item.
            for (ItemStack raw : rawList) {
                if ( raw == null ) { continue; }
                
                // If it's the proper material, remember it.
                if ( raw.getType().equals( repairInfo.getRaw() ) ) {
                    usefulRawList.add( raw );
                }
            }
            
            // We have raw materials, a repair item, and repair info, so we can do a repair!
            if ( usefulRawList.size() > 0 ) {
                canRepair = true;
                break;
            }
            
        } while ( repairList.size() > 0 );
        
        // If we can't repair anything, we're done.
        if ( canRepair == false ) {
            return;
        }
        
        // Calculate the durability repaired per raw material.
        short durPerRaw = (short) Math.ceil((float) repairItem.getType().getMaxDurability() / (float) repairInfo.getTotalRaw());
        
        // Use the minimum amount of raw materials for the repair.
        int numRawNeeded = (int) Math.ceil( (float) repairItem.getDurability() / (float) durPerRaw );
        
        // Remove the raw materials needed for the repair from the Dispenser inventory.
        List<ItemStack> newInv = new ArrayList<ItemStack> (Arrays.asList(inv));
        
        int numRaw = 0;
        
        while ( numRawNeeded > 0  &&  usefulRawList.size() > 0 ) {
            ItemStack temp = usefulRawList.removeFirst();
            
            if ( temp.getAmount() > numRawNeeded ) {
                temp.setAmount( temp.getAmount() - numRawNeeded );
                numRaw += numRawNeeded;
                numRawNeeded = 0;
            }
            else if ( temp.getAmount() <= numRawNeeded ) {
                numRaw += temp.getAmount();
                numRawNeeded -= temp.getAmount();
                newInv.set( newInv.indexOf(temp), null );
            }
        }
        
        // If the item currently being dropped is not the repair item, fix the dispenser's inventory.
        if ( repairItem.equals(event.getItem()) == false ) {
            
            // [BUKKIT BUG FIX] Add back the item that's going to be removed.
            int index = newInv.indexOf( event.getItem() );
            
            // If the item stack is not identical,
            if ( index <= 0 ) {
                // Find the stack of the same material and find its index.
                for (ItemStack lameItem : newInv) {
                    if ( lameItem == null ) { continue; }
                    
                    if ( lameItem.getType().equals(event.getItem().getType()) ) {
                        index = newInv.indexOf(lameItem);
                        break;
                    }
                }
            }
            
            if ( index <= 0 ) {
                index = newInv.indexOf(null);
            }
            
            ItemStack lameFix = newInv.get(index);
            if ( lameFix != null ) {
                lameFix.setAmount( lameFix.getAmount() + 1 );
            }
            
            // Remove the to-be-dispensed item.
            newInv.set( newInv.indexOf(repairItem), null );
        }
        
        // Update the dispenser's inventory.
        dispenser.getInventory().setContents( newInv.toArray( inv ) );
        
        // Calculate the repair amount.
        short repairAmt = (short) (repairItem.getDurability() - (numRaw * durPerRaw));
        
        // If they're not supposed to over-repair, only allow it to go to zero (aka: zero damage).
        if ( plugin.overRepair != true ) {
            repairAmt = (short) Math.max(0, repairAmt);
        }
        
        // Repair the item.
        repairItem.setDurability( repairAmt );
        
        // Set the dispensed item.
        event.setItem( repairItem );
    }
}
