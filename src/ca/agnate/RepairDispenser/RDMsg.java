package ca.agnate.RepairDispenser;

public class RDMsg {
    public static enum Msg {
        PLAYER_NOREPAIR ("I can't let you repair that, %.", "I can't let you repair that, %.");
        
        private String msg, spoutMsg;
        
        private Msg(String msg) {
            this(msg, null);
        }
        
        private Msg(String msg, String spoutMsg) {
            this.msg = msg;
            this.spoutMsg = spoutMsg;
        }
        
        public String get() {
            return msg;
        }
        public String get(String s) {
        	if ( s == null ) { return msg; }
            return get().replace("%", s);
        }
        public String get(String s, String s2) {
        	if ( s == null ) { return msg; }
        	if ( s2 == null ) { return get(s); }
            return get(s).replace("@", s2);
        }
        public String get(String s, String s2, String s3) {
        	if ( s == null ) { return msg; }
        	if ( s2 == null ) { return get(s); }
        	if ( s3 == null ) { return get(s, s2); }
            return get(s, s2).replace("^", s3);
        }
        
        public String getSpout() {
        	return (spoutMsg == null) ? get() : spoutMsg;
        }
        public String getSpout(String s) {
            if ( spoutMsg == null ) { return get(s); }
            if ( s == null ) { return getSpout(); }
            return spoutMsg.replace("%", s);
        }
        public String getSpout(String s, String s2) {
            if (spoutMsg == null) { return get(s, s2); }
            if ( s == null ) { return getSpout(); }
            if ( s2 == null ) { return getSpout(s); }
            return getSpout(s).replace("@", s2);
        }
        public String getSpout(String s, String s2, String s3) {
            if (spoutMsg == null) { return get(s, s2, s3); }
            if ( s == null ) { return getSpout(); }
            if ( s2 == null ) { return getSpout(s); }
            if ( s3 == null ) { return getSpout(s, s2); }
            return getSpout(s, s2).replace("^", s3);
        }
        
        public void set(String msg) {
            this.msg = msg;
        }
        
        public void setSpout(String spoutMsg) {
            this.spoutMsg = spoutMsg;
        }
        
        public boolean hasSpoutMsg() {
            return spoutMsg != null;
        }
        
        public static String get(Msg m) {
            return m.msg;
        }
        
        public static String get(Msg m, String s) {
            return m.msg.replace("%", s);   
        }
        
        public static void set(Msg m, String msg) {
            m.msg = msg;
        }
        
        public String toString() {
            return msg;
        }
    }
    
    
}
