import java.util.Scanner;

public class Player {
    private String nom;
    private double score;
    private int ab = 0;
    private int affile = 0;
    private static Index index = new Index();
    public Player(String nom){
        this.nom = nom;
        score = 0;
        ab = 0;
    }

    public boolean jouerTour(int bc){
        String combinaison, tmp;
        double scoreMade;
        int schlass;
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel combinaison "+nom+" a t-il fait ? ");
        combinaison = sc.nextLine();
        while(!index.combinaisons.containsKey(combinaison)){
            System.out.println("Erreur sur la combinaison !");
            System.out.println("Quel combinaison "+nom+" a t-il fait ? ");
            combinaison = sc.nextLine();
        }
        if(combinaison.equals("enculette")){
            String opponent;
            System.out.println("A qui voulez vous voler 3 points ? ");
            opponent = sc.nextLine();
            Main.players.get(Main.players.indexOf(new Player(opponent))).addScore(-3);
        }
        if(combinaison.equals("catin")){
            System.out.println(nom+" est une grosse salope !");
        }
        scoreMade = index.combinaisons.get(combinaison);
        if(!combinaison.equals("nenette") || !combinaison.equals("catin")){
            scoreMade += ab;
            scoreMade += bc;
            System.out.println("First try ? (o/n)");
            tmp = sc.nextLine();
            if(tmp.equals("o")){
                scoreMade++;
            }
        }
        addScore(scoreMade);
        if (combinaison.equals("0")){
            affile = 0;
            ab = 0;
            return false;
        }else {
            affile++;
            if(affile>=3){
                ab++;
            }
            return true;
        }
    }


    public double getScore(){
        return score;
    }

    private void addScore(double scoreMade){
        score += scoreMade;
    }

    public String getNom(){
        return nom;
    }


    @Override
    public boolean equals(Object o){
        if(o.getClass()!=this.getClass()){
            return false;
        }
        if(o==this) return true;
        if(((Player)o).getNom().equals(nom)){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return nom+" a "+score+" points !";
    }
}
