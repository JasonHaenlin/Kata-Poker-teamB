------------Jeu de poker Team-B-------------


État du jeu :
--------------------------


Le jeu prend actuellement en compte toutes règles indiquées dans la spécification :
Quinte Flush, Carré, Full, Flush, Quinte, Brelan, Double pair, pair, et carte la plus haute.
Le jeu affiche le gagnant et la raison pour laquelle il a gagné.


Comment jouer :
--------------------------


Lancer depuis la racine les commandes "mvn clean package" puis "mvn exec:java". L’utilisateur saisit alors une main de 5 cartes, presse entrée et saisit la 2e comme indiqué dans la règle du jeu dans Dojo - La main de Poker.pdf

Si une carte est saisie en double, ou le format d'entrée indiqué dans la spécification n'est pas respecté, un message d’erreur est envoyé, il faut relancer la commande "mvn exec:java".

Note: si trop de caractères "espace" sont mis entre les cartes, un message d'erreur indiquera que le nombre de cartes saisies doit être égal à 5 et le programme s'arrêtera.


Fichiers livrés :
--------------------------


B-specs.xls
ReadMe.txt
src/
----main/
--------java
------------poker/
----------------game/
--------------------Card.java
--------------------CardColor.java
--------------------CardValue.java
--------------------CombinationType.java
--------------------exception/
------------------------CardColorRuntimeException.java
------------------------CardDuplicationBetweenPlayerRuntimeException.java
------------------------CardDuplicationInHandRuntimeException.java
------------------------CardValueRuntimeException.java
------------------------CardWrongInputSizeRuntimeException.java
------------------------WrongHandSizeRuntimeException.java
--------------------Game.java
--------------------Hand.java
--------------------Referee.java
----------------Poker.java
----test/
--------java
------------poker/
----------------game/
--------------------CardColorTest.java
--------------------CardTest.java
--------------------CardValueTest.java
--------------------GameTest.java
--------------------HandTest.java
--------------------RefereeTest.java
--------------------WinnerTest.java


Auteurs:
--------------------------


Maxime CASTELLANO
Jason HAENLIN
Ruben HOURI
Vincent UNG

