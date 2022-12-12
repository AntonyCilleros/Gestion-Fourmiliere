import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.time.chrono.ThaiBuddhistEra;
import java.util.concurrent.TimeUnit;

public class main implements Runnable{
    static GUI Affiche;
    static Reine reine = new Reine();
    static Fourmiliere fourmiliere = new Fourmiliere(reine);
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
        TimeUnit.SECONDS.sleep(5);
    }

    public static void creerFourmie() throws InterruptedException {
        Thread.currentThread().sleep(1000);
        fourmiliere.setNbLarves();
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
