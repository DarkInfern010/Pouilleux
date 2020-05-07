public class FileNoeud{
    Cellule Premier;

    FileNoeud() {
        Premier = null;
    }

    void Enfiler(Noeud n) {
        if (Premier == null) {
            Premier = new Cellule(n);
        } else {
            Cellule c = Premier;
            while (c.suivant != null) {
                c = c.suivant;
            }
            c.suivant = new Cellule(n);
        }
    }

    boolean EstVide() {
        return (Premier == null) ? true : false;
    }

    Noeud Defiler() {
        Cellule temp = Premier;
        Premier = Premier.suivant;
        return temp.noeud;
    }

    Noeud Premier() {
        return Premier.noeud;
    }
}
