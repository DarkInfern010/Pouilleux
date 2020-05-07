import java.util.ArrayList;
import java.util.Collections;

public class main {
    public static PileTab JeuDeCarte; // Jeu de carte sous forme (de pile)
    public static ArbreBinaire joueur1; // Joueur 1 sous forme (d'arbre binaire)
    public static ArbreBinaire joueur2; // Joueur 2 sous forme (d'arbre binaire)
    public static Liste tabScore; // Tableau des scores sous forme (de Liste Chainée)

    public static void main(String[] args) {
        tabScore = new Liste(); //Init du tableau des scores

        // Déroulement des x Partis
        for (int i = 0; i < 10; i++) {
            System.out.println("\n--------Début de la partie--------");
            JeuDeCarte = new PileTab(); // Init du jeu de carte
            creation_du_JeuDeCarte(); // Création du jeu de carte
            melange_du_JeuDeCarte(); // Melange du jeu de carte
            System.out.println("--------Jeu de Carte--------");
            JeuDeCarte.Afficher(); // Affichage du jeu de carte

            joueur1 = new ArbreBinaire(); // Init du joueur 1
            joueur2 = new ArbreBinaire(); // Init du joueur 2
            distribuer_le_JeuDeCarte(); // Distribution de la moitié du jeu de carte à chaque joueur
            System.out.println("--------Distribution--------");
            System.out.println("----------Joueur 1----------");
            joueur1.Afficher(); // Affichage de la main du joueur 1
            System.out.println("\n----------Joueur 2----------");
            joueur2.Afficher(); // Affichage de la main du joueur 2

            supprimer_joueur1(); // Des cartes ayant la même valeur dans la main du joueur 1
            supprimer_joueur2(); // Des cartes ayant la même valeur dans la main du joueur 2
            System.out.println("\n--------Nouvelle Main--------");
            System.out.println("----------Joueur 1----------");
            joueur1.Afficher(); // Affichage de la nouvelle main du joueur 1
            System.out.println("\n----------Joueur 2----------");
            joueur2.Afficher(); // Affichage de la nouvelle main du joueur 2

            int joueurVictorieux = victoire(); // Récupération du joueur gagnant (ne possédant pas le pouilleux, valeur 111)
            if (joueurVictorieux == 1) { // Cas où joueur 1 gagne
                System.out.println("\n----------Gagnant Joueur 1----------");
                int scorePartie = CalculScore(1); // Calcul du score du joueur 1
                System.out.println("------------Score : " + scorePartie + "------------");
                tabScore.ajouterAuDebut(scorePartie); // Ajout du score du joueur 1 au tableau
            } else { // Cas où joueur 2 gagne
                System.out.println("\n----------Gagnant Joueur 2----------");
                int scorePartie = CalculScore(2); // Calcul du score du joueur 2
                System.out.println("------------Score : " + scorePartie + "------------");
                tabScore.ajouterAuDebut(scorePartie); // Ajout du score du joueur 2 au tableau
            }
        }
        System.out.println("\n----------Tableau des scores----------");
        tabScore.Afficher(); // Affichage du tableau des scores non trié
        tabScore = tabScore.tri_Minimum(); // Tri du tableau des scores
        tabScore.Afficher(); // Affichage du tableau des scores trié
    }

    // Méthode de création du jeu de carte
    public static void creation_du_JeuDeCarte() {
        int[] valeur = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13 }; //Carte de 1 à 9, Dame et King
        int[] couleur = { 100, 200, 300, 400 }; //Couleur (Trèfle, Carreau, Coeur, Pique)

