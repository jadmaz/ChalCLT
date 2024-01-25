/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.drawer;

import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.Orientation;
import ca.ulaval.glo2004.domain.utils.*;
import ca.ulaval.glo2004.gui.MainWindow;
import ca.ulaval.glo2004.domain.SensToit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.lang.Math;
/**
 *
 * @author 14189
 */
public class AfficheurMur implements chaletDrawer {

    public AfficheurMur(MainWindow outer) {
    }

    @Override
    public void drawDessus(Graphics g, Controleur controller, Dimension initialDimension) {
        int width = 1344;
        int height = 806;
        if(controller.getSensToit() == SensToit.Facade_arriere || controller.getSensToit() == SensToit.Arriere_facade)
        {
        if(controller.getMurOrientation() == Orientation.Arriere || controller.getMurOrientation() == Orientation.Facade)
            {
            Imperial hauteur = controller.getDimensions().getHauteur();
            Imperial longueur = controller.getDimensions().getLongueur();
            int hauteur_convertie = hauteur.toPixel();
            int longueur_convertie = longueur.toPixel();
            
            g.setColor(Color.BLUE);
            g.fillRect(width/4, height/3, longueur_convertie , hauteur_convertie);
        }
        else
        {
            
            Imperial profondeur = controller.getDimensions().getProfondeur();
            Imperial hauteur = controller.getDimensions().getHauteur();
            Imperial epaisseur = controller.getEpaisseur();
            Imperial distance_supplementaire = controller.getDistanceSupp();
            int profondeur_convertie = profondeur.toPixel();
            int hauteur_convertie = hauteur.toPixel();
            int epaisseur_convertie = epaisseur.toPixel();
            int distance_convertie = distance_supplementaire.toPixel();
            int moitie_epaisseur = epaisseur_convertie/2;
            int distance_supp = width/4 + moitie_epaisseur + distance_convertie;
            int distance_supp2 = distance_supp + profondeur_convertie + distance_convertie;
            g.setColor(new Color(255, 165, 0));
            g.fillRect(distance_supp, height/3, profondeur_convertie, hauteur_convertie);
            if(controller.getMurSeul() == false){
            g.setColor(Color.BLUE);
            g.fillRect(width/4, height/3, moitie_epaisseur, hauteur_convertie);
            g.setColor(Color.BLUE);
            g.fillRect(distance_supp2, height/3, moitie_epaisseur, hauteur_convertie);
        }}
        }
        else
        {
            if(controller.getMurOrientation() == Orientation.Arriere || controller.getMurOrientation() == Orientation.Facade)
            {
            Imperial hauteur = controller.getDimensions().getHauteur();
            Imperial longueur = controller.getDimensions().getLongueur();
            Imperial epaisseur = controller.getEpaisseur();
            Imperial distance_supplementaire = controller.getDistanceSupp();
            int hauteur_convertie = hauteur.toPixel();
            int longueur_convertie = longueur.toPixel();
            int epaisseur_convertie = epaisseur.toPixel();
            int distance_convertie = distance_supplementaire.toPixel();
            int moitie_epaisseur = epaisseur_convertie/2;
            int distance_supp = width/4 + moitie_epaisseur + distance_convertie;
            int distance_supp2 = distance_supp + longueur_convertie + distance_convertie;
            g.setColor(Color.BLUE);
            g.fillRect(distance_supp, height/3, longueur_convertie, hauteur_convertie);
            if(controller.getMurSeul() == false){
            g.setColor(new Color(255, 165, 0));
            g.fillRect(width/4, height/3, moitie_epaisseur, hauteur_convertie);
            g.setColor(new Color(255, 165, 0));
            g.fillRect(distance_supp2, height/3, moitie_epaisseur, hauteur_convertie);
        }}
        else
        {
            Imperial hauteur = controller.getDimensions().getHauteur();
            Imperial profondeur = controller.getDimensions().getProfondeur();
            int hauteur_convertie = hauteur.toPixel();
            int profondeur_convertie = profondeur.toPixel();
            
            g.setColor(new Color(255, 165, 0));
            g.fillRect(width/4, height/3, profondeur_convertie , hauteur_convertie);
        }
        }
       
    }
    
