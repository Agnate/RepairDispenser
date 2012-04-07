package ca.agnate.RepairDispenser;

import org.bukkit.Material;

public class Repairable {
    public Material item;
    public Material raw;
    public int totalRaw;
    
    public Repairable (Material item, Material raw, int totalRaw) {
        this.item = item;
        this.raw = raw;
        this.totalRaw = totalRaw;
    }
    
    public float calcRepair ( int numRaw ) {
        return( (float) (numRaw / totalRaw) );
    }

    public String toString () {
        return( item.toString() );
    }
}
