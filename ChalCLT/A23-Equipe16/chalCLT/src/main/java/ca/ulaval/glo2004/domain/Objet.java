/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import ca.ulaval.glo2004.domain.utils.*;

/**
 *
 * @author 14189
 */
public abstract class Objet implements Serializable{
    private Imperial mX;
    private Imperial mY;
    
    private Type mType;
    protected enum Type {MUR, PORTE, FENETRE,};
    private Point mpoint;
    
    private boolean selectionStatus;
    private Imperial mLargeur;
    private Imperial mHauteur;
    
    public Objet(){}
    
    public Objet(Point point)
    {
        this.mpoint = point;
        this.selectionStatus = false;
    }
    
    public Point getPoint()
    {
        return mpoint;
    }
    
    public void setPoint(Point newPoint)
    {
        this.mpoint = newPoint;
    }
    
    
    public Imperial getX()
    {
        return mX;
    }
    
    public Imperial getY()
    {
        return mY;
    }
    
    public void setX(Imperial newX)
    {
        mX = newX;
    }
    
    public void setY(Imperial newY)
    {
        mY = newY;
    }
    
    public void switchSelectionStatus()
    {
        this.selectionStatus = !selectionStatus;
    }
    
    public boolean isSelected()
    {
        return selectionStatus;
    }
    
     public void setSelectionStatus(boolean status)
    {
        this.selectionStatus = status;
    }
     
     public void setLargeur(Imperial largeur)
    {
        this.mLargeur = largeur;
    }
    
    public void setHauteur(Imperial hauteur)
    {
        this.mHauteur = hauteur;
    }
    
    public Imperial getLargeur()
    {
        return mLargeur;
    }
    
    public Imperial getHauteur()
    {
        return mHauteur;
    }

}
