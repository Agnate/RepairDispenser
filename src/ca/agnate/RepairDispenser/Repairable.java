package ca.agnate.RepairDispenser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Repairable {
    IRON_SPADE      ( Material.IRON_SPADE, Material.IRON_INGOT, 1 ),
    IRON_PICKAXE    ( Material.IRON_PICKAXE, Material.IRON_INGOT, 3 ),
    IRON_AXE        ( Material.IRON_AXE, Material.IRON_INGOT, 3 ),
    IRON_SWORD      ( Material.IRON_SWORD, Material.IRON_INGOT, 2 ),
    IRON_HOE        ( Material.IRON_HOE, Material.IRON_INGOT, 2 ),
    IRON_HELMET     ( Material.IRON_HELMET, Material.IRON_INGOT, 5 ),
    IRON_CHESTPLATE ( Material.IRON_CHESTPLATE, Material.IRON_INGOT, 8 ),
    IRON_LEGGINGS   ( Material.IRON_LEGGINGS, Material.IRON_INGOT, 7 ),
    IRON_BOOTS      ( Material.IRON_BOOTS, Material.IRON_INGOT, 4 ),
    SHEARS          ( Material.SHEARS, Material.IRON_INGOT, 2 ),
    
    WOOD_SWORD      ( Material.WOOD_SWORD, Material.WOOD, 2 ),
    WOOD_SPADE      ( Material.WOOD_SPADE, Material.WOOD, 1 ),
    WOOD_PICKAXE    ( Material.WOOD_PICKAXE, Material.WOOD, 3 ),
    WOOD_AXE        ( Material.WOOD_AXE, Material.WOOD, 3 ),
    WOOD_HOE        ( Material.WOOD_HOE, Material.WOOD, 2 ),
    
    BOW             ( Material.BOW, Material.STRING, 2 ),
    FISHING_ROD     ( Material.FISHING_ROD, Material.STRING, 2 ),
    
    STONE_SWORD     ( Material.STONE_SWORD, Material.COBBLESTONE, 2 ),
    STONE_SPADE     ( Material.STONE_SPADE, Material.COBBLESTONE, 1 ),
    STONE_PICKAXE   ( Material.STONE_PICKAXE, Material.COBBLESTONE, 3 ),
    STONE_AXE       ( Material.STONE_AXE, Material.COBBLESTONE, 3 ),
    STONE_HOE       ( Material.STONE_HOE, Material.COBBLESTONE, 2 ),
    
    DIAMOND_SWORD       ( Material.DIAMOND_SWORD, Material.DIAMOND, 2 ),
    DIAMOND_SPADE       ( Material.DIAMOND_SPADE, Material.DIAMOND, 1 ),
    DIAMOND_PICKAXE     ( Material.DIAMOND_PICKAXE, Material.DIAMOND, 3 ),
    DIAMOND_AXE         ( Material.DIAMOND_AXE, Material.DIAMOND, 3 ),
    DIAMOND_HOE         ( Material.DIAMOND_HOE, Material.DIAMOND, 2 ),
    DIAMOND_HELMET      ( Material.DIAMOND_HELMET, Material.DIAMOND, 5 ),
    DIAMOND_CHESTPLATE  ( Material.DIAMOND_CHESTPLATE, Material.DIAMOND, 8 ),
    DIAMOND_LEGGINGS    ( Material.DIAMOND_LEGGINGS, Material.DIAMOND, 7 ),
    DIAMOND_BOOTS       ( Material.DIAMOND_BOOTS, Material.DIAMOND, 4 ),
    
    GOLD_SWORD      ( Material.GOLD_SWORD, Material.GOLD_INGOT, 2 ),
    GOLD_SPADE      ( Material.GOLD_SPADE, Material.GOLD_INGOT, 1 ),
    GOLD_PICKAXE    ( Material.GOLD_PICKAXE, Material.GOLD_INGOT, 3 ),
    GOLD_AXE        ( Material.GOLD_AXE, Material.GOLD_INGOT, 3 ),
    GOLD_HOE        ( Material.GOLD_HOE, Material.GOLD_INGOT, 2 ),
    GOLD_HELMET     ( Material.GOLD_HELMET, Material.GOLD_INGOT, 5 ),
    GOLD_CHESTPLATE ( Material.GOLD_CHESTPLATE, Material.GOLD_INGOT, 8 ),
    GOLD_LEGGINGS   ( Material.GOLD_LEGGINGS, Material.GOLD_INGOT, 7 ),
    GOLD_BOOTS      ( Material.GOLD_BOOTS, Material.GOLD_INGOT, 4 ),
    
    LEATHER_HELMET      ( Material.LEATHER_HELMET, Material.LEATHER, 5 ),
    LEATHER_CHESTPLATE  ( Material.LEATHER_CHESTPLATE, Material.LEATHER, 8 ),
    LEATHER_LEGGINGS    ( Material.LEATHER_LEGGINGS, Material.LEATHER, 7 ),
    LEATHER_BOOTS       ( Material.LEATHER_BOOTS, Material.LEATHER, 4 ),
    
    CHAINMAIL_HELMET    ( Material.CHAINMAIL_HELMET, Material.FIRE, 5 ),
    CHAINMAIL_CHESTPLATE( Material.CHAINMAIL_CHESTPLATE, Material.FIRE, 8 ),
    CHAINMAIL_LEGGINGS  ( Material.CHAINMAIL_LEGGINGS, Material.FIRE, 7 ),
    CHAINMAIL_BOOTS     ( Material.CHAINMAIL_BOOTS, Material.FIRE, 4 );
    
    
    private static List<Repairable> all;
    private static Map<Material, Repairable> allMap;
    private static Map<Material, Material> rawMap;
    private static List<Material> rawList;
    private static Map<Material, List<Material>> repairList;
    
    static {
        // Create a list of all the Repairables.
        all = new LinkedList<Repairable> ();
        
        all.add(Repairable.IRON_SPADE);
        all.add(Repairable.IRON_PICKAXE);
        all.add(Repairable.IRON_AXE);
        all.add(Repairable.IRON_SWORD);
        all.add(Repairable.IRON_HOE);
        all.add(Repairable.IRON_HELMET);
        all.add(Repairable.IRON_CHESTPLATE);
        all.add(Repairable.IRON_LEGGINGS);
        all.add(Repairable.IRON_BOOTS);
        all.add(Repairable.SHEARS);
        
        all.add(Repairable.WOOD_SWORD);
        all.add(Repairable.WOOD_SPADE);
        all.add(Repairable.WOOD_PICKAXE);
        all.add(Repairable.WOOD_AXE);
        all.add(Repairable.WOOD_HOE);
        
        all.add(Repairable.BOW);
        all.add(Repairable.FISHING_ROD);
        
        all.add(Repairable.STONE_SWORD);
        all.add(Repairable.STONE_SPADE);
        all.add(Repairable.STONE_PICKAXE);
        all.add(Repairable.STONE_AXE);
        all.add(Repairable.STONE_HOE);
        
        all.add(Repairable.DIAMOND_SWORD);
        all.add(Repairable.DIAMOND_SPADE);
        all.add(Repairable.DIAMOND_PICKAXE);
        all.add(Repairable.DIAMOND_AXE);
        all.add(Repairable.DIAMOND_HOE);
        all.add(Repairable.DIAMOND_HELMET);
        all.add(Repairable.DIAMOND_CHESTPLATE);
        all.add(Repairable.DIAMOND_LEGGINGS);
        all.add(Repairable.DIAMOND_BOOTS);
        
        all.add(Repairable.GOLD_SWORD);
        all.add(Repairable.GOLD_SPADE);
        all.add(Repairable.GOLD_PICKAXE);
        all.add(Repairable.GOLD_AXE);
        all.add(Repairable.GOLD_HOE);
        all.add(Repairable.GOLD_HELMET);
        all.add(Repairable.GOLD_CHESTPLATE);
        all.add(Repairable.GOLD_LEGGINGS);
        all.add(Repairable.GOLD_BOOTS);
        
        all.add(Repairable.LEATHER_HELMET);
        all.add(Repairable.LEATHER_CHESTPLATE);
        all.add(Repairable.LEATHER_LEGGINGS);
        all.add(Repairable.LEATHER_BOOTS);
        
        all.add(Repairable.CHAINMAIL_HELMET);
        all.add(Repairable.CHAINMAIL_CHESTPLATE);
        all.add(Repairable.CHAINMAIL_LEGGINGS);
        all.add(Repairable.CHAINMAIL_BOOTS);
        
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
    
    private Material item;
    private Material raw;
    private int totalRaw;
    
    private Repairable (Material item, Material raw, int totalRaw) {
        this.item = item;
        this.raw = raw;
        this.totalRaw = totalRaw;
    }
    
    public Material getItem () {
        return item;
    }
    
    public Material getRaw () {
        return raw;
    }
    
    public int getTotalRaw () {
        return totalRaw;
    }
    
    public float calcRepair ( int numRaw ) {
        return( (float) (numRaw / totalRaw) );
    }

    public String toString () {
        return( item.toString() );
    }
    
    public static List<Repairable> allRepairables () {
        return all;
    }
    
    public static List<Material> allRawMaterials () {
        return rawList;
    }
    
    public static boolean isRawMaterial ( ItemStack item ) {
        if ( item == null ) { return false; }
        
        return rawList.contains( item.getType() );
    }
    
    public static boolean hasRawMaterial ( ItemStack item ) {
        if ( item == null ) { return false; }
        
        return rawMap.containsKey( item.getType() );
    }
    
    public static Material getRawMaterial ( ItemStack item ) {
        if ( item == null ) { return null; }
        
        return rawMap.get( item.getType() );
    }
    
    public static boolean isRepairable ( ItemStack item ) {
        if ( item == null ) { return false; }
        
        return allMap.containsKey( item.getType() );
    }
    
    public static Repairable getRepairable ( ItemStack item ) {
        if ( item == null ) { return null; }
        
        return allMap.get( item.getType() );
    }
    
    public static List<Material> getPossibleRepairs ( ItemStack item ) {
        if ( item == null ) { return new LinkedList<Material> (); }
        
        return repairList.get( item.getType() );
    }
}
