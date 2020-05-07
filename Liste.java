public class Liste {
    private ElementListe premier;

    public ElementListe getPremier() {
        return premier;
    }

    public int getLongueur() // Complexité O(n)
    {
        ElementListe ElementCourant = this.getPremier();
        int compteur = 0;
        while (ElementCourant != null) {
            compteur++;
            ElementCourant = ElementCourant.getSuivant();
        }
        return compteur;
    }

    public void retirerPremiereOccurrence_R(int v){
        if (getLongueur() != 0)
        {
            premier=retirerPremiereOccurrence_Rec(premier,v);
        }
    }
    public ElementListe retirerPremiereOccurrence_Rec(ElementListe l, int v) {
        ElementListe retour=l;
        if (l!=null)
        {
            if (l.getValeur() == v) {
                retour= l.getSuivant();
            }
            else {
                l.setSuivant(retirerPremiereOccurrence_Rec(l.getSuivant(), v));
            }
        }
        return retour;
    }

    public void ajouterAuDebut(int v) {
        ElementListe ancienPremier = premier;
        premier = new ElementListe(v, ancienPremier);
    }

    public int Minimum()
    {
        ElementListe ElementCourant = this.getPremier();
        int min = ElementCourant.getValeur();
        while (ElementCourant != null) {
            if(min > ElementCourant.getValeur())
                min = ElementCourant.getValeur();
            ElementCourant = ElementCourant.getSuivant();
        }
        return min;
    }

    public Liste tri_Minimum() {
        Liste l = new Liste();
        while(getLongueur() > 0) {
            int min = Minimum();
            l.ajouterAuDebut(min);
            retirerPremiereOccurrence_R(min);
        }
        return l;
    }

    public void Afficher()
    {
        String res = "";
        ElementListe temp = premier;
        while (temp.getSuivant() != null) {
            res += " " + temp.getValeur() + " -";
            temp = temp.getSuivant();
        }
        System.out.println(res.substring(0, res.length() - 1));
    }
}
