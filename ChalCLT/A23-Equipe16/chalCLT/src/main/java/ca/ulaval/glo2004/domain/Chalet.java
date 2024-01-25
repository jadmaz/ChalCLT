/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain;

import ca.ulaval.glo2004.domain.DTO.MursDTO;
import ca.ulaval.glo2004.domain.utils.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Utilisateur
 */
public class Chalet extends Objet implements Serializable {

    private Dimensions dimensions;
    private List<Murs> listmurs;
    private int angleToit;
    private SensToit sensToit;
    private Imperial epaisseurMur;
    private Orientation orientation;
    private UUID uuid;
    private vueType vueCourante;
    private Imperial distance_validation = new Imperial(0, 3, 0);
    public enum vueType {
        Dessus, Facade, Arriere, Gauche, Droite
    };
    private Imperial distanceSupplementaire;
    boolean afficher_facade = false;
    boolean afficher_arriere = false;
    boolean afficher_gauche = false;
    boolean afficher_droite = false;
    public Points point_init_facade;
    public Points point_init_arriere;
    public Points point_init_gauche;
    public Points point_init_droite;

    public Chalet() {
        this.dimensions = new Dimensions(
                new Imperial(10, 0, 0),
                new Imperial(10, 0, 0),
                new Imperial(8, 0, 0)
        );
        this.angleToit = 15;
        this.sensToit = SensToit.Facade_arriere;
        this.epaisseurMur = new Imperial(0, 10, 0);
        this.vueCourante = vueType.Dessus;
        this.distanceSupplementaire = new Imperial(0, 1, 0);
        this.listmurs = initialiserMurs();

    }

    public UUID getUUID() {
        return uuid;
    }
    
    public Orientation getOrientation()
    {
    return orientation;
    }
    
    public void setOrientation(Orientation orientation)
    {
    this.orientation = orientation;
    }
    

    public vueType getvueCourante() {
        return vueCourante;
    }

    public void setVueCourante(vueType vueCourante) {
        this.vueCourante = vueCourante;
    }

    public void changerSensToit(SensToit nouveauSens) {

        this.sensToit = nouveauSens;

    }

    public Imperial getEpaisseur() {
        return epaisseurMur;
    }

    public Imperial getDistanceSupp() {
        return distanceSupplementaire;
    }

