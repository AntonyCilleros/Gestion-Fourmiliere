public class GroupeFourmies {
    int satiete;
    int nbFourmies = 2;
    Fourmiliere fourmiliere;

    public GroupeFourmies() {
    }

    public void meurt(Fourmies ... fourmies) {
        fourmiliere.setNbNourriture(fourmiliere.getNbNourriture()+10);
        for (Fourmies fourmie : fourmies) {
            nbFourmies--;
        }
    }

    public void naissance(Larve ... larves) {
        for (Larve larve : larves) {
            nbFourmies++;
            //faire un truc pour les larves
        }
    }

    public void manger(int nbNourriture) {
        satiete += nbNourriture;
        fourmiliere.setNbNourriture(fourmiliere.getNbNourriture()-nbNourriture);
    }

    public int getNbFourmies() {
        return nbFourmies;
    }
}
