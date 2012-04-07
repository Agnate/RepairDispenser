package ca.agnate.RepairDispenser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Repairer {
    public List<Repairable> all;
    public Map<Material, Repairable> allMap;
    public Map<Material, Material> rawMap;
    public List<Material> rawList;
    public Map<Material, List<Material>> repairList;
    
    public Repairer () {
        load();
    }
    
    public void load () {
        // Create a list of all the Repairables.
        all = new LinkedList<Repairable> ();
        
        // Add all repairables to the list.
        setupRepairables();
        
        rawList = new LinkedList<Material> ();
        allMap = new HashMap<Material, Repairable>();
        rawMap = new HashMap<Material, Material>();
        repairList = new HashMap<Material, List<Material>> ();
        
        // Create the hashmap for all repairables.
        for (Repairable rep : all) {
            rawMap.put( rep.item, rep.raw );
            allMap.put( rep.item, rep );
            
            // Check if the raw list has this raw material or not.
            if ( rawList.contains( rep.raw ) == false ) {
                rawList.add( rep.raw );
            }
            
            // If the repairList doesn't have a list started for this raw material, start one.
            if ( repairList.containsKey( rep.raw ) == false ) {
                repairList.put( rep.raw, new LinkedList<Material> () );
            }
            
            // Add the repairable item to the repairList for the raw material key.
            repairList.get( rep.raw ).add( rep.item );
        }
    }
    
    public void setupRepairables () {
        all.add( new Repairable ( Material.IRON_SPADE, Material.IRON_INGOT, 1 ) );
        all.add( new Repairable ( Material.IRON_PICKAXE, Material.IRON_INGOT, 3 ) );
        all.add( new Repairable ( Material.IRON_AXE, Material.IRON_INGOT, 3 ) );
        all.add( new Repairable ( Material.IRON_SWORD, Material.IRON_INGOT, 2 ) );
        all.add( new Repairable ( Material.IRON_HOE, Material.IRON_INGOT, 2 ) );
        all.add( new Repairable ( Material.IRON_HELMET, Material.IRON_INGOT, 5 ) );
        all.add( new Repairable ( Material.IRON_CHESTPLATE, Material.IRON_INGOT, 8 ) );
        all.add( new Repairable ( Material.IRON_LEGGINGS, Material.IRON_INGOT, 7 ) );
        all.add( new Repairable ( Material.IRON_BOOTS, Material.IRON_INGOT, 4 ) );
        all.add( new Repairable ( Material.SHEARS, Material.IRON_INGOT, 2 ) );
        
        all.add( new Repairable ( Material.WOOD_SWORD, Material.WOOD, 2 ) );
        all.add( new Repairable ( Material.WOOD_SPADE, Material.WOOD, 1 ) );
        all.add( new Repairable ( Material.WOOD_PICKAXE, Material.WOOD, 3 ) );
        all.add( new Repairable ( Material.WOOD_AXE, Material.WOOD, 3 ) );
        all.add( new Repairable ( Material.WOOD_HOE, Material.WOOD, 2 ) );
        
        all.add( new Repairable ( Material.BOW, Material.STRING, 2 ) );
        all.add( new Repairable ( Material.FISHING_ROD, Material.STRING, 2 ) );
        
        all.add( new Repairable ( Material.STONE_SWORD, Material.COBBLESTONE, 2 ) );
        all.add( new Repairable ( Material.STONE_SPADE, Material.COBBLESTONE, 1 ) );
        all.add( new Repairable ( Material.STONE_PICKAXE, Material.COBBLESTONE, 3 ) );
        all.add( new Repairable ( Material.STONE_AXE, Material.COBBLESTONE, 3 ) );
        all.add( new Repairable ( Material.STONE_HOE, Material.COBBLESTONE, 2 ) );
        
        all.add( new Repairable ( Material.DIAMOND_SWORD, Material.DIAMOND, 2 ) );
        all.add( new Repairable ( Material.DIAMOND_SPADE, Material.DIAMOND, 1 ) );
        all.add( new Repairable ( Material.DIAMOND_PICKAXE, Material.DIAMOND, 3 ) );
        all.add( new Repairable ( Material.DIAMOND_AXE, Material.DIAMOND, 3 ) );
        all.add( new Repairable ( Material.DIAMOND_HOE, Material.DIAMOND, 2 ) );
        all.add( new Repairable ( Material.DIAMOND_HELMET, Material.DIAMOND, 5 ) );
        all.add( new Repairable ( Material.DIAMOND_CHESTPLATE, Material.DIAMOND, 8 ) );
        all.add( new Repairable ( Material.DIAMOND_LEGGINGS, Material.DIAMOND, 7 ) );
        all.add( new Repairable ( Material.DIAMOND_BOOTS, Material.DIAMOND, 4 ) );
        
        all.add( new Repairable ( Material.GOLD_SWORD, Material.GOLD_INGOT, 2 ) );
        all.add( new Repairable ( Material.GOLD_SPADE, Material.GOLD_INGOT, 1 ) );
        all.add( new Repairable ( Material.GOLD_PICKAXE, Material.GOLD_INGOT, 3 ) );
        all.add( new Repairable ( Material.GOLD_AXE, Material.GOLD_INGOT, 3 ) );
        all.add( new Repairable ( Material.GOLD_HOE, Material.GOLD_INGOT, 2 ) );
        all.add( new Repairable ( Material.GOLD_HELMET, Material.GOLD_INGOT, 5 ) );
        all.add( new Repairable ( Material.GOLD_CHESTPLATE, Material.GOLD_INGOT, 8 ) );
        all.add( new Repairable ( Material.GOLD_LEGGINGS, Material.GOLD_INGOT, 7 ) );
        all.add( new Repairable ( Material.GOLD_BOOTS, Material.GOLD_INGOT, 4 ) );
        
        all.add( new Repairable ( Material.LEATHER_HELMET, Material.LEATHER, 5 ) );
        all.add( new Repairable ( Material.LEATHER_CHESTPLATE, Material.LEATHER, 8 ) );
        all.add( new Repairable ( Material.LEATHER_LEGGINGS, Material.LEATHER, 7 ) );
        all.add( new Repairable ( Material.LEATHER_BOOTS, Material.LEATHER, 4 ) );
        
        all.add( new Repairable ( Material.CHAINMAIL_HELMET, Material.FIRE, 5 ) );
        all.add( new Repairable ( Material.CHAINMAIL_CHESTPLATE, Material.FIRE, 8 ) );
        all.add( new Repairable ( Material.CHAINMAIL_LEGGINGS, Material.FIRE, 7 ) );
        all.add( new Repairable ( Material.CHAINMAIL_BOOTS, Material.FIRE, 4 ) );
    }
    
    public boolean isRawMaterial ( ItemStack item ) {
        if ( item == null ) { return false; }
        
        return rawList.contains( item.getType() );
    }
    
    public boolean hasRawMaterial ( ItemStack item ) {
        if ( item == null ) { return false; }
        
        return rawMap.containsKey( item.getType() );
    }
    
    public Material getRawMaterial ( ItemStack item ) {
        if ( item == null ) { return null; }
        
        return rawMap.get( item.getType() );
    }
    
    public boolean isRepairable ( ItemStack item ) {
        if ( item == null ) { return false; }
        
        return allMap.containsKey( item.getType() );
    }
    
    public Repairable getRepairable ( ItemStack item ) {
        if ( item == null ) { return null; }
        
        return allMap.get( item.getType() );
    }
    
    public List<Material> getPossibleRepairs ( ItemStack item ) {
        if ( item == null ) { return new LinkedList<Material> (); }
        
        return repairList.get( item.getType() );
    }
}
