package ca.agnate.RepairDispenser;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class RDBlockListener extends BlockListener {
    
    RepairDispenser plugin;
    
    public RDBlockListener(RepairDispenser plugin) {
        this.plugin = plugin;
    }
    
    public void onBlockDispense (BlockDispenseEvent event) {
        RepairDispenser.sendMsg(null, "Dispensing " + event.getItem().toString() + "...");
        
        Block block = event.getBlock();
        
        // If there's no block (for some reason), quit.
        if ( block == null ) { return; }
        if ( block.getType().equals( Material.DISPENSER ) == false ) { return; }
        
        Dispenser dispenser = (Dispenser) block.getState();
        ItemStack drop = event.getItem();
        ItemStack[] items = dispenser.getInventory().getContents();
        
        for (ItemStack item : items) {
            if ( item == null ) { continue; }
            if ( item.getAmount() != drop.getAmount() ) { continue; }
            if ( item.getTypeId() != drop.getTypeId() ) { continue; }
            if ( item.getDurability() != drop.getDurability() ) { continue; }
            
            // Add enchantments to the dropped item.
            if ( item.getEnchantments().size() > 0 ) {
                RepairDispenser.sendMsg(null, "    ADDING ENCHANTS!");
                drop.addEnchantments( item.getEnchantments() );
                
                for ( Enchantment enchant : item.getEnchantments().keySet() ) {
                    if ( enchant == null ) { continue; }
                    RepairDispenser.sendMsg(null, "    ENCHANT = " + enchant.toString());
                }
            }
            
            RepairDispenser.sendMsg(null, "    INV = " + item.toString());
            
            event.setItem( drop );
            
            for ( Enchantment enchant : event.getItem().getEnchantments().keySet() ) {
                if ( enchant == null ) { continue; }
                RepairDispenser.sendMsg(null, "    DROPENCHANT = " + enchant.toString());
            }
            
            return;
        }
    }
}
