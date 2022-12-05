import java.util.ArrayList;

public class Fourmiliere {
    Reine reine;
    int nbNourriture;
    int nbLarves;
    int puissance;
    ArrayList<GroupeFourmies> groupesFourmies;

    public Fourmiliere(Reine reine, int nbNourriture) {
        this.reine = reine;
        this.nbNourriture = nbNourriture;
        this.groupesFourmies = new ArrayList<GroupeFourmies>();
    }

    public int getNbNourriture() {
        return nbNourriture;
    }

    public void setNbNourriture(int nbNourriture) {
        this.nbNourriture = nbNourriture;
    }

    public void addGroupeFourmies(GroupeFourmies gf){
        groupesFourmies.add(gf);
    }
    public void delEmptyGroupeFourmies(){
        for (int i=0; i < groupesFourmies.size(); ++i){
            if (groupesFourmies.get(i).nbFourmies == 0) groupesFourmies.remove(i);
        }
    }

    public void refreshPuissance() {
        puissance = 0;
        for (GroupeFourmies groupe : groupesFourmies){
            if (groupe.getClass().getName() == "GroupeSoldat")
                puissance += groupe.nbFourmies;
        }
    }

    public int getPuissance() {
        return puissance;
    }
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
