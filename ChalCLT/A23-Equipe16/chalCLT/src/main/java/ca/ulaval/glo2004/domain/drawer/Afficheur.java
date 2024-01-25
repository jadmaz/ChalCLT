/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.ulaval.glo2004.domain.drawer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.DTO.*;
import ca.ulaval.glo2004.domain.utils.Dimensions;

/**
 *
 * @author 14189
 */
public class Afficheur {
    private final Controleur controller;
    private Dimension initialDimension;
    private AfficheurDessus afficheurDessus;
    private AfficheurMur afficheurMur;
    private chaletDrawer chaletdraw;
    
    public Afficheur(Controleur controller, AfficheurDessus afficheurDessus, AfficheurMur afficheurMur, Dimension initialDimension, chaletDrawer chaletdraw) {
        this.controller = controller;
        this.initialDimension = initialDimension;
        this.afficheurDessus = afficheurDessus;
        this.chaletdraw = chaletdraw;
        this.afficheurMur = afficheurMur;
    }
    
    public void draw(Graphics g) {
        
        chaletdraw.drawDessus(g, controller, initialDimension);
        chaletdraw.drawToit(g, controller, initialDimension);
        
    }

}
