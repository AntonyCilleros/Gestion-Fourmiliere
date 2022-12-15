import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class main implements Runnable{
    static GUI Affiche;
    static Reine reine = new Reine();
    static GroupeFourmies groupeFourmies = new GroupeFourmies(new GroupeSoldat(),new GroupeNourrice(),new GroupeAventuriere());
    static Fourmiliere fourmiliere = new Fourmiliere(reine, groupeFourmies);
    static int temps = 0;
    static int hiver = 0;
    static int winterIsComing = 0;
    static boolean pause = false;

    private static void ManageScreen() throws InterruptedException, InvocationTargetException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                try {
                    gererEcran();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            try {
                creerFourmie();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void gererEcran() throws InterruptedException{
        Affiche.TempsPasseValeur.setText(String.valueOf(temps));
        Affiche.nbLarves.setText(String.valueOf(fourmiliere.getNbLarves()));
        Affiche.nbFourmiesLabel.setText(String.valueOf(fourmiliere.getNombreFourmies()));
        Affiche.soldatTotal.setText(String.valueOf(fourmiliere.getNbSoldat()));
        Affiche.NourricieresTotal.setText(String.valueOf(fourmiliere.getNbNourriciere()));
        Affiche.aventurieresTotal.setText(String.valueOf(fourmiliere.getNbAventuriere()));
        Affiche.nbNourritureLabel.setText(String.valueOf(fourmiliere.getNbNourriture()));
        if (winterIsComing > 0) Affiche.HiverLabel.setText("Winter is coming!");
        else if (hiver > 0) Affiche.HiverLabel.setText("C'est l'hiver");
        else Affiche.HiverLabel.setText("");
    }

    public static void creerFourmie() throws InterruptedException {
        if(temps != 0) {
            if (temps % 5 == 0) {
                fourmiliere.groupeFourmies.naissance(fourmiliere, Affiche.probaSoldats, Affiche.probaNourrice, Affiche.probaAventuriere);
            }
            fourmiliere.setNbLarves();
            if (hiver == 0) fourmiliere.ajoutNourriture(3);
            else fourmiliere.ajoutNourriture(1);
            fourmiliere.groupeFourmies.manger(fourmiliere);
            /*if(temps % 10 == 0){
                fourmiliere.groupeFourmies.meurt();
            }*/
        }
    }

    private static void ennemie(){
        final double choixEnnemie = Math.random();
        Predateur ennemie;
        if (choixEnnemie <= 0.01){
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
        Affiche.typeEnvahisseur.setText(ennemie.getClass().getName());
        Affiche.nbForceEnvahisseur.setText(String.valueOf(ennemie.getPuissance()));
        if (ennemie.getPuissance() > fourmiliere.getPuissance()){
            if (ennemie.getPuissance() >= fourmiliere.getPuissance()*3){
                System.out.println("Toutes les fourmies sont mortes.");
                while(true);
            }
            int perte = randomNumberBetween(70,80);
            System.out.println("Ennemi plus fort");
            System.out.println("Avant attaque : " + fourmiliere.getNombreFourmies());
            mort(fourmiliere.getNombreFourmies()*(perte/100));
            System.out.println("Après attaque : " + fourmiliere.getNombreFourmies());
        }
        else {
            int perte = randomNumberBetween(5,10);
            System.out.println("Fourmies gagnent");
            System.out.println("Avant attaque : " + fourmiliere.getNombreFourmies());
            mort(perte);
            System.out.println("Après attaque : " + fourmiliere.getNombreFourmies());
        }
    }

    private static void mort(int perte){
        for (int i=0; i < perte; ++i){
            int condamne = randomNumberBetween(1, fourmiliere.getNombreFourmies());
            if (condamne > fourmiliere.getNbAventuriere()){
                if (condamne > fourmiliere.getNbAventuriere() + fourmiliere.getNbNourriciere()){
                    fourmiliere.groupeFourmies.groupeSoldat.nbSoldat -= 1;
                }
                else {
                    fourmiliere.groupeFourmies.groupeNourrice.nbNourrice -= 1;
                }
            }
            else {
                fourmiliere.groupeFourmies.groupeAventuriere.nbAventuriere -= 1;
            }
        }
    }

    private static void climat(){
        if (winterIsComing != 0) --winterIsComing;
        else if (hiver != 0) {
            if (hiver == 10) System.out.println("C'est l'hiver !");
            --hiver;
            System.out.println("Plus que " + hiver + " jours avant la fin de l'hiver");
        }
        else if (Math.random() < 0.05) {
            hiver = 10;
            winterIsComing = randomNumberBetween(4,7);
            System.out.println("Winter is coming!");
        }
    }

    private static int randomNumberBetween(int min, int max){
        return new Random().nextInt(max - min + 1) + min;
    }

    private static void clean(){
        Affiche.typeEnvahisseur.setText("");
        Affiche.nbForceEnvahisseur.setText("");
    }

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        main main = new main();
        Affiche = new GUI();
        Thread larve = new Thread(main);
        larve.start();

        java.util.Timer timer = new Timer();
        int begin = 1000; //timer starts after 1 second
        int timeinterval = 1 * 1000; //timer executes every 1 seconds
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //This code is executed at every interval defined by timeinterval (eg 10 seconds)
                //And starts after x milliseconds defined by begin.
                try {
                    if (!pause) {
                        if (temps >= 10) {
                            if (Math.random() < 0.05) ennemie();
                            else clean();
                            climat(); // Les probabilités se changent dans la fonction
                        }
                        creerFourmie();
                        ++temps;
                    }
                    ManageScreen();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        },begin, timeinterval);
    }
}
