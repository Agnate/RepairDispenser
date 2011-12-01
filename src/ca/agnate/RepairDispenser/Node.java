package ca.agnate.RepairDispenser;

import java.util.LinkedList;
import java.util.List;

public enum Node {
    NOREPAIR ("norepair");
    
    private static List<Node> all; 
    
    static {
    	// Create a list of all the Nodes.
    	all = new LinkedList<Node> ();
    	all.add(Node.NOREPAIR);
    }
    
    private String perm;
    private String prefix = "repairdispenser.";

    private Node (String perm) {
    	this.perm = perm;
    }

    public String toString () {
    	return( prefix + this.perm );
    }
    
    public static List<Node> allNodes () {
    	return all;
    }
    
    public static List<Node> cloneList ( List<Node> list ) {
    	List<Node> newList = new LinkedList<Node> ();
    	
    	for (Node item : list) {
			newList.add( item );
		}
    	
    	return newList;
    }
}
