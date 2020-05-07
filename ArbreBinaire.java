class ArbreBinaire{
    Noeud racine;

    ArbreBinaire() {
        racine = null;
    }

    void Afficher() {
        AfficherNoeud(racine, 0);
    }

    boolean EstVide() {
        if (racine == null) {
            return true;
        } else {
            return false;
        }
    }

    void AfficherNoeud(Noeud n, int niveau) {
        for (int i = 0; i < niveau; i++) {
            System.out.print("    ");
        }
        System.out.println("|-->"+n.valeur);
        if (n.filsDroit == null) {
            if (n.filsGauche != null) {
                AfficherNoeud(n.filsGauche, niveau+1);
            }
        } else {
            AfficherNoeud(n.filsDroit, niveau+1);
            if (n.filsGauche != null) {
                AfficherNoeud(n.filsGauche, niveau+1);
            }
        }
    }

    void Ajouter(int v) {
        if(racine == null) {
            racine = new Noeud(v);
        }
        else {
            AjouterNoeud(racine ,v);
        }
    }

    void AjouterNoeud(Noeud r, int v) {
        if (v < r.valeur) {
            if (r.filsGauche == null) {
                r.filsGauche = new Noeud(v);
            } else {
                AjouterNoeud(r.filsGauche, v);
            }
        } else {
            if (r.filsDroit == null) {
                r.filsDroit = new Noeud(v);
            } else {
                AjouterNoeud(r.filsDroit, v);
            }
        }
    }

    String ParcoursLargeur() {
        FileNoeud f = new FileNoeud();
        f.Enfiler(racine);

        String res = "";
        while(!f.EstVide()) {
            Noeud n = f.Defiler();
            res += n.valeur+";";

            if (n.filsGauche != null) {
                f.Enfiler(n.filsGauche);
            }
            if (n.filsDroit != null) {
                f.Enfiler(n.filsDroit);
            }
        }
        return res;
    }

    boolean Recherche(int v) {
        return (RechercheNoeud(racine, v) != null);
    }

    Noeud RechercheNoeud(Noeud n, int v) {
        if(n == null || n.valeur == v)
            return n;
        if(v < n.valeur)
            return RechercheNoeud(n.filsGauche, v);
        else
            return RechercheNoeud(n.filsDroit, v);
    }
}
