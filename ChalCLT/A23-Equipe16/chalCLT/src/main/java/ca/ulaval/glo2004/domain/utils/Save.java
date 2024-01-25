/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.utils;

import ca.ulaval.glo2004.domain.Chalet;
import ca.ulaval.glo2004.domain.Murs;
import java.io.Serializable;

/**
 *
 * @author charlescareau
 */
public class Save implements Serializable {

    public final Chalet chalet;
    public final String path;
    public final Murs mur;
    public Save (Chalet chalet, Murs mur, String path)
    {
    this.chalet = chalet;
    this.mur = mur;
    this.path = path;
    }
    
    public Chalet getChalet()
    {
    return this.chalet;
    }
    
    public String getPath()
    {
    return this.path;
    }
    
    public Murs getMurs()
    {
    return this.mur;
    }
    
}
