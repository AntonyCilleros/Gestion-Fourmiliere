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


    public void meurt() {

        fourmiliere.setNbNourriture(fourmiliere.getNbNourriture()+1);
    }

    public void naissance(Fourmiliere fourmilieres, double soldat, double nourrice, double aventuriere) {
        if(groupeNourrice.getNbNourrice() >= fourmilieres.nbLarves){
            groupeAventuriere.nbAventuriere += fourmilieres.nbLarves * aventuriere;
            groupeSoldat.nbSoldat += fourmilieres.nbLarves * soldat;
            groupeNourrice.nbNourrice += fourmilieres.nbLarves * nourrice;
        }
        else {
            groupeAventuriere.nbAventuriere += groupeNourrice.nbNourrice * aventuriere;
            groupeSoldat.nbSoldat += groupeNourrice.nbNourrice * soldat;
            groupeNourrice.nbNourrice += groupeNourrice.nbNourrice * nourrice;
        }
        fourmilieres.nbLarves = 0;
    }

    public void manger(Fourmiliere fourmilieres) {
        if (fourmilieres.getNbNourriture() > 0) {
            if (fourmilieres.getNbNourriture() < fourmilieres.getNombreFourmies()) {
                fourmilieres.setNbNourriture(0);
            }
            else fourmilieres.setNbNourriture(fourmilieres.getNbNourriture() - fourmilieres.getNombreFourmies());
        }
    }

    public int getNbFourmies() {
        return groupeAventuriere.getNbAventuriere() + groupeSoldat.getNbSoldat() + groupeNourrice.getNbNourrice();
    }
}
