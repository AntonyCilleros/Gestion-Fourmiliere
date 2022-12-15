import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame{
    private JLabel nombreDeFourmiesLabel;
    private JPanel panelMain;
    private JLabel nourritureLabel;
    private JLabel forceDeLaFourmilliereLabel;
    private JLabel nombreDeLarvesLabel;
    private JLabel soldatLabel;
    private JLabel infoAssaillantLabel;
    private JLabel typeDeLEnvahisseurLabel;
    private JLabel forceDeLEnvahisseurLabel;
    private JLabel nbSoldatLabel;
    private JLabel nbNourriciereLabel;
    private JLabel nombreAventurieresLabel;
    private JLabel tempsPasseLabel;
    private JButton pauseButton;
    private JButton moinsSoldatButton;
    private JButton plusSoldatButton;
    private JButton plusAventurieresButton;
    private JButton PlusNourricieresButton;
    private JButton moinsAventurieresButton;
    private JButton moinsNourricieresButton;
    private JLabel aventurieresLabel;
    private JLabel nourricieresLabel;
    private JButton creerUnNouveauCheminButton;
    public JLabel nbFourmiesLabel;
    public JLabel nbNourritureLabel;
    public JLabel puissanceLabel;
    public JLabel nbLarves;
    public JLabel partSoldats;
    public JLabel partAventurieres;
    public JLabel partNourricieres;
    public JLabel typeEnvahisseur;
    public JLabel nbForceEnvahisseur;
    public JLabel soldatTotal;
    public JLabel NourricieresTotal;
    public JLabel aventurieresTotal;
    public JLabel TempsPasseValeur;
    public JLabel HiverLabel;

    public double probaSoldats = 0.33;
    public double probaAventuriere = 0.33;
    public double probaNourrice = 0.33;

    public boolean pause = false;

    /**
     * Paramètre de l'interface graphique et ses listener
     */
    public GUI() {
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pause = !pause;
            }
        });
        moinsSoldatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(probaSoldats >= 0.1) {
                    probaSoldats -= 0.1;
                    probaNourrice += 0.05;
                    probaAventuriere += 0.05;
                    probaSoldats = Math.round(probaSoldats * 100.0) / 100.0;
                    probaNourrice = Math.round(probaNourrice * 100.0) / 100.0;
                    probaAventuriere = Math.round(probaAventuriere * 100.0) / 100.0;
                    partSoldats.setText(String.valueOf(probaSoldats));
                    partNourricieres.setText(String.valueOf(probaNourrice));
                    partAventurieres.setText(String.valueOf(probaAventuriere));
                }
            }
        });
        moinsAventurieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(probaAventuriere >= 0.1) {
                    probaAventuriere -= 0.1;
                    probaNourrice += 0.05;
                    probaSoldats += 0.05;
                    probaSoldats = Math.round(probaSoldats * 100.0) / 100.0;
                    probaNourrice = Math.round(probaNourrice * 100.0) / 100.0;
                    probaAventuriere = Math.round(probaAventuriere * 100.0) / 100.0;
                    partNourricieres.setText(String.valueOf(probaNourrice));
                    partSoldats.setText(String.valueOf(probaSoldats));
                    partAventurieres.setText(String.valueOf(probaAventuriere));
                }
            }
        });
        moinsNourricieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(probaNourrice >= 0.1) {
                    probaNourrice -= 0.1;
                    probaSoldats+= 0.05;
                    probaAventuriere += 0.05;
                    probaSoldats = Math.round(probaSoldats * 100.0) / 100.0;
                    probaNourrice = Math.round(probaNourrice * 100.0) / 100.0;
                    probaAventuriere = Math.round(probaAventuriere * 100.0) / 100.0;
                    partAventurieres.setText(String.valueOf(probaAventuriere));
                    partNourricieres.setText(String.valueOf(probaNourrice));
                    partSoldats.setText(String.valueOf(probaSoldats));
                }
            }
        });
        plusSoldatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (probaAventuriere >= 0.05 && probaNourrice >= 0.05) {
                    probaSoldats += 0.1;
                    probaAventuriere -= 0.05;
                    probaNourrice -= 0.05;
                    probaSoldats = Math.round(probaSoldats * 100.0) / 100.0;
                    probaNourrice = Math.round(probaNourrice * 100.0) / 100.0;
                    probaAventuriere = Math.round(probaAventuriere * 100.0) / 100.0;
                    partSoldats.setText(String.valueOf(probaSoldats));
                    partNourricieres.setText(String.valueOf(probaNourrice));
                    partAventurieres.setText(String.valueOf(probaAventuriere));
                }
            }
        });
        plusAventurieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (probaSoldats >= 0.05 && probaNourrice >= 0.05) {
                    probaAventuriere += 0.1;
                    probaSoldats -= 0.05;
                    probaNourrice -= 0.05;
                    probaSoldats = Math.round(probaSoldats * 100.0) / 100.0;
                    probaNourrice = Math.round(probaNourrice * 100.0) / 100.0;
                    probaAventuriere = Math.round(probaAventuriere * 100.0) / 100.0;
                    partAventurieres.setText(String.valueOf(probaAventuriere));
                    partNourricieres.setText(String.valueOf(probaNourrice));
                    partSoldats.setText(String.valueOf(probaSoldats));
                }
            }
        });
        PlusNourricieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (probaAventuriere >= 0.05 && probaSoldats >= 0.05) {
                    probaNourrice += 0.1;
                    probaAventuriere -= 0.05;
                    probaSoldats -= 0.05;
                    probaSoldats = Math.round(probaSoldats * 100.0) / 100.0;
                    probaNourrice = Math.round(probaNourrice * 100.0) / 100.0;
                    probaAventuriere = Math.round(probaAventuriere * 100.0) / 100.0;
                    partNourricieres.setText(String.valueOf(probaNourrice));
                    partAventurieres.setText(String.valueOf(probaAventuriere));
                    partSoldats.setText(String.valueOf(probaSoldats));
                }
            }
        });
        this.setContentPane(this.panelMain);
        this.setTitle("Fourmillière");
        this.setSize(800,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        partSoldats.setText(String.valueOf(probaSoldats));
        partAventurieres.setText(String.valueOf(probaAventuriere));
        partNourricieres.setText(String.valueOf(probaNourrice));
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
