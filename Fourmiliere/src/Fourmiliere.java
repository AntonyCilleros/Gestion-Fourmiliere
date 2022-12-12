import java.util.ArrayList;

public class Fourmiliere {
    Reine reine;
    int nbNourriture;
    int nbLarves = 0;
    GroupeSoldat groupeSoldat;
    GroupeNourrice groupeNourrice;
    GroupeAventuriere groupeAventuriere;

    public Fourmiliere(Reine reine) {
        this.reine = reine;
        this.groupeAventuriere = new GroupeAventuriere();
        this.groupeNourrice = new GroupeNourrice();
        this.groupeSoldat = new GroupeSoldat();
    }

    public int getNbNourriture() {
        return nbNourriture;
    }

    public void setNbNourriture(int nbNourriture) {
        this.nbNourriture = nbNourriture;
    }

    public int getPuissance() {
        return groupeSoldat.getPuissance();
    }

    public int getNombreFourmies() {
        return getNbSoldat() + getNbNourriciere() + getNbAventuriere();
    }

    public void setNbLarves(){
        nbLarves += getNombreFourmies() / 2;
    }

    public int getNbLarves(){
        return nbLarves;
    }

    public int getNbSoldat() {
        return groupeSoldat.getNbFourmies();
    }

    public int getNbNourriciere() {
        return groupeNourrice.getNbFourmies();
    }

    public int getNbAventuriere() {
        return groupeAventuriere.getNbFourmies();
    }

    public void ajoutNourriture() {
        setNbNourriture(getNbAventuriere());  // récupere bouffe par rapport au nombre d'aventurieres
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
