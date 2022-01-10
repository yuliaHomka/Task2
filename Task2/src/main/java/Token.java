public class Token {

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    private String meaning;
    private int level;

    public Token(String meaning, int level) {
        this.meaning = meaning;
        this.level = level;
    }

    public String getMeaning() {
        return meaning;
    }

    public int getLevel() {
        return level;
    }
}