    @Override
    public void drawToit(Graphics g,Controleur controller, Dimension initialDimension){
        int angle = controller.getAngle();
        int width = 1344;
        int height = 806;
        Imperial hauteur = controller.getDimensions().getHauteur();
        Imperial longueur = controller.getDimensions().getLongueur();
        Imperial profondeur = controller.getDimensions().getProfondeur();
        Imperial epaisseur = controller.getEpaisseur();
        Imperial distance_supplementaire = controller.getDistanceSupp();
        int profondeur_convertie = profondeur.toPixel();
        int hauteur_convertie = hauteur.toPixel();
        int longueur_convertie = longueur.toPixel();
        int epaisseur_convertie = epaisseur.toPixel();
        int distance_convertie = distance_supplementaire.toPixel();
        int moitie_epaisseur = epaisseur_convertie/2;
        int distance_supp = width/4 + moitie_epaisseur + distance_convertie;
        int distance_supp2 = distance_supp + longueur_convertie + distance_convertie;
        int distance_supp3 = distance_supp + profondeur_convertie + distance_convertie;
        if(controller.getMurOrientation() == Orientation.Facade && controller.getMurSeul() == false)
            {
            if(controller.getSensToit() == SensToit.Facade_arriere){
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * longueur_convertie), longueur_convertie , (int) (Math.tan(Math.toRadians(angle)) * longueur_convertie));
            }
            if(controller.getSensToit() == SensToit.Arriere_facade){
                g.setColor(Color.RED);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)),
                        longueur_convertie, (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)));
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 -(int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur, longueur_convertie, moitie_epaisseur); 
            }
            if(controller.getSensToit() == SensToit.Droite_gauche){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = width/4;
                XPointsRallonge[1] = width/4 + moitie_epaisseur;
                XPointsRallonge[2] = width/4 + moitie_epaisseur;
                XPointsRallonge[3] = width/4;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = width/4 + moitie_epaisseur + distance_convertie;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                XPointsToit[2] = distance_supp2 + moitie_epaisseur;
                XPointsToit[3] = distance_supp2 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie));
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3;
                YPointsToit[3] = height/3 - moitie_epaisseur;
                YPointsToit[4] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            if(controller.getSensToit() == SensToit.Gauche_droite){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = distance_supp2;
                XPointsRallonge[1] = distance_supp2 + moitie_epaisseur;
                XPointsRallonge[2] = distance_supp2 + moitie_epaisseur;
                XPointsRallonge[3] = distance_supp2;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = distance_supp;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = distance_supp;
                XPointsToit[2] = distance_supp2 + moitie_epaisseur;
                XPointsToit[3] = distance_supp2 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3;
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) ;
                YPointsToit[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                YPointsToit[4] = height/3 - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            }
        if(controller.getMurOrientation() == Orientation.Arriere && controller.getMurSeul() == false){{
            if(controller.getSensToit() == SensToit.Arriere_facade){
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * longueur_convertie), longueur_convertie , (int) (Math.tan(Math.toRadians(angle)) * longueur_convertie));
            }
            if(controller.getSensToit() == SensToit.Facade_arriere){
                g.setColor(Color.RED);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)),
                        longueur_convertie, (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)));
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 -(int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur, longueur_convertie, moitie_epaisseur); 
            }
            if(controller.getSensToit() == SensToit.Droite_gauche){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = distance_supp2;
                XPointsRallonge[1] = distance_supp2 + moitie_epaisseur;
                XPointsRallonge[2] = distance_supp2 + moitie_epaisseur;
                XPointsRallonge[3] = distance_supp2;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = distance_supp;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = distance_supp;
                XPointsToit[2] = distance_supp2 + moitie_epaisseur;
                XPointsToit[3] = distance_supp2 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3;
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) ;
                YPointsToit[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                YPointsToit[4] = height/3 - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            if(controller.getSensToit() == SensToit.Gauche_droite){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = width/4;
                XPointsRallonge[1] = width/4 + moitie_epaisseur;
                XPointsRallonge[2] = width/4 + moitie_epaisseur;
                XPointsRallonge[3] = width/4;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = width/4 + moitie_epaisseur + distance_convertie;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = width/4 + moitie_epaisseur + distance_convertie + longueur_convertie;
                XPointsToit[2] = distance_supp2 + moitie_epaisseur;
                XPointsToit[3] = distance_supp2 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie));
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3;
                YPointsToit[3] = height/3 - moitie_epaisseur;
                YPointsToit[4] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (longueur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            }}
        if(controller.getMurOrientation() == Orientation.Droite && controller.getMurSeul() == false){{
            if(controller.getSensToit() == SensToit.Droite_gauche){
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * profondeur_convertie), profondeur_convertie , (int) (Math.tan(Math.toRadians(angle)) * profondeur_convertie));
            }
            if(controller.getSensToit() == SensToit.Gauche_droite){
                g.setColor(Color.RED);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)),
                        profondeur_convertie, (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)));
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 -(int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur, profondeur_convertie, moitie_epaisseur); 
            }
            if(controller.getSensToit() == SensToit.Facade_arriere){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = distance_supp3;
                XPointsRallonge[1] = distance_supp3 + moitie_epaisseur;
                XPointsRallonge[2] = distance_supp3 + moitie_epaisseur;
                XPointsRallonge[3] = distance_supp3;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = distance_supp;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = distance_supp;
                XPointsToit[2] = distance_supp3 + moitie_epaisseur;
                XPointsToit[3] = distance_supp3 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3;
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) ;
                YPointsToit[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                YPointsToit[4] = height/3 - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            if(controller.getSensToit() == SensToit.Arriere_facade){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = width/4;
                XPointsRallonge[1] = width/4 + moitie_epaisseur;
                XPointsRallonge[2] = width/4 + moitie_epaisseur;
                XPointsRallonge[3] = width/4;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = width/4 + moitie_epaisseur + distance_convertie;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                XPointsToit[2] = distance_supp3 + moitie_epaisseur;
                XPointsToit[3] = distance_supp3 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie));
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3;
                YPointsToit[3] = height/3 - moitie_epaisseur;
                YPointsToit[4] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            }}
        if(controller.getMurOrientation() == Orientation.Gauche && controller.getMurSeul() == false){{
            if(controller.getSensToit() == SensToit.Gauche_droite){
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * profondeur_convertie), profondeur_convertie , (int) (Math.tan(Math.toRadians(angle)) * profondeur_convertie));
            }
            if(controller.getSensToit() == SensToit.Droite_gauche){
                g.setColor(Color.RED);
                g.fillRect(width/4, height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)),
                        profondeur_convertie, (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)));
                g.setColor(Color.BLACK);
                g.fillRect(width/4, height/3 -(int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur, profondeur_convertie, moitie_epaisseur); 
            }
            if(controller.getSensToit() == SensToit.Facade_arriere){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = width/4;
                XPointsRallonge[1] = width/4 + moitie_epaisseur;
                XPointsRallonge[2] = width/4 + moitie_epaisseur;
                XPointsRallonge[3] = width/4;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = width/4 + moitie_epaisseur + distance_convertie;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                XPointsToit[2] = distance_supp3 + moitie_epaisseur;
                XPointsToit[3] = distance_supp3 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie));
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3;
                YPointsToit[3] = height/3 - moitie_epaisseur;
                YPointsToit[4] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            if(controller.getSensToit() == SensToit.Arriere_facade){
                int[] XPointsRallonge = new int[4];
                XPointsRallonge[0] = distance_supp3;
                XPointsRallonge[1] = distance_supp3 + moitie_epaisseur;
                XPointsRallonge[2] = distance_supp3 + moitie_epaisseur;
                XPointsRallonge[3] = distance_supp3;
                int[] YPointsRallonge = new int[4];
                YPointsRallonge[0] = height/3;
                YPointsRallonge[1] = height/3;
                YPointsRallonge[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie));
                YPointsRallonge[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + distance_convertie));
                g.setColor(Color.RED);
                g.fillPolygon(XPointsRallonge, YPointsRallonge, 4);
                int[] XPointsPignon = new int[3];
                XPointsPignon[0] = distance_supp;
                XPointsPignon[1] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                XPointsPignon[2] = width/4 + moitie_epaisseur + distance_convertie + profondeur_convertie;
                int[] YPointsPignon = new int[3];
                YPointsPignon[0] = height/3;
                YPointsPignon[1] = height/3;
                YPointsPignon[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie));
                g.setColor(Color.GREEN);
                g.fillPolygon(XPointsPignon, YPointsPignon, 3);
                int[] XPointsToit = new int[5];
                XPointsToit[0] = width/4;
                XPointsToit[1] = distance_supp;
                XPointsToit[2] = distance_supp3 + moitie_epaisseur;
                XPointsToit[3] = distance_supp3 + moitie_epaisseur;
                XPointsToit[4] = width/4;
                int[] YPointsToit = new int[5];
                YPointsToit[0] = height/3;
                YPointsToit[1] = height/3;
                YPointsToit[2] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) ;
                YPointsToit[3] = height/3 - (int) (Math.tan(Math.toRadians(angle)) * (profondeur_convertie + moitie_epaisseur + distance_convertie)) - moitie_epaisseur;
                YPointsToit[4] = height/3 - moitie_epaisseur;
                g.setColor(Color.YELLOW);
                g.fillPolygon(XPointsToit, YPointsToit, 5);
            }
            }}
        
        
    }
    }