/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package ca.ulaval.glo2004.domain;
 
import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.domain.utils.*;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.gui.Panels.drawingPanel;
import java.awt.Dimension;
 
import java.awt.Polygon;
import java.awt.Rectangle;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Iterator;
 
/**
*
* @author Utilisateur
*/
public class Murs implements Serializable {
 
    private Orientation orientation;
    private List<Accessoires> accessoires;
    private List<Points> pointsVueDessus;
    private Chalet chalet;
    private UUID uuid;
    private Polygon polygon;
    public drawingPanel panel;
    private Imperial distance_validation = new Imperial(0, 3, 0);
    public int distance_validation_precedente;
 
    public Murs(List<Points> pointsVueDessus, Orientation orientation, List<Accessoires> listeAccessoires) {
 
        this.orientation = orientation;
        this.accessoires = new ArrayList<Accessoires>();
        this.pointsVueDessus = pointsVueDessus;
        this.uuid = UUID.randomUUID();
    }
 
    public UUID getUUID() {
        return uuid;
    }
 
    public Orientation getOrientation() {
        return orientation;
    }
 
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
 
    public List<Accessoires> getAccessoires() {
        return accessoires;
    }
 
    public void setAccessoires(List<Accessoires> accessoires) {
        this.accessoires = accessoires;
    }
 
    public List<Points> getPointsVueDessus() {
        return pointsVueDessus;
    }
 
    public List<Points> getPoints() {
        return pointsVueDessus;
    }
 
    public void setPoints(List<Points> points) {
        this.pointsVueDessus = points;
    }
 
    public void addAccessoire(Accessoires accessoire) {
        accessoires.add(accessoire);
        updateAccDTOList();
    }
 
    public void onSensToitChanged(SensToit newSensToit, SensToit oldSensToit) {
 
    }
 
    public void onDimensionChanged(int nouvelleLargeur, int nouvelleHauteur, int nouvelleProfondeur) {
 
    }
 
    
    private List<AccessoiresDTO> accDTOList = new ArrayList<>();
 
 
    public void updateAccDTOList()
    {
    accDTOList.clear();
    for (Accessoires accessoire : accessoires) {
        accDTOList.add(new AccessoiresDTO(accessoire));
    }
    }

 
    public List<AccessoiresDTO> getAccList() {
    return accDTOList;
}
    public void set_chalet(Chalet chalet_n)
    {
    this.chalet = chalet_n;
    }
    public Chalet get_chalet()
    {
    return this.chalet;
    }

    public void deleteSelectedAccessories() {
 
    for (AccessoiresDTO acc : getAccList()) {
        System.out.println(acc + " Selected: " + acc.is_selected());
    }
 
    List<UUID> selectedUUIDs = new ArrayList<>();
    for (AccessoiresDTO acc : getAccList()) {
        if (acc.is_selected()) {
            selectedUUIDs.add(acc.uuid);
        }
 
    }
 
    getAccList().removeIf(acc -> acc.is_selected());
 
    accessoires.removeIf(acc -> selectedUUIDs.contains(acc.getUUID()));
    for(Accessoires acc : getAccessoires())
    {
    if(valider_position_accessoire_acc(acc) && get_chalet().valider_position_accessoire(acc))
    {
    acc.set_valid();
    }
    if(!valider_position_accessoire_acc(acc) && !get_chalet().valider_position_accessoire(acc))
    {
    acc.set_invalide();
    }
    }
    updateAccDTOList();
 
}


public void updateDimensionsForSelectedAccessories(Dimensions newDimensions) {

    boolean updated = false;
 

    for (AccessoiresDTO accDTO : getAccList()) {
        if (accDTO.is_selected()) {

            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    accessoire.setDimensionsAcc(newDimensions);
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    if(accessoire.is_valid){
                    if(!get_chalet().valider_position_accessoire(accessoire))
                    {
                    accessoire.set_invalide();
                    }};
                    if(!accessoire.is_valid)
                    {
                    if(get_chalet().valider_position_accessoire(accessoire))
                    {
                    accessoire.set_valid();
                    }
                    }

                    updated = true;
                    break;
                }
            }
        }
    }
 

    if (updated) {
        updateAccDTOList();
    }
}
 
public Dimensions get_selected_acc_dimensions() {

    for (AccessoiresDTO accDTO : getAccList()) {

        if (accDTO.is_selected()) {

            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {

                    return accessoire.getDimensionsAcc();
                }
            }
        }
    }

    return null;
}


