public class ElementListe {

    private int valeur;
    private ElementListe suivant;

    ElementListe(int valeur, ElementListe suivant)
    {
        this.valeur = valeur;
        this.suivant = suivant;
    }

    public ElementListe(int v) {
        this.valeur = v;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public ElementListe getSuivant() {
        return suivant;
    }

    public void setSuivant(ElementListe suivant) {
        this.suivant = suivant;
    }
}

