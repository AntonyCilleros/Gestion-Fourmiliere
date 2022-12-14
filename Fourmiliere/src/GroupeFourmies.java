public class GroupeFourmies {
    int nbFourmies;
    Fourmiliere fourmiliere;
    GroupeSoldat groupeSoldat;
    GroupeAventuriere groupeAventuriere;
    GroupeNourrice groupeNourrice;

    public GroupeFourmies(GroupeSoldat groupeSoldat, GroupeNourrice groupeNourrice, GroupeAventuriere groupeAventuriere) {
        this.groupeNourrice = groupeNourrice;
        this.groupeSoldat = groupeSoldat;
        this.groupeAventuriere = groupeAventuriere;
    }


    public void meurt(Fourmies ... fourmies) {
        fourmiliere.setNbNourriture(fourmiliere.getNbNourriture()+10);
    }

    public void naissance(Fourmiliere fourmilieres) {
        groupeAventuriere.nbAventuriere += fourmilieres.nbLarves / 3;
        groupeSoldat.nbSoldat += fourmilieres.nbLarves / 3;
        groupeNourrice.nbNourrice += fourmilieres.nbLarves / 3;
        fourmilieres.nbLarves = 0;
    }

    public void manger(Fourmiliere fourmilieres) {
        fourmilieres.setNbNourriture(fourmilieres.getNbNourriture()- fourmilieres.getNombreFourmies());
    }

    public int getNbFourmies() {
        return groupeAventuriere.getNbAventuriere() + groupeSoldat.getNbSoldat() + groupeNourrice.getNbNourrice();
    }
}
