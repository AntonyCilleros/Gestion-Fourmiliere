public class GroupeSoldat extends GroupeFourmies {
    int puissance;

    public GroupeSoldat() {

    }

    public int getPuissance() {
        return puissance*nbFourmies;
    }
}