public Points get_selected_acc_position() {

    for (AccessoiresDTO accDTO : getAccList()) {

        if (accDTO.is_selected()) {

            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {

                    return accessoire.getPosition();
                }
            }
        }
    }

    return null;
}
 
public int get_distance_supp()
{
return distance_validation.toPixel();
}
 
 
public void set_distance_supp(Imperial imperial)
{
set_distance_validation_precedente(get_distance_supp());
this.distance_validation = imperial;
update_position_all_doors(imperial);
update_position_accessories_distsupp();

}

public int get_distance_supp_prec()
{
return distance_validation_precedente;
}

public void set_distance_validation_precedente(int distance)
{
this.distance_validation_precedente = distance;
}
 




public void update_position_all_doors(Imperial supp) {
    boolean updated = false;

    for (AccessoiresDTO accDTO : getAccList()) {
        for (Accessoires accessoire : getAccessoires()) {
            if (accessoire.getUUID().equals(accDTO.uuid)) {
                if(accessoire.gettype().equals("porte")) {
                    accessoire.set_position_doors(supp, get_distance_supp_prec());
                }
                
                updated = true;
                break;
            }
        }
    }

    if (updated) {
        updateAccDTOList();
    }
}

 
public boolean valider_position_accessoire_acc(Accessoires acc) {
    final double BORDER_OFFSET = get_distance_supp()/2;
    System.out.println("Validating position for accessory: " + acc);
 
    for (Accessoires otherAcc : getAccessoires()) {
        System.out.println("Checking against accessory: " + otherAcc);
 
        if (!otherAcc.equals(acc) && otherAcc.getMurAssocie().equals(acc.getMurAssocie())) {
            System.out.println("Accessories are on the same wall.");
 

            Imperial accX = acc.getPosition().getX();
            Imperial accY = acc.getPosition().getY();
            Dimensions accDim = acc.getDimensionsAcc();
 
            Imperial otherAccX = otherAcc.getPosition().getX();
            Imperial otherAccY = otherAcc.getPosition().getY();
            Dimensions otherAccDim = otherAcc.getDimensionsAcc();
 

            System.out.println("Accessory position and dimensions: X=" + accX + ", Y=" + accY + ", Dimensions=" + accDim);
            System.out.println("Other accessory position and dimensions: X=" + otherAccX + ", Y=" + otherAccY + ", Dimensions=" + otherAccDim);
 

            Rectangle accBorder = new Rectangle(
                accX.toPixel() - (int)(BORDER_OFFSET), 
                accY.toPixel() - (int)(BORDER_OFFSET),
                accDim.getLongueur().toPixel() + (int)(BORDER_OFFSET * 2),
                accDim.getHauteur().toPixel() + (int)(BORDER_OFFSET * 2)
            );
 
            Rectangle otherAccBorder = new Rectangle(
                otherAccX.toPixel() - (int)(BORDER_OFFSET), 
                otherAccY.toPixel() - (int)(BORDER_OFFSET),
                otherAccDim.getLongueur().toPixel() + (int)(BORDER_OFFSET * 2),
                otherAccDim.getHauteur().toPixel() + (int)(BORDER_OFFSET * 2)
            );
 

            System.out.println("Accessory border: " + accBorder);
            System.out.println("Other accessory border: " + otherAccBorder);

            if (accBorder.intersects(otherAccBorder)) {
                System.out.println("Borders intersect. Accessories are too close.");
                return false;
            } else {
                System.out.println("Borders do not intersect.");
            }
        } else {
            System.out.println("Accessories are not on the same wall or are the same accessory.");
        }
    }
    System.out.println("Validation successful. No conflicts found.");
    return true;
}
   
public void update_position_selected_accessories(Points point) {

    boolean updated = false;
 

    for (AccessoiresDTO accDTO : getAccList()) {
        if (accDTO.is_selected()) {

            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    accessoire.setPosition(point);
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    if(accessoire.is_valid){
                    if(!get_chalet().valider_position_accessoire(accessoire) || !valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_invalide();
                    }}
                    if(!accessoire.is_valid)
                    {
                    if(get_chalet().valider_position_accessoire(accessoire) &&  valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_valid();
                    }
                    }
                    
                    updated = true;
                    
                    break;
                }
            }
        }
    }
 

    if (updated) {
            for(Accessoires acc : getAccessoires())
    {
    if(valider_position_accessoire_acc(acc) && get_chalet().valider_position_accessoire(acc))
    {
    acc.set_valid();
    }
    if(!valider_position_accessoire_acc(acc) || !get_chalet().valider_position_accessoire(acc))
    {
    acc.set_invalide();
    }
    }
    updateAccDTOList();
 
    }
}


