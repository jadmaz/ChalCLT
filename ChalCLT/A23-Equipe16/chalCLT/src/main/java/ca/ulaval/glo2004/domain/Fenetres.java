/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ca.ulaval.glo2004.domain;
 
import ca.ulaval.glo2004.domain.utils.*;
import java.io.Serializable;
 
public class Fenetres extends Accessoires implements Serializable{

 
    public Fenetres(Points position, String type, Dimensions dimension, String mur_associe, boolean is_selected, boolean is_valid)
    {
        super(position, "fenetre", dimension, mur_associe, is_selected, is_valid);
        this.dimension = new Dimensions(
        new Imperial(0,12,1),
        new Imperial(0,12,1),
        new Imperial(0,0,0));
 
    }
 
    @Override
    public void deplacer(Imperial deltaX, Imperial deltaY)
    {
    }

    @Override public void setDimensionsAcc(Dimensions dimension)
    {
    this.dimension = dimension;
    }
    @Override public Dimensions getDimensionsAcc()
    {
    return this.dimension;
    }

}