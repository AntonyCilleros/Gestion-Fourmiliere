public interface Predateur {
    /**
     * @return la puissance du prédateur
     */
    int getPuissance();
    /**
     * définit la puissance du prédateur
     * @param puissance
     */
    void setPuissance(int puissance);
    /**
     * @return la puissance minimale d'un prédateur
     */
    int getMIN();
    /**
     * @return la puissance maximale d'un prédateur
     */
    int getMAX();
}
