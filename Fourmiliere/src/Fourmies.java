public class Fourmies {
    int dureeDeVie;
    Sexe sexe;

    public Fourmies(int dureeDeVie, Sexe sexe) {
        this.dureeDeVie = dureeDeVie;
        this.sexe = sexe;
    }

    public void seReproduire() {
        if (this.sexe == Sexe.MALE) {
            Larve larve = new Larve();
        }
    }
}
