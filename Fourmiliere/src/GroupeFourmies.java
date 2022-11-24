public class GroupeFourmies {
    int satiete;
    int nbFourmies;
    int nbMaxFourmies;
    int nbMinFourmies;
    Fourmiliere fourmiliere;

    public GroupeFourmies(int satiete, int nbFourmies, int nbMaxFourmies, int nbMinFourmies) {
        this.satiete = satiete;
        this.nbFourmies = nbFourmies;
        this.nbMaxFourmies = nbMaxFourmies;
        this.nbMinFourmies = nbMinFourmies;
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
}
