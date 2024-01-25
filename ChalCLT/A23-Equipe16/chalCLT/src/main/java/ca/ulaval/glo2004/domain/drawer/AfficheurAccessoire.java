/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ca.ulaval.glo2004.domain.drawer;
 
/**
*
* @author Utilisateur
*/
import ca.ulaval.glo2004.domain.Accessoires;
import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.domain.utils.Dimensions;
import ca.ulaval.glo2004.domain.utils.Imperial;
import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.gui.MainWindow.SelectMode;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
 
/**
*
* @author 14189
*/
public class AfficheurAccessoire implements accessoireDrawer {
 
    private String type;
    private Color color;
 
    public AfficheurAccessoire(Accessoires accessoire) {
        this.type = accessoire.type;
    }
 
    @Override
    public void drawAccessoire(Graphics g, AccessoiresDTO accessoire, Controleur controller, Dimension initialDimension) {

        if("porte".equals(accessoire.type))
            {
            int height = (int) initialDimension.getHeight();
            int largeur_convertie = accessoire.dimensions.getLongueur().toPixel();
            int hauteur_convertie = accessoire.dimensions.getHauteur().toPixel();
            int accPoint_x = accessoire.position.getX().toPixel();
            int accPoint_y = height/3 - hauteur_convertie  + controller.getDimensions().getHauteur().toPixel() - controller.get_distance_validation().toPixel();
            g.setColor(Color.BLACK);
            g.fillRect(accPoint_x, accPoint_y  ,largeur_convertie, hauteur_convertie);
            int doorknobDiameter = 5;
            int doorknobX = accPoint_x + largeur_convertie - 10;
            int doorknobY = accPoint_y + hauteur_convertie / 2;
            g.setColor(Color.YELLOW);
            g.fillOval(doorknobX, doorknobY, doorknobDiameter, doorknobDiameter);
            }
            if("fenetre".equals(accessoire.type))
            {
            Imperial accPoint_x = accessoire.position.getX();
            Imperial accPoint_y = accessoire.position.getY();
            int largeur_convertie = accessoire.dimensions.getLongueur().toPixel();
            int hauteur_convertie = accessoire.dimensions.getHauteur().toPixel();
            g.setColor(Color.CYAN);
            g.fillRect(accPoint_x.toPixel(), accPoint_y.toPixel()  ,largeur_convertie, hauteur_convertie);
            g.setColor(Color.BLACK);
            int barWidth = 2;

            g.fillRect(accPoint_x.toPixel() + largeur_convertie / 2 - barWidth / 2, accPoint_y.toPixel(), barWidth, hauteur_convertie);

            g.fillRect(accPoint_x.toPixel(), accPoint_y.toPixel() + hauteur_convertie / 2 - barWidth / 2, largeur_convertie, barWidth);
            }
    }
 
 
    
    public void drawBorder(Graphics g, AccessoiresDTO acc, Controleur controller, Dimension initialDimension)
    {

    int accPoint_x = acc.position.getX().toPixel();
    int accPoint_y = acc.position.getY().toPixel();
    int largeur_convertie = acc.dimensions.getLongueur().toPixel();
    int hauteur_convertie = acc.dimensions.getHauteur().toPixel();
    int borderWidth = 4; 
 
    g.setColor(Color.CYAN);
    g.drawRect(accPoint_x - borderWidth, accPoint_y - borderWidth, largeur_convertie + 2 * borderWidth, hauteur_convertie + 2 * borderWidth);
   }
    public boolean isAccessorySelected(AccessoiresDTO acc, Point mousePoint, double zoomFactor, double offsetX, double offsetY) {
    double mouseX = (mousePoint.x - offsetX) / zoomFactor;
    double mouseY = (mousePoint.y - offsetY) / zoomFactor;
 
    int accPoint_x = acc.position.getX().toPixel();
    int accPoint_y = acc.position.getY().toPixel();
    int largeur_convertie = acc.dimensions.getLongueur().toPixel();
    int hauteur_convertie = acc.dimensions.getHauteur().toPixel();
 

    return mouseX >= accPoint_x && mouseX <= accPoint_x + largeur_convertie &&
           mouseY >= accPoint_y && mouseY <= accPoint_y + hauteur_convertie;
}
 
    
    public void drawBorder_v(Graphics g, AccessoiresDTO acc, Controleur controller, Dimension initialDimension)
    {

    int accPoint_x = acc.position.getX().toPixel();
    int accPoint_y = acc.position.getY().toPixel();
    int largeur_convertie = acc.dimensions.getLongueur().toPixel();
    int hauteur_convertie = acc.dimensions.getHauteur().toPixel();
 

    int borderWidth = 4;
 
    g.setColor(Color.RED);
    g.drawRect(accPoint_x - borderWidth, accPoint_y - borderWidth, largeur_convertie + 2 * borderWidth, hauteur_convertie + 2 * borderWidth);
   }
}