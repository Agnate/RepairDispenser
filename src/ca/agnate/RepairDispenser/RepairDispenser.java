package ca.agnate.RepairDispenser;

import java.util.LinkedList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permissible;
import org.bukkit.plugin.java.JavaPlugin;

public class RepairDispenser extends JavaPlugin {
	
	protected List<Node> permissionOPs;
    protected Server server;
    protected static String prefix = "[RepairDispenser]";
	public boolean overRepair;
	public boolean wasteRaws;
	public List<Repairable> repairables;
	public Repairer repairer;
    
	@Override
	public void onDisable() {
		// Show disabled message.
        System.out.println("[" + this + "] RepairDispenser is disabled.");
	}

	@Override
	public void onEnable() {
	    // Add in permission node checks for OPs.
        permissionOPs = new LinkedList<Node>();
        permissionOPs.add( Node.NOREPAIR );
	    
        // Save server object.
        server = getServer();
        
	    // Grab data from config.
        overRepair = this.getConfig().getBoolean("over-repair");
        wasteRaws = this.getConfig().getBoolean("waste-raw-materials");
        
        // Create the repairer.
        repairer = new Repairer ();
        
        // Save a default config file.
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        
        // Create event listener.
        getServer().getPluginManager().registerEvents(new RDBlockListener (this), this);
        
        // Show enabled message.
        System.out.println("[" + this + "] RepairDispenser is enabled.");
	}
	
	public static boolean sendMsg(CommandSender p, String msg) {
        // If the input sender is null or the string is empty, return.
        if (msg.equals("")) {
            return false;
        }
        
        // If no sender is given, just use the System.out.
        if (p == null) {
            System.out.println( prefix + " " + msg );
            return true;
        }
        
        // Send the message to the assigned sender.
        p.sendMessage(ChatColor.AQUA + prefix + " " + ChatColor.WHITE + msg);
        return true;
    }
    
    public boolean has(Permissible p, Node n) {
        // return (permissionHandler == null || permissionHandler.has(p, s));
        // return hasSuperPerms(p, s);
        return hasSuperPerms(p, n.toString()) || hasOPPerm(p, n);
    }
    protected boolean hasOPPerm(Permissible p, Node node) {
        // If the node requires OP status, and the player has OP, then true.
        return (permissionOPs == null || permissionOPs.contains(node) == false || p.isOp());
    }
    protected boolean hasSuperPerms(Permissible p, String s) {
        String[] nodes = s.split("\\.");

        String perm = "";
        for (int i = 0; i < nodes.length; i++) {
            perm += nodes[i] + ".";
            if (p.hasPermission(perm + "*"))
                return true;
        }

        return p.hasPermission(s);
    }

}
