public enum Operations {

    ADD ("+", 2),
    SUB ("-", 2),
    MULT ("*", 3),
    DIV("/", 3),
    OPENBRACKET("(", 4),
    CLOSEBRACKET(")", -1);
    // level == 0 - number;

    private final String smb;

    private final int level;

    Operations(String smb, int level) {
        this.smb = smb;
        this.level = level;
    }
    public String getSmb() {
        return smb;
    }
    public int getLevel() {
        return level;
    }
}
