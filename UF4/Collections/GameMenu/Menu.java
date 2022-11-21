package UF4.Collections.GameMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
    private Scanner sc = new Scanner(System.in);
    ConfigGame cf;
    Game game;
    ArrayList<Player> players;
    public Menu(ConfigGame cf, ArrayList<Player> p, Game g) {
        this.cf = cf;
        this.players= p;
        this.game= g;
        players.add(new Player("Anonymous"));
    }
    public void mainMenu() {
        boolean rep = true;
        do {
            System.out.println("-- Menu --");
            System.out.println("1. Play");
            System.out.println("2. Settings");
            System.out.println("3. Exit");
           switch (sc.nextInt()){
               case 1:
                   System.out.println("Jugar");
                   break;
               case 2:
                   confMenu();
                   break;
               case 3:
                   rep = false;
           }
        }while(rep);
    }

    public void confMenu(){
        boolean rep = true;
        int diff, num_player;
        do {
            System.out.println("-- Settings --");
            System.out.println("1. Players");
            System.out.println("2. Difficulty");
            System.out.println("3. Return");
            switch (sc.nextInt()){
                case 1:
                    System.out.println("Players (1-4)");
                    num_player = sc.nextInt();
                    sc.nextLine();
                    players.clear();
                    if (num_player >=1 && num_player <=5) {
                        for (int i = 1; i <= num_player ; i++) {
                            System.out.println("Name for Player " + i);
                            players.add(new Player(sc.nextLine()));
                        }
                    }else{
                        System.out.println("*Error, try again.*");
                    }
                    break;
                case 2:
                    System.out.println("Difficulty (1-5)");
                    diff = sc.nextInt();
                    sc.nextLine();
                    if (diff < 6 && diff > 0){
                        cf.setLevel(diff);
                        System.out.println("Set:" + cf.getLevel());
                    }else{
                        System.out.println("*Error, try again.*");
                    }
                    break;
                case 3:
                    rep = false;
            }
        }while(rep);
    }
}
