import java.util.ArrayList;

public class Fourmiliere {
    Reine reine;
    int nbNourriture = 100;
    int nbLarves = 10;

    GroupeFourmies groupeFourmies;

    /**
     * Constructeur de la classe Fourmiliere
     * @param reine
     * @param groupeFourmies
     */
    public Fourmiliere(Reine reine, GroupeFourmies groupeFourmies) {
        this.reine = reine;
        this.groupeFourmies = groupeFourmies;
    }

    /**
     * @return la quantité de nourriture de la fourmilière
     */
    public int getNbNourriture() {
        return nbNourriture;
    }

    /**
     * définit la quantité de nourriture de la fourmilière
     * @param nbNourriture correspond à la quantité de nourriture
     */
    public void setNbNourriture(int nbNourriture) {
        this.nbNourriture = nbNourriture;
    }

    /**
     * @return la puissance de la fourmilière
     */
    public int getPuissance() {
        return groupeFourmies.groupeSoldat.getPuissance();
    }

    /**
     * @return la quantité de fourmie dans la fourmilière
     */
    public int getNombreFourmies() {
        return groupeFourmies.getNbFourmies();
    }

    public void setNbLarves(){
        nbLarves += getNombreFourmies() / 2;
    }

    /**
     * @return la quantité de larve dans la fourmilière
     */
    public int getNbLarves(){
        return nbLarves;
    }

    /**
     * @return la quantité de Soldat dans la fourmilière
     */
    public int getNbSoldat() {
        return groupeFourmies.groupeSoldat.getNbSoldat();
    }

    /**
     * @return la quantité de nourriciere dans la fourmilière
     */
    public int getNbNourriciere() {
        return groupeFourmies.groupeNourrice.getNbNourrice();
    }

    /**
     * @return la quantité d'aventurière dans la fourmilière
     */
    public int getNbAventuriere() {
        return groupeFourmies.groupeAventuriere.getNbAventuriere();
    }

    /**
     * @return la quantité de nourriture dans la fourmilière
     */
    public void ajoutNourriture(int i) {
        setNbNourriture(nbNourriture += getNbAventuriere()*i);  // récupere bouffe par rapport au nombre d'aventurieres
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
