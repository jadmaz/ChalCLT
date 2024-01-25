/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.DTO;

import ca.ulaval.glo2004.domain.Murs;
import ca.ulaval.glo2004.domain.Chalet;
import ca.ulaval.glo2004.domain.SensToit;
import ca.ulaval.glo2004.domain.utils.Dimensions;
import ca.ulaval.glo2004.domain.utils.Imperial;
//import ca.ulaval.glo2004.domain.utils.Dimensions;
//import ca.ulaval.glo2004.domain.utils.Imperial;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.awt.Point;
import java.io.Serializable;
/**
 *
 * @author charlescareau
 */
public class ChaletDTO implements Serializable
{
    public Dimensions dimensions;
    public List<Murs> listmurs;
    public SensToit sensToit;
    public UUID uuid;
    public Chalet.vueType vueCourante;
    public Imperial epaisseur;
    public enum vueType {Dessus, Facade, Arriere, Gauche, Droite};
    

    
    public ChaletDTO(Chalet chalet)
    {
        dimensions = chalet.getDimensions();
        sensToit = chalet.getSensToit();
        listmurs = chalet.getListmurs();
        epaisseur = chalet.getEpaisseurMur();
        uuid = chalet.getUUID();
        vueCourante = chalet.getvueCourante();
    }
    
}

