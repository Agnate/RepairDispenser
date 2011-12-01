package ca.agnate.RepairDispenser;

import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockListener;

public class RDBlockListener extends BlockListener {
    
    public RDBlockListener() {
        
    }
    
    public void onBlockDispense (BlockDispenseEvent event) {
        RepairDispenser.sendMsg(null, event.getItem().toString());
    }
}
