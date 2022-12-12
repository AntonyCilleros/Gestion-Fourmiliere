import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class test {
    private static void ennemie(Fourmiliere fourmiliere){
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
        System.out.println("Une " + ennemie.getClass().getName() + " sauvage apparait ! (puissance : " + ennemie.getPuissance() + ")");
        if (ennemie.getPuissance() > fourmiliere.getPuissance()){
            int total = fourmiliere.getNbAventuriere() + fourmiliere.getNbNourriciere() + fourmiliere.getNbSoldat();
            if (ennemie.getPuissance() - fourmiliere.getPuissance() > total){
                System.out.println("Toutes les fourmies sont mortes.");
                while(true);
            }
            for (int i=0; i < ennemie.getPuissance() - fourmiliere.getPuissance(); ++i){
                total = fourmiliere.getNbAventuriere() + fourmiliere.getNbNourriciere() + fourmiliere.getNbSoldat();
                System.out.println(total);
                int condamne = new Random().nextInt(total - 1 + 1) + 1;
                if (condamne > fourmiliere.getNbAventuriere()){
                    if (condamne > fourmiliere.getNbAventuriere() + fourmiliere.getNbNourriciere()){
                        fourmiliere.groupeSoldat.nbFourmies -= 1;
                    }
                    else {
                        fourmiliere.groupeNourrice.nbFourmies -= 1;
                    }
                }
                else {
                    fourmiliere.groupeAventuriere.nbFourmies -= 1;
                }
            }
        }
        else {
            System.out.println("Menace éliminé, aucune perte allié");
        }
    }

    private static void evenement(Fourmiliere fourmiliere){
        final double evenement = (Math.random());
        if (evenement < 0.5) ennemie(fourmiliere);
        else if (evenement < 0.75) System.out.println("Un évènement de type climat se produit wallah");
        else System.out.println("C'est l'hiver");
    }

    public static void main(String[] args){
        Fourmiliere fourmiliere = new Fourmiliere(new Reine());
        fourmiliere.groupeSoldat.nbFourmies = 200;
        fourmiliere.groupeAventuriere.nbFourmies = 1500;
        Timer timer = new Timer();
        int begin = 1000; //timer starts after 1 second
        int timeinterval = 1 * 1000; //timer executes every 10 seconds
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //This code is executed at every interval defined by timeinterval (eg 10 seconds)
                //And starts after x milliseconds defined by begin.
                System.out.println(fourmiliere.groupeAventuriere.nbFourmies + " | " + fourmiliere.groupeNourrice.nbFourmies + " | " + fourmiliere.groupeSoldat.nbFourmies);
                if (Math.random() < 0.5) evenement(fourmiliere);
            }
        },begin, timeinterval);
    }
}
