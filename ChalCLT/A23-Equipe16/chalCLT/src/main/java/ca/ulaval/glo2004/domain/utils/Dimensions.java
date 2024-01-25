/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.utils;

import java.io.Serializable;

/**
 *
 * @author Utilisateur
 */
public class Dimensions implements Serializable{
    private Imperial hauteur;
    private Imperial longueur;
    private Imperial profondeur;
    
    public Dimensions (Imperial hauteur, Imperial longueur, Imperial profondeur) {
        this.hauteur = hauteur;
        this.longueur = longueur;
        this.profondeur = profondeur;
    }
    
    public Imperial getHauteur() {
        return hauteur;
    }

    public void setHauteur(Imperial hauteur) {
        this.hauteur = hauteur;
    }

    public Imperial getLongueur() {
        return longueur;
    }

    public void setLargeur(Imperial longueur) {
        this.longueur = longueur;
    }

    public Imperial getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(Imperial profondeur) {
        this.profondeur = profondeur;
    }
}
