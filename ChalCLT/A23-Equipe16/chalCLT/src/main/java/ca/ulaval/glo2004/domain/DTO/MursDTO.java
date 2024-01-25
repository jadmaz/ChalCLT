/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.DTO;

import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.domain.Accessoires;
import ca.ulaval.glo2004.domain.Murs;
import ca.ulaval.glo2004.domain.Orientation;
import ca.ulaval.glo2004.domain.utils.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MursDTO implements Serializable{

    public Orientation orientation;
    public List<Accessoires> accessoires;
    public List<Points> pointsVueDessus;
    public UUID uuid;

    public MursDTO(Murs murs) {
        orientation = murs.getOrientation();
        accessoires = murs.getAccessoires();
        pointsVueDessus = murs.getPoints();
        uuid = murs.getUUID();
    }

    
    public List<Points> getPointsVueDessus() {
    return pointsVueDessus;
}

}