    public void setDistanceSupp(Imperial distanceSupplementaire) {
        this.distanceSupplementaire = distanceSupplementaire;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
    
    private ArrayList<MursDTO> mursDTO = new ArrayList<>();
    
    public List<MursDTO> getListmursDTO() {
        return mursDTO;
    }
    
    public List<Murs> getListmurs() {
        return listmurs;
    }
    
    public void updateMursDTOList()
    {
    mursDTO.clear();
        for (Murs mur : getListmurs())
        {
            mursDTO.add(new MursDTO(mur));
        }
    }

    public void setListmurs(List<Murs> listmurs) {
        this.listmurs = listmurs;

    }

    public int getAngleToit() {
        return angleToit;
    }

    public void setAngleToit(int angleToit) {
        this.angleToit = angleToit;
    }

    public SensToit getSensToit() {
        return sensToit;
    }

    public void setSensToit(SensToit sensToit) {
        this.sensToit = sensToit;
    }

    public Imperial getEpaisseurMur() {
        return epaisseurMur;
    }

    public void setEpaisseurMur(Imperial epaisseurMur) {
        this.epaisseurMur = epaisseurMur;
    }
    
    public Imperial get_distance_validation()
    {
    return distance_validation;
    }
 
 
    public void set_distance_validation(Imperial imperial)
    {
    this.distance_validation = imperial;
    }

    public List<Points> initialiserMurFacade() {
        Imperial distancesupp_2 = getDistanceSupp().division();
        Imperial longueur = getDimensions().getLongueur();
        Imperial profondeur = getDimensions().getProfondeur();
        Imperial epaisseur_2 = getEpaisseurMur().division();
        Imperial epaisseur = getEpaisseurMur();

        List<Points> pointsFacade = new ArrayList<>();
        if (getSensToit() == SensToit.Facade_arriere || getSensToit() == SensToit.Arriere_facade) {

            Points pt1 = (new Points(new Imperial(2, 0, 0),
                    new Imperial(2, 0, 0).addition(profondeur)));
            Points pt2 = (new Points(pt1.getX().addition(longueur),
                    pt1.getY()));
            Points pt3 = (new Points(pt2.getX(),
                    pt2.getY().soustraction(epaisseur_2).addition(distancesupp_2)));
            Points pt4 = (new Points(pt3.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt3.getY()));
            Points pt5 = (new Points(pt4.getX(),
                    pt4.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt6 = (new Points(pt1.getX().addition(distancesupp_2).addition(epaisseur_2),
                    pt5.getY()));
            Points pt7 = (new Points(pt6.getX(),
                    pt4.getY()));
            Points pt8 = (new Points(pt1.getX(),
                    pt7.getY()));
            pointsFacade.add(pt1);
            point_init_facade = pt1;
            pointsFacade.add(pt2);
            pointsFacade.add(pt3);
            pointsFacade.add(pt4);
            pointsFacade.add(pt5);
            pointsFacade.add(pt6);
            pointsFacade.add(pt7);
            pointsFacade.add(pt8);
        }
        
        else
        {
            Points pt1 = (new Points(new Imperial(2, 0, 0).addition(epaisseur_2).addition(distancesupp_2),
                    new Imperial(2, 0, 0).addition(profondeur)));
            Points pt2 = (new Points(new Imperial(2, 0, 0).addition(longueur).soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt1.getY()));
            Points pt3 = (new Points(pt2.getX(),
                    pt2.getY().soustraction(epaisseur_2).addition(distancesupp_2)));
            Points pt4 = (new Points(pt3.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt3.getY()));
            Points pt5 = (new Points(pt4.getX(),
                    pt4.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt6 = (new Points(pt1.getX().addition(distancesupp_2).addition(epaisseur_2),
                    pt5.getY()));
            Points pt7 = (new Points(pt6.getX(),
                    pt4.getY()));
            Points pt8 = (new Points(pt1.getX(),
                    pt7.getY()));
            pointsFacade.add(pt1);
            point_init_facade = pt1;
            pointsFacade.add(pt2);
            pointsFacade.add(pt3);
            pointsFacade.add(pt4);
            pointsFacade.add(pt5);
            pointsFacade.add(pt6);
            pointsFacade.add(pt7);
            pointsFacade.add(pt8);
        }
        return pointsFacade;
    }

    public List<Points> initialiserMurArriere() {
        Imperial distancesupp_2 = getDistanceSupp().division();
        Imperial longueur = getDimensions().getLongueur();
        Imperial profondeur = getDimensions().getProfondeur();
        Imperial epaisseur_2 = getEpaisseurMur().division();
        Imperial epaisseur = getEpaisseurMur();
        int longueurPixel = longueur.toPixel();
        int profondeurPixel = profondeur.toPixel();
        int epaisseur_2Pixel = epaisseur_2.toPixel();
        int epaisseurPixel = epaisseur.toPixel();
        int distancesupp_2Pixel = distancesupp_2.toPixel();

// Imprimer les valeurs en pixels
        System.out.println("Distancesupp_2 en pixels: " + distancesupp_2Pixel);
        System.out.println("Longueur en pixels: " + longueurPixel);
        System.out.println("Profondeur en pixels: " + profondeurPixel);
        System.out.println("Epaisseur_2 en pixels: " + epaisseur_2Pixel);
        System.out.println("Epaisseur en pixels: " + epaisseurPixel);
        List<Points> pointsArriere = new ArrayList<>();
        if (getSensToit() == SensToit.Facade_arriere || getSensToit() == SensToit.Arriere_facade) {

            Points pt9 = (new Points(new Imperial(2, 0, 0),
                    new Imperial(2, 0, 0)));
            Points pt10 = (new Points(pt9.getX().addition(longueur),
                    pt9.getY()));
            Points pt11 = (new Points(pt10.getX(),
                    pt10.getY().soustraction(distancesupp_2).addition(epaisseur_2)));
            Points pt12 = (new Points(pt11.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt11.getY()));
            Points pt13 = (new Points(pt12.getX(),
                    pt12.getY().addition(distancesupp_2).addition(epaisseur_2)));
            Points pt14 = (new Points(pt9.getX().addition(distancesupp_2).addition(epaisseur_2),
                    pt13.getY()));
            Points pt15 = (new Points(pt14.getX(),
                    pt11.getY()));
            Points pt16 = (new Points(pt9.getX(),
                    pt12.getY()));
            pointsArriere.add(pt9);
            point_init_arriere = pt9;
            pointsArriere.add(pt10);
            pointsArriere.add(pt11);
            pointsArriere.add(pt12);
            pointsArriere.add(pt13);
            pointsArriere.add(pt14);
            pointsArriere.add(pt15);
            pointsArriere.add(pt16);
        }
        else
        {
            Points pt9 = (new Points(new Imperial(2, 0, 0).addition(epaisseur_2).addition(distancesupp_2),
                    new Imperial(2, 0, 0)));
            Points pt10 = (new Points(new Imperial(2, 0, 0).addition(longueur).soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt9.getY()));
            Points pt11 = (new Points(pt10.getX(),
                    pt10.getY().soustraction(distancesupp_2).addition(epaisseur_2)));
            Points pt12 = (new Points(pt11.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt11.getY()));
            Points pt13 = (new Points(pt12.getX(),
                    pt12.getY().addition(distancesupp_2).addition(epaisseur_2)));
            Points pt14 = (new Points(pt9.getX().addition(distancesupp_2).addition(epaisseur_2),
                    pt13.getY()));
            Points pt15 = (new Points(pt14.getX(),
                    pt11.getY()));
            Points pt16 = (new Points(pt9.getX(),
                    pt12.getY()));
            pointsArriere.add(pt9);
            point_init_arriere = pt9;
            pointsArriere.add(pt10);
            pointsArriere.add(pt11);
            pointsArriere.add(pt12);
            pointsArriere.add(pt13);
            pointsArriere.add(pt14);
            pointsArriere.add(pt15);
            pointsArriere.add(pt16);
        }
        return pointsArriere;
    }

    public List<Points> initialiserMurDroite() {
        Imperial distancesupp = getDistanceSupp();
        Imperial distancesupp_2 = getDistanceSupp().division();
        Imperial longueur = getDimensions().getLongueur();
        Imperial profondeur = getDimensions().getProfondeur();
        Imperial epaisseur_2 = getEpaisseurMur().division();
        Imperial epaisseur = getEpaisseurMur();
        List<Points> pointsDroite = new ArrayList<>();
        if (getSensToit() == SensToit.Facade_arriere || getSensToit() == SensToit.Arriere_facade) {

            Points pt17 = (new Points(new Imperial(2, 0, 0).addition(longueur),
                    new Imperial(2, 0, 0).addition(epaisseur_2).addition(distancesupp_2)));
            Points pt18 = (new Points(pt17.getX(),
                    new Imperial(2, 0, 0).addition(profondeur).soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt19 = (new Points(pt18.getX().soustraction(epaisseur_2).addition(distancesupp_2),
                    pt18.getY()));
            Points pt20 = (new Points(pt19.getX(),
                    pt19.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt21 = (new Points(pt20.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt20.getY()));
            Points pt22 = (new Points(pt21.getX(),
                    pt17.getY().addition(epaisseur_2).addition(distancesupp_2)));
            Points pt23 = (new Points(pt20.getX(),
                    pt22.getY()));
            Points pt24 = (new Points(pt23.getX(),
                    pt17.getY()));
            pointsDroite.add(pt17);
            point_init_droite = pt17;
            pointsDroite.add(pt18);
            pointsDroite.add(pt19);
            pointsDroite.add(pt20);
            pointsDroite.add(pt21);
            pointsDroite.add(pt22);
            pointsDroite.add(pt23);
            pointsDroite.add(pt24);
        }
        
        else
        {
            Points pt17 = (new Points(new Imperial(2, 0, 0).addition(longueur),
                    new Imperial(2, 0, 0)));
            Points pt18 = (new Points(pt17.getX(),
                    new Imperial(2, 0, 0).addition(profondeur)));
            Points pt19 = (new Points(pt18.getX().soustraction(epaisseur_2).addition(distancesupp_2),
                    pt18.getY()));
            Points pt20 = (new Points(pt19.getX(),
                    pt19.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt21 = (new Points(pt20.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt20.getY()));
            Points pt22 = (new Points(pt21.getX(),
                    pt17.getY().addition(epaisseur_2).addition(distancesupp_2)));
            Points pt23 = (new Points(pt20.getX(),
                    pt22.getY()));
            Points pt24 = (new Points(pt23.getX(),
                    pt17.getY()));
            pointsDroite.add(pt17);
            point_init_droite = pt17;
            pointsDroite.add(pt18);
            pointsDroite.add(pt19);
            pointsDroite.add(pt20);
            pointsDroite.add(pt21);
            pointsDroite.add(pt22);
            pointsDroite.add(pt23);
            pointsDroite.add(pt24);
        }
        return pointsDroite;
    }

    public List<Points> initialiserMurGauche() {
        Imperial distancesupp = getDistanceSupp();
        Imperial distancesupp_2 = getDistanceSupp().division();
        Imperial longueur = getDimensions().getLongueur();
        Imperial profondeur = getDimensions().getProfondeur();
        Imperial epaisseur_2 = getEpaisseurMur().division();
        Imperial epaisseur = getEpaisseurMur();
        List<Points> pointsGauche = new ArrayList<>();
        if (getSensToit() == SensToit.Facade_arriere || getSensToit() == SensToit.Arriere_facade) {

            Points pt25 = (new Points(new Imperial(2, 0, 0),
                    new Imperial(2, 0, 0).addition(epaisseur_2).addition(distancesupp_2)));
            Points pt26 = (new Points(pt25.getX(),
                    new Imperial(2, 0, 0).addition(profondeur).soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt27 = (new Points(pt26.getX().addition(epaisseur_2).soustraction(distancesupp_2),
                    pt26.getY()));
            Points pt28 = (new Points(pt27.getX(),
                    pt27.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt29 = (new Points(pt28.getX().addition(epaisseur_2).addition(distancesupp_2),
                    pt28.getY()));
            Points pt30 = (new Points(pt29.getX(),
                    pt25.getY().addition(epaisseur_2).addition(distancesupp_2)));
            Points pt31 = (new Points(pt28.getX(),
                    pt30.getY()));
            Points pt32 = (new Points(pt31.getX(),
                    pt25.getY()));
            pointsGauche.add(pt25);
            point_init_gauche = pt25;
            pointsGauche.add(pt26);
            pointsGauche.add(pt27);
            pointsGauche.add(pt28);
            pointsGauche.add(pt29);
            pointsGauche.add(pt30);
            pointsGauche.add(pt31);
            pointsGauche.add(pt32);
        }
        else
        {
            Points pt25 = (new Points(new Imperial(2, 0, 0),
                    new Imperial(2, 0, 0)));
            Points pt26 = (new Points(pt25.getX(),
                    new Imperial(2, 0, 0).addition(profondeur)));
            Points pt27 = (new Points(pt26.getX().addition(epaisseur_2).soustraction(distancesupp_2),
                    pt26.getY()));
            Points pt28 = (new Points(pt27.getX(),
                    pt27.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt29 = (new Points(pt28.getX().addition(epaisseur_2).addition(distancesupp_2),
                    pt28.getY()));
            Points pt30 = (new Points(pt29.getX(),
                    pt25.getY().addition(epaisseur_2).addition(distancesupp_2)));
            Points pt31 = (new Points(pt28.getX(),
                    pt30.getY()));
            Points pt32 = (new Points(pt31.getX(),
                    pt25.getY()));
            pointsGauche.add(pt25);
            point_init_gauche = pt25;
            pointsGauche.add(pt26);
            pointsGauche.add(pt27);
            pointsGauche.add(pt28);
            pointsGauche.add(pt29);
            pointsGauche.add(pt30);
            pointsGauche.add(pt31);
            pointsGauche.add(pt32);   
        }
        return pointsGauche;
    }

    public List<Murs> initialiserMurs() {
        List<Murs> murs = new ArrayList<>();
        murs.clear();
        Murs murFacade = new Murs(initialiserMurFacade(), Orientation.Facade, new ArrayList<Accessoires>());
        Murs murArriere = new Murs(initialiserMurArriere(), Orientation.Arriere, new ArrayList<Accessoires>());
        Murs murDroite = new Murs(initialiserMurDroite(), Orientation.Droite, new ArrayList<Accessoires>());
        Murs murGauche = new Murs(initialiserMurGauche(), Orientation.Gauche, new ArrayList<Accessoires>());
        murs.add(murDroite);
        murs.add(murFacade);
        murs.add(murGauche);
        murs.add(murArriere);
        return murs;
    }
    
    
    public boolean valider_position_accessoire(Accessoires acc)
    {
    boolean valide = false;
    int position_acc_x;
    int position_acc_y;
    Dimensions dimensions_acc;
    Dimensions dimensions_murs;
    int width = 1344/4;
    int height = 806/3;
    int distance_supp = get_distance_validation().toPixel();
    int epaisseur = getEpaisseur().toPixel();
    for(Murs murs: getListmurs()){
    if(getSensToit() == SensToit.Arriere_facade || getSensToit() == SensToit.Facade_arriere){
        if ("arriere".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Arriere)
        {

             position_acc_x = acc.getPosition().getX().toPixel();
             position_acc_y = acc.getPosition().getY().toPixel();
             dimensions_acc = acc.getDimensionsAcc();
             dimensions_murs = getDimensions();
             System.out.println("Accessory position X: " + position_acc_x + ", Y: " + position_acc_y);
             System.out.println("Accessory dimensions: " + dimensions_acc);
             System.out.println("Wall dimensions: " + dimensions_murs);

             if((position_acc_x >= width + distance_supp + epaisseur) && (position_acc_x + dimensions_acc.getLongueur().toPixel() <= width + dimensions_murs.getLongueur().toPixel()- epaisseur - distance_supp)
    && (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
             {
             valide = true;
             }
            System.out.println("Validation result for this wall: " + valide);

        }
        if ("facade".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Facade)
        {
             position_acc_x = acc.getPosition().getX().toPixel();
             position_acc_y = acc.getPosition().getY().toPixel();
             dimensions_acc = acc.getDimensionsAcc();
             dimensions_murs = getDimensions();
             if((position_acc_x >= width + distance_supp + epaisseur) && (position_acc_x + dimensions_acc.getLongueur().toPixel() <= width + dimensions_murs.getLongueur().toPixel()- epaisseur - distance_supp)
    && (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
             {
             valide = true;
             }
        }
        if ("gauche".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Gauche)
        {
            position_acc_x = acc.getPosition().getX().toPixel();
            position_acc_y = acc.getPosition().getY().toPixel();
            dimensions_acc = acc.getDimensionsAcc();
            dimensions_murs = getDimensions();
            int p_mur_x_init = width + getEpaisseurMur().toPixel()/2 + getDistanceSupp().toPixel();
            int p_mur_x_fin = p_mur_x_init + dimensions_murs.getProfondeur().toPixel() - acc.getDimensionsAcc().getLongueur().toPixel();
            if((position_acc_x >= p_mur_x_init + distance_supp + epaisseur/2) && (position_acc_x <= p_mur_x_fin - distance_supp - epaisseur/2) &&
            (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
            {
            valide = true;
            }


        }
        if ("droite".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Droite)
        {
            position_acc_x = acc.getPosition().getX().toPixel();
            position_acc_y = acc.getPosition().getY().toPixel();
            dimensions_acc = acc.getDimensionsAcc();
            dimensions_murs = getDimensions();
            int p_mur_x_init = width + getEpaisseurMur().toPixel()/2 + getDistanceSupp().toPixel();
            int p_mur_x_fin = p_mur_x_init + dimensions_murs.getProfondeur().toPixel() - acc.getDimensionsAcc().getLongueur().toPixel();
            if((position_acc_x >= p_mur_x_init + distance_supp + epaisseur/2) && (position_acc_x <= p_mur_x_fin - distance_supp - epaisseur/2) &&
            (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
            {
            valide = true;
            }

        }
    }
    
    if(getSensToit() == SensToit.Droite_gauche||getSensToit() == SensToit.Gauche_droite){
        if ("arriere".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Arriere)
        {
            position_acc_x = acc.getPosition().getX().toPixel();
            position_acc_y = acc.getPosition().getY().toPixel();
            dimensions_acc = acc.getDimensionsAcc();
            dimensions_murs = getDimensions();
            int p_mur_x_init = width + getEpaisseurMur().toPixel()/2 + getDistanceSupp().toPixel();
            int p_mur_x_fin = p_mur_x_init + dimensions_murs.getLongueur().toPixel() - acc.getDimensionsAcc().getLongueur().toPixel();
            if((position_acc_x >= p_mur_x_init + distance_supp + epaisseur/2) && (position_acc_x <= p_mur_x_fin - distance_supp - epaisseur/2) &&
            (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
            {
            valide = true;
            }
   


        }
        if ("facade".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Facade)
        {
            position_acc_x = acc.getPosition().getX().toPixel();
            position_acc_y = acc.getPosition().getY().toPixel();
            dimensions_acc = acc.getDimensionsAcc();
            dimensions_murs = getDimensions();
            int p_mur_x_init = width + getEpaisseurMur().toPixel()/2 + getDistanceSupp().toPixel();
            int p_mur_x_fin = p_mur_x_init + dimensions_murs.getLongueur().toPixel() - acc.getDimensionsAcc().getLongueur().toPixel();
            if((position_acc_x >= p_mur_x_init + distance_supp + epaisseur/2) && (position_acc_x <= p_mur_x_fin - distance_supp - epaisseur/2) &&
            (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
            {
            valide = true;
            }


        }
        if ("gauche".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Gauche)
        {
             position_acc_x = acc.getPosition().getX().toPixel();
             position_acc_y = acc.getPosition().getY().toPixel();
             dimensions_acc = acc.getDimensionsAcc();
             dimensions_murs = getDimensions();
             if((position_acc_x >= width + distance_supp + epaisseur) && (position_acc_x + dimensions_acc.getLongueur().toPixel() <= width + dimensions_murs.getProfondeur().toPixel()- epaisseur - distance_supp)
    && (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
             {
             valide = true;
             }


        }
        if ("droite".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Droite)
        {
            position_acc_x = acc.getPosition().getX().toPixel();
             position_acc_y = acc.getPosition().getY().toPixel();
             dimensions_acc = acc.getDimensionsAcc();
             dimensions_murs = getDimensions();
             if((position_acc_x >= width + distance_supp + epaisseur) && (position_acc_x + dimensions_acc.getLongueur().toPixel() <= width + dimensions_murs.getProfondeur().toPixel()- epaisseur - distance_supp)
    && (position_acc_y >= height + distance_supp) && (position_acc_y + dimensions_acc.getHauteur().toPixel() <= height + dimensions_murs.getHauteur().toPixel() - distance_supp))
             {
             valide = true;
             }

        }
    }

    }
    return valide;
    
    }
    
    public void actualiser_position_porte(Accessoires acc)
    {
    Dimensions dimensions_acc = acc.getDimensionsAcc();
    Dimensions dimensions_murs;
    int height = 806/3;
    for(Murs murs: getListmurs()){
    if ("arriere".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Arriere)
        {
        dimensions_murs = getDimensions();
        int ajusted_y = height - dimensions_acc.getHauteur().toPixel() + dimensions_murs.getHauteur().toPixel() - get_distance_validation().toPixel();
        acc.setPosition(Points.fromPixelsToImperial(acc.getPosition().getX().toPixel(), ajusted_y));
        }
    if ("facade".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Facade)
        {
        dimensions_murs = getDimensions();
        int ajusted_y = height - dimensions_acc.getHauteur().toPixel() + dimensions_murs.getHauteur().toPixel() - get_distance_validation().toPixel();
        acc.setPosition(Points.fromPixelsToImperial(acc.getPosition().getX().toPixel(), ajusted_y));
        }
 
 
    if ("gauche".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Gauche)
        {
        dimensions_murs = getDimensions();
        int ajusted_y = height - dimensions_acc.getHauteur().toPixel() + dimensions_murs.getHauteur().toPixel() - get_distance_validation().toPixel();
        acc.setPosition(Points.fromPixelsToImperial(acc.getPosition().getX().toPixel(), ajusted_y));
        }
 
            
    if ("droite".equals(acc.getMurAssocie()) && murs.getOrientation() == Orientation.Droite)
        {
        dimensions_murs = getDimensions();
        int ajusted_y = height - dimensions_acc.getHauteur().toPixel() + dimensions_murs.getHauteur().toPixel() - get_distance_validation().toPixel();
        acc.setPosition(Points.fromPixelsToImperial(acc.getPosition().getX().toPixel(), ajusted_y));
        }

 
    }
    /**
     * public void changerDimensions(Dimensions nouvelleDim) {
     *
     * for (Murs mur : listmurs) { mur.onDimensionChanged(nouvelleDim); } }    /**
     * public void changerDimensions(Dimensions nouvelleDim) {
     *
     * for (Murs mur : listmurs) { mur.onDimensionChanged(nouvelleDim); } }
     */
    }
    


    
    
    
   public Dimensions get_concerned_wall_dimension_topview(Points mousepoint)
   {
    int width = 1344/4;
    int height = 806/3;
    int position_point_x = mousepoint.getX().toPixel();
    int position_point_y = mousepoint.getY().toPixel();
    Dimensions dimensions_murs = getDimensions();
    int x_f = point_init_facade.getX().toPixel();
    int y_f = point_init_facade.getY().toPixel();
    int x_a = point_init_arriere.getX().toPixel();
    int y_a = point_init_arriere.getY().toPixel();
    int x_d = point_init_droite.getX().toPixel();
    int y_d = point_init_droite.getY().toPixel();
    int x_g = point_init_gauche.getX().toPixel();
    int y_g = point_init_gauche.getY().toPixel();
    int distance_supp = getDistanceSupp().toPixel();
    int epaisseur = getEpaisseur().toPixel();
    Dimensions dimensions = null;
    Imperial imperial = new Imperial(0, 0, 0);
    
       
    if(getOrientation() == Orientation.Dessus)
    {
    if((x_d >= position_point_x)&&(position_point_x >= x_d - epaisseur) && (y_a + epaisseur + distance_supp <= position_point_y) && 
            (y_a + dimensions_murs.getProfondeur().toPixel() - epaisseur/2 >= position_point_y))
    {
    afficher_facade = false;
    afficher_arriere = false;
    afficher_droite = true;
    afficher_gauche = false;
    }
    if(afficher_droite == true)
    {
    dimensions = new Dimensions(dimensions_murs.getHauteur(), imperial, dimensions_murs.getProfondeur());
    }
    
    
   
    if((x_f <= position_point_x)&&(position_point_x <= x_f + epaisseur) && (y_a + epaisseur + distance_supp <= position_point_y) && 
            (y_a + dimensions_murs.getProfondeur().toPixel() - epaisseur/2 >= position_point_y))
    {
    afficher_facade = false;
    afficher_arriere = false;
    afficher_droite = false;
    afficher_gauche = true;
    }
    if(afficher_gauche == true)
    {
    dimensions = new Dimensions(dimensions_murs.getHauteur(), imperial, dimensions_murs.getProfondeur());
    }
    
    
    
    if((x_f + epaisseur + distance_supp <= position_point_x)&&(position_point_x <= x_f + dimensions_murs.getLongueur().toPixel() - distance_supp)
    && (y_a <= position_point_y) && (y_a + epaisseur >= position_point_y ))
    {
    afficher_facade = false;
    afficher_arriere = true;
    afficher_droite = false;
    afficher_gauche = false;
    if(afficher_arriere == true)
    {
    dimensions = new Dimensions(dimensions_murs.getHauteur(), dimensions_murs.getLongueur(), imperial);
    }
    }
    
   


    if((x_f + epaisseur + distance_supp <= position_point_x)&&(position_point_x <= x_f + dimensions_murs.getLongueur().toPixel() - distance_supp)
            && (y_f >= position_point_y) && (y_f - epaisseur <= position_point_y ))
    {
    afficher_facade = true;
    afficher_arriere = false;
    afficher_droite = false;
    afficher_gauche = false;
    }
    if(afficher_facade == true)
    {
    dimensions = new Dimensions(dimensions_murs.getHauteur(), dimensions_murs.getLongueur(), imperial);
    }
    }
    if(getSensToit() == SensToit.Arriere_facade || getSensToit() == SensToit.Facade_arriere)
        {
        if (getOrientation() == Orientation.Arriere || getOrientation() == Orientation.Facade)
        {
        if ((width <= position_point_x) && (width + dimensions_murs.getLongueur().toPixel() >= position_point_x) && 
                (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = true;
        afficher_arriere = false;
        afficher_droite = false;
        afficher_gauche = false;
        }
        if(afficher_facade == true)
        {
        dimensions = new Dimensions(dimensions_murs.getHauteur(), dimensions_murs.getLongueur(), imperial);
        }

        }
        
        if(getOrientation() == Orientation.Gauche || getOrientation() == Orientation.Droite)
        {
        if((width <= position_point_x) && (width + epaisseur/2 - distance_supp >= position_point_x) &&
            (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = true;
        afficher_arriere = false;
        afficher_droite = false;
        afficher_gauche = false;
        }
        if((width + epaisseur/2 <= position_point_x) && (width + epaisseur/2 + dimensions_murs.getProfondeur().toPixel() >= position_point_x) &&
            (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = false;
        afficher_arriere = false;
        afficher_droite = true;
        afficher_gauche = false;
        }
        if((width + epaisseur/2 + dimensions_murs.getProfondeur().toPixel() + distance_supp <= position_point_x)
                && (width + epaisseur + dimensions_murs.getProfondeur().toPixel() + distance_supp >= position_point_x) &&
            (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = true;
        afficher_arriere = false;
        afficher_droite = false;
        afficher_gauche = false;
        }
        
        if(afficher_facade == true)
        {
        dimensions = new Dimensions(dimensions_murs.getHauteur(), dimensions_murs.getLongueur(), imperial);
        }
        if(afficher_droite == true)
        {
        dimensions = new Dimensions(dimensions_murs.getHauteur(), imperial, dimensions_murs.getProfondeur());
        }

        }

    }
        if(getSensToit() == SensToit.Droite_gauche || getSensToit() == SensToit.Gauche_droite)
        {
        if (getOrientation() == Orientation.Gauche || getOrientation() == Orientation.Droite)
        {
        if ((width <= position_point_x) && (width + dimensions_murs.getProfondeur().toPixel() >= position_point_x) && 
                (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = false;
        afficher_arriere = false;
        afficher_droite = true;
        afficher_gauche = false;
        }
        if(afficher_droite == true)
        {
        dimensions = new Dimensions(dimensions_murs.getHauteur(), imperial, dimensions_murs.getProfondeur());
        }

        }
        
        if(getOrientation() == Orientation.Facade || getOrientation() == Orientation.Arriere)
        {
        if((width <= position_point_x) && (width + epaisseur/2 - distance_supp >= position_point_x) &&
            (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = false;
        afficher_arriere = false;
        afficher_droite = true;
        afficher_gauche = false;
        }
        if((width + epaisseur/2 <= position_point_x) && (width + epaisseur/2 + dimensions_murs.getLongueur().toPixel() >= position_point_x) &&
            (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = true;
        afficher_arriere = false;
        afficher_droite = false;
        afficher_gauche = false;
        }
        if((width + epaisseur/2 + dimensions_murs.getLongueur().toPixel() + distance_supp <= position_point_x)
                && (width + epaisseur + dimensions_murs.getLongueur().toPixel() + distance_supp >= position_point_x) &&
            (height <= position_point_y) && (height + dimensions_murs.getHauteur().toPixel() >= position_point_y ))
        {
        afficher_facade = false;
        afficher_arriere = false;
        afficher_droite = true;
        afficher_gauche = false;
        }
        
        if(afficher_facade == true)
        {
        dimensions = new Dimensions(dimensions_murs.getHauteur(), dimensions_murs.getLongueur(), imperial);
        }
        if(afficher_droite == true)
        {
        dimensions = new Dimensions(dimensions_murs.getHauteur(), imperial, dimensions_murs.getProfondeur());
        }
    
        }
     
    } 
    return dimensions;
    }
    
public Chalet deepCopy() throws IOException, ClassNotFoundException {
    try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
        objectOutputStream.writeObject(this);
 
        try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
             ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)) {
            return (Chalet) objectInputStream.readObject();
        }
    }
}
   
   



    
    
    
    
    
    
    
    
    
   
   }
    
    
    
    
    
    
    
  
    

