package UF4.Collections.GameMenu;

public class ConfigGame {
    private int level, numPlayers;
    public ConfigGame(int level, int numPlayers) {
        this.level = level;
        this.numPlayers = numPlayers;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int getLevel() {
        return level;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    @Override
    public String toString() {
        return "ConfigGame{" +
                "level=" + level +
                ", numPlayers=" + numPlayers +
                '}';
    }
}
