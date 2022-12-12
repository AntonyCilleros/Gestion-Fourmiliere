public class GroupeSoldat extends GroupeFourmies {
    int puissance = 1;

    public GroupeSoldat() {

    }

    public int getPuissance() {
        return puissance*nbFourmies;
    }
}
