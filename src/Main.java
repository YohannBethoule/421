import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Player> players;
    private static int bc = 0;
    private static int affile = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Index index = new Index();
        entrerJoueurs();
        while(1==1){
            System.out.println("Fin du jeu ? (o/n)");
            if(sc.nextLine().equals("o")){
                break;
            }
            for (Player p: players) {
                if(!p.jouerTour(bc)){
                    affile = 0;
                    bc=0;
                }else{
                    affile++;
                    if(affile>=3){
                        bc++;
                    }
                }
            }
            System.out.println("------------------------------------------------------");
            System.out.println("Scores :");
            for (Player p : players) {
                System.out.println(p);
            }
        }

    }



    private static void entrerJoueurs(){
        Scanner sc = new Scanner(System.in);
        players = new LinkedList<Player>();
        String name;
        System.out.println("Entrez le nom d'un joueur, ou 0 pour finir la saisie:");
        name = sc.nextLine();
        while(!name.equals("0")){
            players.add(new Player(name));
            System.out.println("Entrez le nom d'un joueur, ou 0 pour finir la saisie:");
            name = sc.nextLine();
        }
    }
}
