public class ManteReligieuse implements Predateur{
    int puissance;
    final int MIN = 700;
    final int MAX = 1000;
    public ManteReligieuse() {
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
