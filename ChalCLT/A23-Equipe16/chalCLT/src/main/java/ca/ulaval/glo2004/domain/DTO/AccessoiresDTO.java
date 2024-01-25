/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ca.ulaval.glo2004.domain.DTO;
import ca.ulaval.glo2004.domain.Accessoires;
import ca.ulaval.glo2004.domain.utils.Dimensions;
import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.gui.MainWindow;
import java.io.Serializable;
import java.util.UUID;
/**
*
* @author charlescareau
*/
public class AccessoiresDTO implements Serializable{
    public Points position;
    public String type;
    public Dimensions dimensions;
    public MainWindow.SelectMode SelectionStatus;
    public UUID uuid;
    public String mur_associe;
    public boolean is_selected;
    public boolean is_valid;
    public AccessoiresDTO(Accessoires bi){
        type = bi.gettype();
        position = bi.getPosition();
        dimensions = bi.getDimensionsAcc();
        SelectionStatus = bi.getSelect();
        uuid = bi.getUUID();
        mur_associe = bi.getMurAssocie();
        is_selected = bi.is_selected();
        is_valid = bi.is_valid;

        }   

    public boolean isContained(Points point)
    {
            // Assuming the position and dimensions are already in pixel units
    int widthInPixels = this.dimensions.getLongueur().toPixel();
    int heightInPixels = this.dimensions.getHauteur().toPixel();
    System.out.println(this.dimensions.getHauteur());
 
    // Get the top left corner of the accessory
    int x1 = this.position.getX().toPixel();
    int y1 = this.position.getY().toPixel();
 
        // Calculate the bottom right corner of the accessory
    int x2 = x1 + widthInPixels;
    int y2 = y1 + heightInPixels;
 
        // Check if the point is within the bounds of the accessory
    int pointX = point.getX().toPixel();
    int pointY = point.getY().toPixel();
    boolean contained = (pointX >= x1 && pointX <= x2) && (pointY >= y1 && pointY <= y2);
    return contained;
    }
    public void set_selected(boolean bool) {
    this.is_selected = bool;
}
 
    public boolean is_selected() {
    return this.is_selected;
}
 
 
    
}