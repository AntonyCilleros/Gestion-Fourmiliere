public class Scarabe implements Predateur{
    int puissance;
    final int MIN = 10;
    final int MAX = 35;
    public Scarabe() {
        this.puissance = (int)(Math.random()*(MAX-MIN+1)+MIN);
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getMIN() {
        return MIN;
    }

    public int getMAX() {
        return MAX;
    }
}
