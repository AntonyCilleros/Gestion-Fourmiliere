import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
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
                creerLarves();

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
        TimeUnit.SECONDS.sleep(3000);
    }

    public static void creerLarves() throws InterruptedException {
        Thread.currentThread().sleep(3000);
        fourmiliere.setNbLarves();
        fourmiliere.ajoutNourriture();
        fourmiliere.groupeFourmies.manger(fourmiliere);
        if(temps % 5 == 1){
            fourmiliere.groupeFourmies.naissance(fourmiliere);
        }
    }

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        main main = new main();
        Affiche = new GUI();
        Thread larve = new Thread(main);
        larve.start();
        for (int i = 0; i < 100; i++) {
            ManageScreen();
        }
    }
}
