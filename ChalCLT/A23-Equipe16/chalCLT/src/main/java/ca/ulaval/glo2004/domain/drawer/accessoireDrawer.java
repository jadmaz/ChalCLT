/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca.ulaval.glo2004.domain.drawer;

import ca.ulaval.glo2004.domain.Accessoires;
import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author 14189
 */
public interface accessoireDrawer {
    public void drawAccessoire(Graphics g, AccessoiresDTO acessoire, Controleur controller, Dimension initialDimension);
}