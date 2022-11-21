package UF4.Collections.GameMenu;

import java.util.ArrayList;

public class Game {


    ArrayList<Player> players = new ArrayList<Player>(4);
    ConfigGame conf = new ConfigGame(1, 1);
    Menu menu = new Menu(conf, players, this);
    public void play(){
        menu.mainMenu();
    }
}