        for (int i = 0; i < couleur.length; i++) {
            for (int j = 0; j < valeur.length; j++) {
                JeuDeCarte.Empiler(couleur[i] + valeur[j]);
                if (i == 0 && j == 9) {
                    JeuDeCarte.Empiler(111);
                }
            }
        }
    }

    // Méthode pour mélanger le jeu de carte
    public static void melange_du_JeuDeCarte() {
        ArrayList<Integer> valeur = new ArrayList<Integer>();
        while (!JeuDeCarte.EstVide()) {
            valeur.add(JeuDeCarte.Depiler());
        }
        Collections.shuffle(valeur);
        Collections.shuffle(valeur);
        Collections.shuffle(valeur);
        for (int i = 0; i < valeur.size(); i++) {
            JeuDeCarte.Empiler(valeur.get(i));
        }
    }

    // Méthode pour distribuer le jeu de carte
    public static void distribuer_le_JeuDeCarte() {
        for (int i = 0; i < 49; i++) {
            int valeur = JeuDeCarte.Depiler();
            if (i % 2 == 0) joueur1.Ajouter(valeur);
            else joueur2.Ajouter(valeur);
        }
    }

    // Méthodes de suppression des cartes ayant la même valeurs
    public static void supprimer_joueur1() {
        String main_joueur1 = joueur1.ParcoursLargeur();
        String[] div = main_joueur1.split(";");
        ArrayList<Integer> ArrayMainJoueur1 = new ArrayList<Integer>();
        for (int i = 0; i < div.length; i++) { ArrayMainJoueur1.add(Integer.parseInt(div[i])); }
        ArrayList<Integer> TabSuppr = new ArrayList<Integer>();
        for (int x = 0; x < ArrayMainJoueur1.size(); x++) {
            String verifNombreSuppr = ArrayMainJoueur1.get(x).toString().substring(1,3);
            for (int y = x + 1; y < ArrayMainJoueur1.size(); y++) {
                String verifNombre = ArrayMainJoueur1.get(y).toString().substring(1,3);
                if (verifNombreSuppr.equals(verifNombre)) {
                    TabSuppr.add(ArrayMainJoueur1.get(x));
                    TabSuppr.add(ArrayMainJoueur1.get(y));
                }
            }
        }
        for (int a = 0; a < TabSuppr.size(); a++){ ArrayMainJoueur1.remove(TabSuppr.get(a)); }
        joueur1 = new ArbreBinaire();
        for (int b = 0; b < ArrayMainJoueur1.size(); b++) { joueur1.Ajouter(ArrayMainJoueur1.get(b)); }
    }
    public static void supprimer_joueur2() {
        String main_joueur2 = joueur2.ParcoursLargeur();
        String[] div = main_joueur2.split(";");
        ArrayList<Integer> ArrayMainJoueur2 = new ArrayList<Integer>();
        for (int i = 0; i < div.length; i++) { ArrayMainJoueur2.add(Integer.parseInt(div[i])); }
        ArrayList<Integer> TabSuppr = new ArrayList<Integer>();
        for (int x = 0; x < ArrayMainJoueur2.size(); x++) {
            String verifNombreSuppr = ArrayMainJoueur2.get(x).toString().substring(1,3);
            for (int y = x + 1; y < ArrayMainJoueur2.size(); y++) {
                String verifNombre = ArrayMainJoueur2.get(y).toString().substring(1,3);
                if (verifNombreSuppr.equals(verifNombre)) {
                    TabSuppr.add(ArrayMainJoueur2.get(x));
                    TabSuppr.add(ArrayMainJoueur2.get(y));
                }
            }
        }
        for (int a = 0; a < TabSuppr.size(); a++){ ArrayMainJoueur2.remove(TabSuppr.get(a)); }
        joueur2 = new ArbreBinaire();
        for (int b = 0; b < ArrayMainJoueur2.size(); b++) { joueur2.Ajouter(ArrayMainJoueur2.get(b)); }
    }

    // Méthode retournant le vainqueur
    public static int victoire() {
        return joueur1.Recherche(111) ? 2 : 1;
    }

    // Méthode calculant le score (addition de tous les cartes)
    public static int CalculScore(int joueur) {
        int score = 0;
        if (joueur == 1) {
            String main_joueur1 = joueur1.ParcoursLargeur();
            String[] div = main_joueur1.split(";");
            ArrayList<Integer> ArrayMainJoueur1 = new ArrayList<Integer>();
            for (int i = 0; i < div.length; i++) { ArrayMainJoueur1.add(Integer.parseInt(div[i])); }
            for (int j = 0; j < ArrayMainJoueur1.size(); j++) { score += ArrayMainJoueur1.get(j); }
        } else {
            String main_joueur2 = joueur2.ParcoursLargeur();
            String[] div = main_joueur2.split(";");
            ArrayList<Integer> ArrayMainJoueur2 = new ArrayList<Integer>();
            for (int i = 0; i < div.length; i++) { ArrayMainJoueur2.add(Integer.parseInt(div[i])); }
            for (int j = 0; j < ArrayMainJoueur2.size(); j++) { score += ArrayMainJoueur2.get(j); }
        }
        return score;
    }

}
