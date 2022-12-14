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
    private JLabel forceTotalLabel;
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
    private JLabel puissanceLabel;
    public JLabel nbLarves;
    private JLabel partSoldats;
    private JLabel partAventurieres;
    private JLabel partNourricieres;
    private JLabel typeEnvahisseur;
    public JLabel nbForceTotal;
    public JLabel soldatTotal;
    public JLabel NourricieresTotal;
    public JLabel aventurieresTotal;
    public JLabel TempsPasseValeur;
    private JLabel nbNourritureEnTransport;

    public GUI() {
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // met en pause le temps
            }
        });
        creerUnNouveauCheminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // creer un nouveau chemin pas sur qu'on le garde
            }
        });
        moinsSoldatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // baisse la proba de soldats
            }
        });
        moinsAventurieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // baisse la proba d'aventurieres
            }
        });
        moinsNourricieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //baisse la porba de nourricieres
            }
        });
        plusSoldatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //augmente la proba de soldats
            }
        });
        plusAventurieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //augmente la proba d'aventurieres
            }
        });
        PlusNourricieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //augmente la proba de nourricieres
            }
        });
        this.setContentPane(this.panelMain);
        this.setTitle("Fourmillière");
        this.setSize(800,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
