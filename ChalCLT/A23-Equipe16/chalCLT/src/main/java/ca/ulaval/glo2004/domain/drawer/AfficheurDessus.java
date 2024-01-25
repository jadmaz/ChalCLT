/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.drawer;
import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.DTO.MursDTO;
import ca.ulaval.glo2004.domain.Orientation;
import ca.ulaval.glo2004.domain.utils.Imperial;
import ca.ulaval.glo2004.gui.MainWindow;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.List;
import ca.ulaval.glo2004.domain.utils.Points;
import java.util.ArrayList;

/**
 *
 * @author 14189

*/

public class AfficheurDessus implements chaletDrawer {

    public AfficheurDessus(MainWindow outer) {
    }
    

    @Override
    public void drawDessus(Graphics g, Controleur controller, Dimension initialDimension) {
 
    boolean alternerCouleur = false;
    controller.updateMursDTO();
 
    if (controller.getListMursDTO() != null) {
        List<MursDTO> murs = controller.getListMursDTO();
        
        for (MursDTO mur : murs) {
            int[] XPoints = new int[8];
            int[] YPoints = new int[8];
            List<Points> pointsMur = mur.getPointsVueDessus();

            for (int i = 0; i < 8; i++) {
                XPoints[i] = pointsMur.get(i).getX().toPixel();
                YPoints[i] = pointsMur.get(i).getY().toPixel();
            }
 
            if (alternerCouleur) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(new Color(255, 165, 0));
            }
 
            g.fillPolygon(XPoints, YPoints, 8);
 
            alternerCouleur = !alternerCouleur;
        }
    }
        
        
    }
    
    @Override
    public void drawToit(Graphics g,Controleur controller, Dimension initialDimension){
       Imperial point = new Imperial(2, 0, 0);
       if(controller.getToit() == true){
       g.setColor(Color.BLACK);
       g.fillRect(point.toPixel(), point.toPixel(), controller.getDimensions().getLongueur().toPixel(), controller.getDimensions().getProfondeur().toPixel());
    }}
}

   

