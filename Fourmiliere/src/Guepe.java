public class Guepe implements Predateur{
    int puissance;
    final int MIN = 70;
    final int MAX = 120;

    /**
     * Constructeur de la classe Guepe
     */
    public Guepe() {
        this.puissance = (int)(Math.random()*(MAX-MIN+1)+MIN);
    }

    /**
     * @return la puissance de la guêpe
     */
    public int getPuissance() {
        return puissance;
    }

    /**
     * définit la puissance de la guêpe
     * @param puissance
     */
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    /**
     * @return la puissance minimale d'une guêpe
     */
    public int getMIN() {
        return MIN;
    }

    /**
     * @return la puissance maximale d'une guêpe
     */
    public int getMAX() {
        return MAX;
    }
}
