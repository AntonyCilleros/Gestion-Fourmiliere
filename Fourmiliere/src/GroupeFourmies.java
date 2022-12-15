import java.util.Random;

public class GroupeFourmies {
    int nbFourmies;

    int derniereFourmis;
    Fourmiliere fourmiliere;
    GroupeSoldat groupeSoldat;
    GroupeAventuriere groupeAventuriere;
    GroupeNourrice groupeNourrice;

    public GroupeFourmies(GroupeSoldat groupeSoldat, GroupeNourrice groupeNourrice, GroupeAventuriere groupeAventuriere) {
        this.groupeNourrice = groupeNourrice;
        this.groupeSoldat = groupeSoldat;
        this.groupeAventuriere = groupeAventuriere;
    }


    public void meurtDeVieillesse(Fourmiliere fourmilieres) {
        for (int i=0; i < derniereFourmis; ++i){
            int condamne = new Random().nextInt(fourmilieres.getNombreFourmies() - 1 + 1) + 1;
            if (condamne > fourmilieres.getNbAventuriere()){
                if (condamne > fourmilieres.getNbAventuriere() + fourmilieres.getNbNourriciere()){
                    fourmilieres.groupeFourmies.groupeSoldat.nbSoldat -= 1;
                    fourmilieres.setNbNourriture(fourmilieres.getNbNourriture()+1);
                }
                else {
                    fourmilieres.groupeFourmies.groupeNourrice.nbNourrice -= 1;
                    fourmilieres.setNbNourriture(fourmilieres.getNbNourriture()+1);
                }
            }
            else {
                fourmilieres.groupeFourmies.groupeAventuriere.nbAventuriere -= 1;
                fourmilieres.setNbNourriture(fourmilieres.getNbNourriture()+1);
            }
        }
    }

    public void meurtDeFaim(Fourmiliere fourmilieres) {
        if(fourmilieres.nbNourriture <= 0) {
            int fourmisFamine = (int) (nbFourmies * 0.1);
            System.out.println(fourmisFamine);
            for (int i = 0; i < fourmisFamine; ++i) {
                int condamne = new Random().nextInt(fourmilieres.getNombreFourmies() - 1 + 1) + 1;
                if (condamne > fourmilieres.getNbAventuriere()) {
                    if (condamne > fourmilieres.getNbAventuriere() + fourmilieres.getNbNourriciere()) {
                        fourmilieres.groupeFourmies.groupeSoldat.nbSoldat -= 1;
                        fourmilieres.setNbNourriture(fourmilieres.getNbNourriture() + 1);
                    } else {
                        fourmilieres.groupeFourmies.groupeNourrice.nbNourrice -= 1;
                        fourmilieres.setNbNourriture(fourmilieres.getNbNourriture() + 1);
                    }
                } else {
                    fourmilieres.groupeFourmies.groupeAventuriere.nbAventuriere -= 1;
                    fourmilieres.setNbNourriture(fourmilieres.getNbNourriture() + 1);
                }
            }
        }
    }

    public void naissance(Fourmiliere fourmilieres, double soldat, double nourrice, double aventuriere) {
        if(groupeNourrice.getNbNourrice() >= fourmilieres.nbLarves){
            derniereFourmis = fourmilieres.nbLarves;
            groupeAventuriere.nbAventuriere += fourmilieres.nbLarves * aventuriere;
            groupeSoldat.nbSoldat += fourmilieres.nbLarves * soldat;
            groupeNourrice.nbNourrice += fourmilieres.nbLarves * nourrice;
        }
        else {
            derniereFourmis = groupeNourrice.nbNourrice;
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
