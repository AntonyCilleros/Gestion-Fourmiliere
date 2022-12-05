public class GroupeSoldat extends GroupeFourmies {
    int puissance;

    public GroupeSoldat(int satiete, int nbFourmies, int nbMinFourmies) {
        super(satiete, nbFourmies, nbMinFourmies);
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
}
