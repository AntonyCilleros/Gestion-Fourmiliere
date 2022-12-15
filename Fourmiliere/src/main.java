import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.time.chrono.ThaiBuddhistEra;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class main implements Runnable{
    static GUI Affiche;
    static Reine reine = new Reine();
    static GroupeFourmies groupeFourmies = new GroupeFourmies(new GroupeSoldat(),new GroupeNourrice(),new GroupeAventuriere());
    static Fourmiliere fourmiliere = new Fourmiliere(reine, groupeFourmies);
    static int temps = 0;

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
        Affiche.TempsPasseValeur.setText("" + ++temps);
        Affiche.nbLarves.setText("" + fourmiliere.getNbLarves());
        Affiche.nbFourmiesLabel.setText("" + fourmiliere.getNombreFourmies());
        Affiche.soldatTotal.setText("" + fourmiliere.getNbSoldat());
        Affiche.NourricieresTotal.setText("" + fourmiliere.getNbNourriciere());
        Affiche.aventurieresTotal.setText("" + fourmiliere.getNbAventuriere());
        Affiche.nbNourritureLabel.setText("" + fourmiliere.getNbNourriture());
        Affiche.nbForceTotal.setText("" + fourmiliere.getPuissance());
    }

    public static void creerFourmie() throws InterruptedException {
        fourmiliere.setNbLarves();
        fourmiliere.ajoutNourriture();
        fourmiliere.groupeFourmies.manger(fourmiliere);
        if(temps % 5 == 1){
            fourmiliere.groupeFourmies.naissance(fourmiliere);
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
        if (ennemie.getPuissance() > fourmiliere.getPuissance()){
            if (ennemie.getPuissance() >= fourmiliere.getPuissance()*3){
                System.out.println("Toutes les fourmies sont mortes.");
                while(true);
            }
            int perte = new Random().nextInt(80 - 70 + 1) + 70;
            System.out.println("Ennemi plus fort");
            System.out.println("Avant attaque : " + fourmiliere.getNombreFourmies());
            mort(fourmiliere.getNombreFourmies()*(perte/100));
            System.out.println("Après attaque : " + fourmiliere.getNombreFourmies());
        }
        else {
            int perte = new Random().nextInt(10 - 5 + 1) + 5;
            System.out.println("Fourmies gagnent");
            System.out.println("Avant attaque : " + fourmiliere.getNombreFourmies());
            mort(perte);
            System.out.println("Après attaque : " + fourmiliere.getNombreFourmies());
        }
    }

    private static void mort(int perte){
        for (int i=0; i < perte; ++i){
            int condamne = new Random().nextInt(fourmiliere.getNombreFourmies() - 1 + 1) + 1;
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

    private static void evenement(){
        final double evenement = (Math.random());
        if (evenement < 0.5) ennemie();
        else if (evenement < 0.75) System.out.println("Un évènement de type climat se produit wallah");
        else System.out.println("C'est l'hiver");
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
                    if (temps >= 5 && Math.random() < 1) evenement();
                    ManageScreen();
                    creerFourmie();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        },begin, timeinterval);
    }
}
