public class ManteReligieuse implements Predateur{
    int puissance;
    final int MIN = 70;
    final int MAX = 100;

    /**
     * Constructeur de la classe ManteReligieuse
     */
    public ManteReligieuse() {
        this.puissance = (int)(Math.random()*(MAX-MIN+1)+MIN);
    }

    /**
     * @return la puissance de la mante religieuse
     */
    public int getPuissance() {
        return puissance;
    }

    /**
     * définit la puissance de la mante religieuse
     * @param puissance
     */
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    /**
     * @return la puissance minimale d'une mante religieuse
     */
    public int getMIN() {
        return MIN;
    }

    /**
     * @return la puissance maximale d'une mante religieuse
     */
    public int getMAX() {
        return MAX;
    }
}
