package com.app;

import java.util.ArrayList;
import java.util.Scanner;

public class Hand_card {
    // Créer une ArrayList de carte (definie dans la classe Carte)
    // Attributs
    private ArrayList main;

    //Constructeur par défault
    public Hand_card()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez saisir une main");
        int val = sc.nextInt();
        Carte carte = new Carte(val);
        main.add(carte);
    }

    //Accesseur
    public ArrayList getHand_card()
    {
        return main;
    }

    //Méthode pour déterminer valeur de la carte haute
    //v1 Main d'une seule carte
    public int valeur_hand_card()
    {
        //Récupère le premiers element de la liste
        ArrayList main_joueur;
        Carte carte_haute;
        main_joueur = this.getHand_card();
        carte_haute = main_joueur.get(0); //Problème ici main_joueur.get(0) ne semble pas etre du type carte
        return carte_haute.getValeur();

    }
}
