/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca.ulaval.glo2004.domain.drawer;

import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.Orientation;
import java.awt.Dimension;
import java.awt.Graphics;

public interface chaletDrawer {

    public void drawDessus(Graphics g,Controleur controller, Dimension initialDimension);
    public void drawToit(Graphics g,Controleur controller, Dimension initialDimension);

}