public void update_position_selected_accessory_dragged(Points point)
{

    boolean updated = false;
 

    for (AccessoiresDTO accDTO : getAccList()) {
        if (accDTO.is_selected()) {

            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    accessoire.setPositiondragged(point);
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    if(accessoire.is_valid){
                    if(!get_chalet().valider_position_accessoire(accessoire) || !valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_invalide();
                    }}
                    if(!accessoire.is_valid)
                    {
                    if(get_chalet().valider_position_accessoire(accessoire) &&  valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_valid();
                    }
                    }
                    
                    updated = true;
                    
                    break;
                }
            }
        }
    }
    
 

    if (updated) {
    for(Accessoires acc : getAccessoires())
    {
    if(valider_position_accessoire_acc(acc) && get_chalet().valider_position_accessoire(acc))
    {
    acc.set_valid();
    }
    if(!valider_position_accessoire_acc(acc) || !get_chalet().valider_position_accessoire(acc))
    {
    acc.set_invalide();
    }
    }
    updateAccDTOList();
 
    }


}




    public void actualiser_position_portes() {
    Dimensions dimensions_murs;
    int height = 806 / 3;

    for (Accessoires acc : getAccessoires()) {
        if ("porte".equals(acc.gettype())) {
            Dimensions dimensions_acc = acc.getDimensionsAcc();

            for (Murs mur : get_chalet().getListmurs()) {
                if (acc.getMurAssocie().equals(mur.getOrientation().toString().toLowerCase())) {
                    dimensions_murs = get_chalet().getDimensions();
                    int ajusted_y = height - dimensions_acc.getHauteur().toPixel() + dimensions_murs.getHauteur().toPixel() - get_chalet().get_distance_validation().toPixel();
                    acc.setPosition(Points.fromPixelsToImperial(acc.getPosition().getX().toPixel(), ajusted_y));
                }
            }
        updateAccDTOList();
        }
    }
}

    
    
public void validate_position_all_accessories() {

    boolean updated = false;
 

    for (AccessoiresDTO accDTO : getAccList()) 
    {
            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    } 
                    if(accessoire.is_valid){
                    if(!get_chalet().valider_position_accessoire(accessoire) || !valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_invalide();
                    }}
                    if(!accessoire.is_valid)
                    {
                    if(get_chalet().valider_position_accessoire(accessoire) &&  valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_valid();
                    }
                    }
                    
                    updated = true;
                    
                    break;
                }
            }
        
    }
 

    if (updated) {
        updateAccDTOList();
    }
}
    




    
public void update_position_accessories_distsupp() {

    boolean updated = false;
 

    for (AccessoiresDTO accDTO : getAccList()) 
    {
            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {
                    if(accessoire.is_valid){
                    if(!get_chalet().valider_position_accessoire(accessoire) || !valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_invalide();
                    }}
                    if(!accessoire.is_valid)
                    {
                    if(get_chalet().valider_position_accessoire(accessoire) &&  valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_valid();
                    }
                    }
                    
                    updated = true;
                    
                    break;
                }
            }
        
    }
 

    if (updated) {
        updateAccDTOList();
    }
}
    
    

public void update_position_all_accessories(Dimensions nouv_dimensions) {

    boolean updated = false;
 

    for (AccessoiresDTO accDTO : getAccList()) 
        

            for (Accessoires accessoire : getAccessoires()) {
                if (accessoire.getUUID().equals(accDTO.uuid)) {
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    accessoire.setPosition_dims(nouv_dimensions, get_chalet().getDimensions());
                    if(accessoire.gettype().equals("porte"))
                    {
                    get_chalet().actualiser_position_porte(accessoire);
                    }
                    if(accessoire.is_valid){
                    if(!get_chalet().valider_position_accessoire(accessoire) || !valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_invalide();
                    }}
                    if(!accessoire.is_valid)
                    {
                    if(get_chalet().valider_position_accessoire(accessoire) &&  valider_position_accessoire_acc(accessoire))
                    {
                    accessoire.set_valid();
                    }
                    }
                    
                    updated = true;
                    
                    break;
                }
            }
        
    
 

    if (updated) {
        updateAccDTOList();
    }
}




public Murs deepCopy() throws IOException, ClassNotFoundException {
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
        objectOutputStream.writeObject(this);
 
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (Murs) objectInputStream.readObject();
        }
    }
}



    
    
    
    








}