public class Terminator implements Predateur{
    int puissance;
    final int MIN = 10000;
    final int MAX = 100000;

    /**
     * Constructeur de la classe Terminator
     */
    public Terminator() {
        this.puissance = (int)(Math.random()*(MAX-MIN+1)+MIN);
    }

    /**
     * @return la puissance du terminator
     */
    public int getPuissance() {
        return puissance;
    }

    /**
     * définit la puissance du terminator
     * @param puissance
     */
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    /**
     * @return la puissance minimale d'un terminator
     */
    public int getMIN() {
        return MIN;
    }

    /**
     * @return la puissance maximale d'un terminator
     */
    public int getMAX() {
        return MAX;
    }
}
