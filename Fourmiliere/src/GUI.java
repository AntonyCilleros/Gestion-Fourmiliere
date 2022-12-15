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
    public JLabel partSoldats;
    public JLabel partAventurieres;
    public JLabel partNourricieres;
    private JLabel typeEnvahisseur;
    public JLabel nbForceTotal;
    public JLabel soldatTotal;
    public JLabel NourricieresTotal;
    public JLabel aventurieresTotal;
    public JLabel TempsPasseValeur;

    public double probaSoldats = 0.33;
    public double probaAventuriere = 0.33;
    public double probaNourrice = 0.33;

    public GUI() {
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // met en pause le temps
            }
        });
        moinsSoldatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(probaSoldats <= 0.1) {
                    probaSoldats -= 0.1;
                    probaNourrice += 0.05;
                    probaAventuriere += 0.05;
                }
            }
        });
        moinsAventurieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(probaAventuriere <= 0.1) {
                    probaAventuriere -= 0.1;
                    probaNourrice += 0.05;
                    probaSoldats += 0.05;
                }            }
        });
        moinsNourricieresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(probaNourrice <= 0.1) {
                    probaNourrice -= 0.1;
                    probaSoldats+= 0.05;
                    probaAventuriere += 0.05;
                }            }
        });
        plusSoldatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (probaAventuriere >= 0.05 && probaNourrice >= 0.05) {
                    probaSoldats += 0.1;
                    probaAventuriere -= 0.05;
                    probaNourrice -= 0.05;
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
                }
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
