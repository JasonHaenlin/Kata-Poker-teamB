package com.app;

public class Carte {
    //Attributs
    private int valeur;

    public Carte()
    {
        valeur = 0;
    }

    //Constructeur avec paramètre
    public Carte(int pValeur)
    {
        valeur = pValeur;
        if(!this.verif())
        {
            System.out.println("Erreur lors de la saisie");
            System.out.println("Veuillez ressaisir la main ");
            valeur = 0;
        }
    }

    //Accesseur qui permet d'évaluer la valeur de la carte
    public int getValeur(){
        return valeur;
    }

    //Méthode pour verification validité de la saisie
    public boolean verif()
    {
        if(this.valeur <2 || this.valeur < 14)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}


