import java.util.ArrayList;

public class Fourmiliere {
    int id;
    Reine reine;
    int force;
    int nbNourriture;
    int nbFourmies;
    int nbLarves;
    ArrayList<GroupeFourmies> groupesFourmies;

    public int getNbNourriture() {
        return nbNourriture;
    }

    public void setNbNourriture(int nbNourriture) {
        this.nbNourriture = nbNourriture;
    }
}
