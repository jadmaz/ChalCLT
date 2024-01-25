/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ca.ulaval.glo2004.domain;
import ca.ulaval.glo2004.domain.utils.*;
import java.awt.Dimension;
import ca.ulaval.glo2004.domain.utils.Points;
import java.io.Serializable;
 
/**
*
* @author Utilisateur
*/
 
public class Portes extends Accessoires implements Serializable
{

 
    public Portes(Points position, String type, Dimensions dimension, String mur_associe, boolean is_selected, boolean is_valid)
    {
 
        super(position, type , dimension, mur_associe, is_selected, is_valid);
        this.dimension = new Dimensions(
        new Imperial(0,88,0),
        new Imperial(0,38,0),
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