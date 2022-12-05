import java.util.Timer;
import java.util.TimerTask;



public class Main {
    private static void ennemie(){
        final double choixEnnemie = Math.random();
        Predateur ennemie;
        if (choixEnnemie == 0.0){
            ennemie = new Terminator();
        }
        else if (choixEnnemie < 0.2){
            ennemie = new ManteReligieuse();
        }
        else if (choixEnnemie < 0.6){
            ennemie = new Guepe();
        }
        else{
            ennemie = new Scarabe();
        }
        System.out.println("Une " + ennemie.getClass().getName() + " sauvage de puissance " + ennemie.getPuissance() + " apparaît !");
    }

    private static void evenement(){
        final double evenement = (Math.random());
        if (evenement < 0.5) ennemie();
        else if (evenement < 0.75) System.out.println("Un évènement de type climat se produit wallah");
        else System.out.println("Il se passe des choses");
    }

    public static void main(String[] args){
        Fourmiliere fourmiliere = new Fourmiliere(new Reine(60),100);
        fourmiliere.addGroupeFourmies(new GroupeSoldat());
        Timer timer = new Timer();
        int begin = 1000; //timer starts after 1 second
        int timeinterval = 1 * 1000; //timer executes every 10 seconds
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //This code is executed at every interval defined by timeinterval (eg 10 seconds)
                //And starts after x milliseconds defined by begin.
                if (Math.random() < 0.5) evenement();
            }
        },begin, timeinterval);
    }
}


