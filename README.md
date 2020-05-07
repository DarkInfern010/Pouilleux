# Pouilleux!
---
Dans cette version du pouilleux simplifier il n'y a de possibilité de jouer et le déroulement du jeu est largement simplifié. Les cartes sont distribué, puis le jeu supprime les cartes devant être supprimé, et enfin le perdant est désigné si il possède la carte du pouilleux (Valet de Trèfle).


# Fonctionnement
---
Rien de plus simple, lancer le "main"et le programme va exécuter 10 parties d'affiler. Le programme va afficher les différentes étapes du jeu, affichage du jeu de carte, main du joueur 1 (non supprimer), main du joueur 2 (non supprimer), main du joueur 1 (supprimer), main du joueur 2 (supprimer), le joueur gagnant, le score, le tableau des scores et enfin le tableau des scores trier.

# Utilisation des class
---
J'ai implanté les class nécessaire pour l'utilisation d'une Pile, d'un Arbre Binaire et d'une Liste Chainée, ainsi que d'un tri. 

|                |            Méthodes Utilisées               |      Utilité       |
|----------------|---------------------------------------------|--------------------|
|Pile            |Empiler(), Depiler(), Afficher()             |Jeu de carte        |
|ArbreBinaire    |Ajouter(), Recherche(), ParcoursLargeur()    |Joueur 1, Joueur 2  |
|Liste Chainee   |AjouterAuDebut(), tri_Minimum(), Afficher()  |Tableau des scores  |


# Remplacement des cartes
---
Par soucis de simplification j'ai remplacer les cartes pour des valeurs d'entier.
Les couleurs sont réprésentées par le chiffre des centaines.

 - 100 => trèfle
 - 200 => carreau
 - 300 => coeur
 - 400 => Pique

Le nombre venant après représente la carte donc par exemple :

 - L'as de trèfle => 101
 - Le 10 de carreau => 210
 - Le roi de coeur => 313
 - Le 5 de Pique => 405
