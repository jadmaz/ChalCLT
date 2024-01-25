/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ca.ulaval.glo2004.domain;
 
import ca.ulaval.glo2004.domain.utils.Dimensions;
import ca.ulaval.glo2004.domain.utils.Imperial;
import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.gui.MainWindow;
import java.awt.Dimension;
import java.awt.Point;
import java.io.Serializable;
import java.util.UUID;
 
/**
*
* @author Utilisateur
*/
public class Accessoires implements Serializable {
 
    public Points position;
    public String type;
    public Dimensions dimension;
    public MainWindow.SelectMode SelectionStatus;
    private UUID uuid;
    public String mur_associe;
    public boolean is_selected = false;
    public boolean is_valid = false;

 
    public Accessoires(Points position, String type, Dimensions dimension, String mur_associe, boolean is_selected, boolean is_valid) {
 
        this.position = position;
        this.type = type;
        this.uuid = UUID.randomUUID();
        this.dimension = dimension;
        this.mur_associe = mur_associe;
        this.is_selected = is_selected;
        this.is_valid = is_valid;
    }
 
    public Points getPosition() {
        return position;
    }
 
    public void setPosition(Points newposition) {
        int nouv_x = 0;
        int nouv_y = 0;
        
        if(newposition.getX().toPixel() != getPosition().getX().toPixel())
        {
         nouv_x = newposition.getX().toPixel() + 1344/4;
        }
        else if(newposition.getX().toPixel() == getPosition().getX().toPixel())
        {
        nouv_x = getPosition().getX().toPixel();
        }
            
        if(newposition.getY().toPixel() != getPosition().getY().toPixel() && !"porte".equals(gettype()))
        {
         nouv_y = newposition.getY().toPixel() + 806/3;
        }
        else if(newposition.getY().toPixel() == getPosition().getY().toPixel() && !"porte".equals(gettype()) )
        {
        nouv_y = getPosition().getY().toPixel();
        }
        
        else if("porte".equals(gettype()))
        {
        nouv_y = newposition.getY().toPixel();
        }
        
        Points point = Points.fromPixelsToImperial(nouv_x, nouv_y);
        this.position = point;
    }
    
    
    public void setPositiondragged(Points newposition)
    {
    this.position = newposition;
    
    }
    
    
    public UUID getUUID() {
            return uuid;
        }
 
    public String gettype() {
        return type;
    }
    public void set_acc_type(String new_type)
    {
    this.type = new_type;
    }
 
    public MainWindow.SelectMode getSelect() {
        return SelectionStatus;
    }
    
    public void set_position_doors(Imperial supp, int supp_actuel)
    {
        int supp_ = supp.toPixel();
        int x = getPosition().getX().toPixel();
        int y = getPosition().getY().toPixel() - supp_ + supp_actuel;
        Points point = Points.fromPixelsToImperial(x, y);
        this.position = point;
    
    }
 
 
    public void deplacer(Point deltaX, Point deltaY) {
 
    }
 
    public void setSelectionStatus(MainWindow.SelectMode s) {
        this.SelectionStatus = s;
    }
    public void deplacer(Imperial deltaX, Imperial deltaY) {
    }

 
    public void setDimensionsAcc(Dimensions new_dimension)
    {
    this.dimension = new_dimension;
    }
    public Dimensions getDimensionsAcc()
    {
    return this.dimension;
    }
    public void setMursAssocie(String mur_associe)
    {
    this.mur_associe = mur_associe;
    }
    public String getMurAssocie()
    {
    return this.mur_associe;
    }
    public boolean is_contained(Points point)
    {
    int widthInPixels = this.dimension.getLongueur().toPixel();
    int heightInPixels = this.dimension.getHauteur().toPixel();
 
    int x1 = this.position.getX().toPixel();
    int y1 = this.position.getY().toPixel();
 
    int x2 = x1 + widthInPixels;
    int y2 = y1 + heightInPixels;
 

    int pointX = point.getX().toPixel();
    int pointY = point.getY().toPixel();
    return (pointX >= x1 && pointX <= x2) && (pointY >= y1 && pointY <= y2);
    }
    public void set_selected()
    {
    this.is_selected = true;
    }
    public boolean is_selected()
    {
    return this.is_selected;
    }
    public void set_valid()
    {
    this.is_valid = true;
    }
 
    public void set_invalide()
    {
    this.is_valid = false;
    }
    
    public void setPosition_dims(Dimensions dim, Dimensions ancienne) {
        int nouv_hauteur = dim.getHauteur().toPixel();
        int ancienne_hauteur = ancienne.getHauteur().toPixel();
        int nouv_longueur = dim.getLongueur().toPixel();
        int ancienne_longueur = ancienne.getLongueur().toPixel();
        int nouv_profondeur = dim.getProfondeur().toPixel();
        int ancienne_profondeur = ancienne.getProfondeur().toPixel();
        int ancienne_position_x = getPosition().getX().toPixel();
        int ancienne_position_y = getPosition().getY().toPixel();
        int nouv_position_x = ancienne_position_x;
        int nouv_position_y = ancienne_position_y;

        System.out.println("Old Height: " + ancienne_hauteur + ", New Height: " + nouv_hauteur);
        System.out.println("Old Length: " + ancienne_longueur + ", New Length: " + nouv_longueur);
        System.out.println("Old Depth: " + ancienne_profondeur + ", New Depth: " + nouv_profondeur);
        System.out.println("Old X Position: " + ancienne_position_x + ", Old Y Position: " + ancienne_position_y);

        if (nouv_hauteur != ancienne_hauteur) {
            nouv_position_y = ((nouv_hauteur * (ancienne_position_y - 806/3)) / ancienne_hauteur) + 806/3;
            System.out.println("Adjusted Y Position: " + nouv_position_y);
        }

        if (nouv_longueur != ancienne_longueur) {
            nouv_position_x = ((nouv_longueur * (ancienne_position_x - 1344/4)) /ancienne_longueur) + 1344/4;
            System.out.println("Adjusted X Position: " + nouv_position_x);
        }

        if (nouv_profondeur != ancienne_profondeur) {
            nouv_position_x = ((nouv_profondeur * (ancienne_position_x - 1344/4)) / ancienne_profondeur) + 1344/4;
            System.out.println("Adjusted X Position (Depth): " + nouv_position_x);
        }

        Points nouv_pos = Points.fromPixelsToImperial(nouv_position_x, nouv_position_y);
        System.out.println("New Position: " + nouv_pos);
        setPositiondragged(nouv_pos);
    }









}