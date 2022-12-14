import java.util.ArrayList;

public class Fourmiliere {
    Reine reine;
    int nbNourriture = 20;
    int nbLarves = 0;

    GroupeFourmies groupeFourmies;

    public Fourmiliere(Reine reine, GroupeFourmies groupeFourmies) {
        this.reine = reine;
        this.groupeFourmies = groupeFourmies;
    }

    public int getNbNourriture() {
        return nbNourriture;
    }

    public void setNbNourriture(int nbNourriture) {
        this.nbNourriture = nbNourriture;
    }

    public int getPuissance() {
        return groupeFourmies.groupeAventuriere.getPuissance() + groupeFourmies.groupeSoldat.getPuissance() + groupeFourmies.groupeNourrice.getPuissance();
    }

    public int getNombreFourmies() {
        return groupeFourmies.getNbFourmies();
    }

    public void setNbLarves(){
        nbLarves += getNombreFourmies() / 2;
    }

    public int getNbLarves(){
        return nbLarves;
    }

    public int getNbSoldat() {
        return groupeFourmies.groupeSoldat.getNbSoldat();
    }

    public int getNbNourriciere() {
        return groupeFourmies.groupeNourrice.getNbNourrice();
    }

    public int getNbAventuriere() {
        return groupeFourmies.groupeAventuriere.getNbAventuriere();
    }

    public void ajoutNourriture() {
        setNbNourriture(nbNourriture += getNbAventuriere()*3);  // récupere bouffe par rapport au nombre d'aventurieres
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
