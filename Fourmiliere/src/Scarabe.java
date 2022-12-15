public class Scarabe implements Predateur{
    int puissance;
    final int MIN = 10;
    final int MAX = 35;

    /**
     * Constructeur de la classe Scarabe
     */
    public Scarabe() {
        this.puissance = (int)(Math.random()*(MAX-MIN+1)+MIN);
    }

    /**
     * @return la puissance du scarabé
     */
    public int getPuissance() {
        return puissance;
    }

    /**
     * définit la puissance du scarabé
     * @param puissance
     */
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    /**
     * @return la puissance minimale d'un scarabé
     */
    public int getMIN() {
        return MIN;
    }

    /**
     * @return la puissance maximale d'un scarabé
     */
    public int getMAX() {
        return MAX;
    }
}
