/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.export;

import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.domain.SensToit;
import ca.ulaval.glo2004.domain.utils.Imperial;
import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.gui.TypeExport;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author 14189
 *
 *
 */
public class ExportFini extends ExportSTL {

    public ExportFini(String path) {
        super(path);
    }

    public void exporterMur(Controleur controller, List<Vertex> vertexList, List<Triangle> triangles, double z, List<AccessoiresDTO> accs, List<Triangle> listm1, List<Triangle> listm2, List<Triangle> listm3, List<Triangle> listm4) {
        List<AccessoiresDTO> accmur1 = new ArrayList<>(); // facade
        List<AccessoiresDTO> accmur2 = new ArrayList<>();  // gauche
        List<AccessoiresDTO> accmur3 = new ArrayList<>();  // arriere
        List<AccessoiresDTO> accmur4 = new ArrayList<>();  //droite

        System.out.println("ZZZZ:  " + z);

        for (AccessoiresDTO ac : accs) {
            if (ac.is_valid) {
                switch (ac.mur_associe) {
                    case "facade":
                        accmur1.add(ac);
                        break;
                    case "arriere":
                        accmur3.add(ac);
                        break;
                    case "droite":
                        accmur4.add(ac);
                        break;
                    case "gauche":
                        accmur2.add(ac);
                        break;
                    default:
                        break;
                }
            }
        }

        Collections.sort(accmur1, (ac1, ac2) -> {
            return Integer.compare(ac1.position.x.toPixel(), ac2.position.x.toPixel());
        });

        Collections.sort(accmur2, (ac1, ac2) -> {
            return Integer.compare(ac1.position.x.toPixel(), ac2.position.x.toPixel());
        });

        Collections.sort(accmur3, (ac1, ac2) -> {
            return Integer.compare(ac1.position.x.toPixel(), ac2.position.x.toPixel());
        });

        Collections.sort(accmur4, (ac1, ac2) -> {
            return Integer.compare(ac1.position.x.toPixel(), ac2.position.x.toPixel());
        });

        List<AccessoiresDTO> accmur1y = new ArrayList<>(accmur1);

        Collections.sort(accmur1y, (ac1, ac2) -> {
            return Integer.compare(ac1.position.y.toPixel(), ac2.position.y.toPixel());
        });

        List<AccessoiresDTO> accmur2y = new ArrayList<>(accmur2);

        Collections.sort(accmur2y, (ac1, ac2) -> {
            return Integer.compare(ac1.position.y.toPixel(), ac2.position.y.toPixel());
        });

        List<AccessoiresDTO> accmur3y = new ArrayList<>(accmur3);

        Collections.sort(accmur3y, (ac1, ac2) -> {
            return Integer.compare(ac1.position.y.toPixel(), ac2.position.y.toPixel());
        });

        List<AccessoiresDTO> accmur4y = new ArrayList<>(accmur4);

        Collections.sort(accmur4y, (ac1, ac2) -> {
            return Integer.compare(ac1.position.y.toPixel(), ac2.position.y.toPixel());
        });

        List<Vertex> mur1 = new ArrayList<>();
        List<Vertex> mur2 = new ArrayList<>();
        List<Vertex> mur3 = new ArrayList<>();
        List<Vertex> mur4 = new ArrayList<>();

        if (controller.getSensToit() == SensToit.Facade_arriere || controller.getSensToit() == SensToit.Arriere_facade) {
        //mur1
        mur1.add(vertexList.get(0));
        mur1.add(vertexList.get(26));
        mur1.add(vertexList.get(27));
        mur1.add(vertexList.get(18));
        mur1.add(vertexList.get(19));
        mur1.add(vertexList.get(11));
        mur1.add(vertexList.get(10));
        mur1.add(vertexList.get(1));

        //mur2
        mur2.add(vertexList.get(28));
        mur2.add(vertexList.get(22));
        mur2.add(vertexList.get(23));
        mur2.add(vertexList.get(16));
        mur2.add(vertexList.get(17));
        mur2.add(vertexList.get(24));
        mur2.add(vertexList.get(25));
        mur2.add(vertexList.get(29));

        //mur3
        mur3.add(vertexList.get(30));
        mur3.add(vertexList.get(31));
        mur3.add(vertexList.get(5));
        mur3.add(vertexList.get(4));
        mur3.add(vertexList.get(13));
        mur3.add(vertexList.get(12));
        mur3.add(vertexList.get(20));
        mur3.add(vertexList.get(21));

        //mur4
        mur4.add(vertexList.get(3));
        mur4.add(vertexList.get(2));
        mur4.add(vertexList.get(6));
        mur4.add(vertexList.get(7));
        mur4.add(vertexList.get(14));
        mur4.add(vertexList.get(15));
        mur4.add(vertexList.get(8));
        mur4.add(vertexList.get(9));}
        else {
        //mur1
        mur1.add(vertexList.get(6));
        mur1.add(vertexList.get(22));
        mur1.add(vertexList.get(23));
        mur1.add(vertexList.get(16));
        mur1.add(vertexList.get(17));
        mur1.add(vertexList.get(13));
        mur1.add(vertexList.get(12));
        mur1.add(vertexList.get(7));

        //mur2
        mur2.add(vertexList.get(30));
        mur2.add(vertexList.get(26));
        mur2.add(vertexList.get(27));
        mur2.add(vertexList.get(20));
        mur2.add(vertexList.get(21));
        mur2.add(vertexList.get(28));
        mur2.add(vertexList.get(29));
        mur2.add(vertexList.get(31));

        //mur3
        mur3.add(vertexList.get(25));
        mur3.add(vertexList.get(9));
        mur3.add(vertexList.get(8));
        mur3.add(vertexList.get(15));
        mur3.add(vertexList.get(14));
        mur3.add(vertexList.get(18));
        mur3.add(vertexList.get(19));
        mur3.add(vertexList.get(24));

        //mur4
        mur4.add(vertexList.get(1));
        mur4.add(vertexList.get(0));
        mur4.add(vertexList.get(2));
        mur4.add(vertexList.get(3));
        mur4.add(vertexList.get(10));
        mur4.add(vertexList.get(11));
        mur4.add(vertexList.get(8));
        mur4.add(vertexList.get(5));
        
        }
        List<Vertex> mur1h = new ArrayList<>();
        List<Vertex> mur2h = new ArrayList<>();
        List<Vertex> mur3h = new ArrayList<>();
        List<Vertex> mur4h = new ArrayList<>();

        // Afficher les listes pour chaque mur si nécessaire
        System.out.println("Mur 1: ");
        for (Vertex point : mur1) {
            System.out.println(point);
            mur1h.add(new Vertex(point.x, point.y, z));

        }
        System.out.println("Mur 2: ");
        for (Vertex point : mur2) {
            System.out.println(point);
            mur2h.add(new Vertex(point.x, point.y, z));
        }
        System.out.println("Mur 3: ");
        for (Vertex point : mur3) {
            System.out.println(point);
            mur3h.add(new Vertex(point.x, point.y, z));
        }
        System.out.println("Mur 4: ");
        for (Vertex point : mur4) {
            System.out.println(point);
            mur4h.add(new Vertex(point.x, point.y, z));
        }

        System.out.println(mur1h.get(0));

        //mur 1 drawing
        Vertex pm11 = mur1.get(0);
        Vertex pm12 = mur1.get(1);
        Vertex pm13 = mur1.get(2);
        Vertex pm14 = mur1.get(3);
        Vertex pm15 = mur1.get(4);
        Vertex pm16 = mur1.get(5);
        Vertex pm17 = mur1.get(6);
        Vertex pm18 = mur1.get(7);

        Vertex pm11h = mur1h.get(0);
        Vertex pm12h = mur1h.get(1);
        Vertex pm13h = mur1h.get(2);
        Vertex pm14h = mur1h.get(3);
        Vertex pm15h = mur1h.get(4);
        Vertex pm16h = mur1h.get(5);
        Vertex pm17h = mur1h.get(6);
        Vertex pm18h = mur1h.get(7);

        listm1.add(new Triangle(pm11, pm12, pm13));
        listm1.add(new Triangle(pm11, pm13, pm18));

        listm1.add(new Triangle(pm15, pm14, pm17));
        listm1.add(new Triangle(pm15, pm16, pm17));

        listm1.add(new Triangle(pm11h, pm12h, pm13h));
        listm1.add(new Triangle(pm11h, pm13h, pm18h));

        listm1.add(new Triangle(pm15h, pm14h, pm17h));
        listm1.add(new Triangle(pm15h, pm16h, pm17h));

        listm1.add(new Triangle(pm12, pm12h, pm13));
        listm1.add(new Triangle(pm12h, pm13h, pm13));

        listm1.add(new Triangle(pm13, pm13h, pm14));
        listm1.add(new Triangle(pm13h, pm14h, pm14));

        listm1.add(new Triangle(pm14, pm14h, pm15));
        listm1.add(new Triangle(pm14h, pm15h, pm15));

        listm1.add(new Triangle(pm16, pm16h, pm17));
        listm1.add(new Triangle(pm16h, pm17h, pm17));

        listm1.add(new Triangle(pm17, pm17h, pm18));
        listm1.add(new Triangle(pm17h, pm18h, pm18));

        listm1.add(new Triangle(pm18, pm18h, pm11));
        listm1.add(new Triangle(pm18h, pm11h, pm11));

        // mur 1 accs drawing 
        if (accmur1.isEmpty()) {

            listm1.add(new Triangle(pm11h, pm12h, pm12));
            listm1.add(new Triangle(pm11h, pm11, pm12));
            listm1.add(new Triangle(pm15, pm15h, pm16));
            listm1.add(new Triangle(pm15h, pm16h, pm16));

        }
        if (!accmur1.isEmpty()) {

            AccessoiresDTO ac1 = accmur1.get(0);
            Vertex pt1 = new Vertex(ac1.position.x.toPixel() - 230, pm11h.y, z);

            Vertex pt2 = new Vertex(ac1.position.x.toPixel() - 230, pm11.y, 0);

            Vertex pt1h = new Vertex(ac1.position.x.toPixel() - 230, pm16h.y, z);

            Vertex pt2h = new Vertex(ac1.position.x.toPixel() - 230, pm16h.y, 0);

            listm1.add(new Triangle(pm11h, pt1, pt2));
            listm1.add(new Triangle(pm11h, pm11, pt2));
            listm1.add(new Triangle(pm16h, pt1h, pt2h));
            listm1.add(new Triangle(pm16h, pm16, pt2h));

            System.out.println(z);

            int z1 = controller.getDimensions().getHauteur().toPixel();

            int x1 = Math.abs(806 / 3 - ac1.position.getY().toPixel());
            int x = Math.abs(806 / 3 - ac1.position.getY().toPixel() - ac1.dimensions.getHauteur().toPixel());

            if (x < x1) {

                int temp = x;
                x = x1;
                x1 = temp;
            }

            System.out.println("y1=" + (z1 - x1));
            System.out.println("y2=" + (z1 - x));

            Vertex pt3 = new Vertex(ac1.position.x.toPixel() - 230, pm11h.y, z1 - x1);

            Vertex pt4 = new Vertex(ac1.position.x.toPixel() - 230, pm11.y, z1 - x);

            Vertex pt5 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm11h.y, z1 - x1);

            Vertex pt6 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm11.y, z1 - x);

            Vertex pt7 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm11h.y, z);

            Vertex pt8 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm11.y, 0);

            Vertex pt3h = new Vertex(ac1.position.x.toPixel() - 230, pm16h.y, z1 - x1);

            Vertex pt4h = new Vertex(ac1.position.x.toPixel() - 230, pm16.y, z1 - x);

            Vertex pt5h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm16h.y, z1 - x1);

            Vertex pt6h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm16.y, z1 - x);

            Vertex pt7h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm16h.y, z);

            Vertex pt8h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm16.y, 0);

            listm1.add(new Triangle(pt1, pt7, pt5));
            listm1.add(new Triangle(pt1, pt3, pt5));

            listm1.add(new Triangle(pt4, pt6, pt8));
            listm1.add(new Triangle(pt4, pt2, pt8));

            listm1.add(new Triangle(pt1h, pt7h, pt5h));
            listm1.add(new Triangle(pt1h, pt3h, pt5h));

            listm1.add(new Triangle(pt4h, pt6h, pt8h));
            listm1.add(new Triangle(pt4h, pt2h, pt8h));

            listm1.add(new Triangle(pt3, pt3h, pt4h));
            listm1.add(new Triangle(pt3, pt4, pt4h));

            listm1.add(new Triangle(pt3, pt3h, pt5h));
            listm1.add(new Triangle(pt3, pt5, pt5h));

            listm1.add(new Triangle(pt5, pt5h, pt6h));
            listm1.add(new Triangle(pt5, pt6, pt6h));

            listm1.add(new Triangle(pt6, pt6h, pt4h));
            listm1.add(new Triangle(pt6, pt4, pt4h));

            if (accmur1.size() == 1) {
                listm1.add(new Triangle(pt7, pm12h, pm12));
                listm1.add(new Triangle(pt7, pt8, pm12));

                listm1.add(new Triangle(pt7h, pm15h, pm15));
                listm1.add(new Triangle(pt7h, pt8h, pm15));

            } else {

                AccessoiresDTO ac2 = accmur1.get(1);

                Vertex pt9 = new Vertex(ac2.position.x.toPixel() - 230, pm11h.y, z);

                Vertex pt10 = new Vertex(ac2.position.x.toPixel() - 230, pm11.y, 0);

                listm1.add(new Triangle(pt7, pt9, pt10));
                listm1.add(new Triangle(pt7, pt8, pt10));

                int x3 = Math.abs(806 / 3 - ac2.position.getY().toPixel());
                int xx = Math.abs(806 / 3 - ac2.position.getY().toPixel() - ac2.dimensions.getHauteur().toPixel());
                System.out.println("y3=" + (z1 - x3));

                Vertex pt11 = new Vertex(ac2.position.x.toPixel() - 230, pm11.y, z1 - x3);
                Vertex pt12 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm11.y, z1 - x3);
                Vertex pt13 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm11.y, z);
                Vertex ptxx1 = new Vertex(ac2.position.x.toPixel() - 230, pm11.y, z1 - xx);
                Vertex ptxx2 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm11.y, z1 - xx);
                Vertex pt14 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm11.y, 0);
                listm1.add(new Triangle(pt9, pt13, pt12));
                listm1.add(new Triangle(pt9, pt11, pt12));

                listm1.add(new Triangle(ptxx1, ptxx2, pt14));
                listm1.add(new Triangle(ptxx1, pt10, pt14));

                Vertex pt9h = new Vertex(ac2.position.x.toPixel() - 230, pm16h.y, z);
                Vertex pt10h = new Vertex(ac2.position.x.toPixel() - 230, pm16.y, 0);
                Vertex pt11h = new Vertex(ac2.position.x.toPixel() - 230, pm16.y, z1 - x3);
                Vertex pt12h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm16.y, z1 - x3);
                Vertex pt13h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm16.y, z);
                Vertex ptxx1h = new Vertex(ac2.position.x.toPixel() - 230, pm16.y, z1 - xx);
                Vertex ptxx2h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm16.y, z1 - xx);
                Vertex pt14h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm16.y, 0);

                listm1.add(new Triangle(pt7h, pt9h, pt10h));
                listm1.add(new Triangle(pt7h, pt8h, pt10h));

                listm1.add(new Triangle(pt9h, pt13h, pt12h));
                listm1.add(new Triangle(pt9h, pt11h, pt12h));

                listm1.add(new Triangle(ptxx1h, ptxx2h, pt14h));
                listm1.add(new Triangle(ptxx1h, pt10h, pt14h));

                listm1.add(new Triangle(pt11, pt11h, pt12h));
                listm1.add(new Triangle(pt11, pt12, pt12h));

                listm1.add(new Triangle(pt11, pt11h, pt10h));
                listm1.add(new Triangle(pt11, pt10, pt10h));

                listm1.add(new Triangle(ptxx1, ptxx1h, ptxx2h));
                listm1.add(new Triangle(ptxx1, ptxx2, ptxx2h));

                listm1.add(new Triangle(pt14, pt14h, pt12h));
                listm1.add(new Triangle(pt14, pt12, pt12h));

                if (accmur1.size() == 2) {
                    listm1.add(new Triangle(pt13, pm12h, pm12));
                    listm1.add(new Triangle(pt13, pt14, pm12));

                    listm1.add(new Triangle(pt13h, pm15h, pm15));
                    listm1.add(new Triangle(pt13h, pt14h, pm15));

                } else {

                    AccessoiresDTO ac3 = accmur1.get(2);
                    Vertex pt15 = new Vertex(ac3.position.x.toPixel() - 230, pm11h.y, z);

                    Vertex pt16 = new Vertex(ac3.position.x.toPixel() - 230, pm11.y, 0);

                    listm1.add(new Triangle(pt13, pt15, pt16));
                    listm1.add(new Triangle(pt13, pt14, pt16));

                    int x4 = Math.abs(806 / 3 - ac3.position.getY().toPixel());
                    int x5 = Math.abs(806 / 3 - ac3.position.getY().toPixel() - ac3.dimensions.getHauteur().toPixel());

                    Vertex pt17 = new Vertex(ac3.position.x.toPixel() - 230, pm11h.y, z1 - x4);
                    Vertex pt18 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm11h.y, z1 - x4);

                    Vertex pt19 = new Vertex(ac3.position.x.toPixel() - 230, pm11h.y, z1 - x5);
                    Vertex pt20 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm11h.y, z1 - x5);

                    Vertex pt21 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm11h.y, z1);
                    Vertex pt22 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm11h.y, 0);

                    listm1.add(new Triangle(pt15, pt21, pt18));
                    listm1.add(new Triangle(pt15, pt17, pt18));

                    listm1.add(new Triangle(pt19, pt20, pt22));
                    listm1.add(new Triangle(pt19, pt16, pt22));

                    listm1.add(new Triangle(pt21, pm12h, pm12));
                    listm1.add(new Triangle(pt21, pt22, pm12));

                    Vertex pt15h = new Vertex(ac3.position.x.toPixel() - 230, pm16h.y, z);

                    Vertex pt16h = new Vertex(ac3.position.x.toPixel() - 230, pm16.y, 0);

                    Vertex pt17h = new Vertex(ac3.position.x.toPixel() - 230, pm16h.y, z1 - x4);
                    Vertex pt18h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm16h.y, z1 - x4);

                    Vertex pt19h = new Vertex(ac3.position.x.toPixel() - 230, pm16h.y, z1 - x5);
                    Vertex pt20h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm16h.y, z1 - x5);

                    Vertex pt21h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm16h.y, z1);
                    Vertex pt22h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm16h.y, 0);

                    listm1.add(new Triangle(pt13h, pt15h, pt16h));
                    listm1.add(new Triangle(pt13h, pt14h, pt16h));

                    listm1.add(new Triangle(pt15h, pt21h, pt18h));
                    listm1.add(new Triangle(pt15h, pt17h, pt18h));

                    listm1.add(new Triangle(pt19h, pt20h, pt22h));
                    listm1.add(new Triangle(pt19h, pt16h, pt22h));

                    listm1.add(new Triangle(pt21h, pm15h, pm15));
                    listm1.add(new Triangle(pt21h, pt22h, pm15));

                    listm1.add(new Triangle(pt17, pt18, pt18h));
                    listm1.add(new Triangle(pt17, pt17h, pt18h));

                    listm1.add(new Triangle(pt20, pt18, pt18h));
                    listm1.add(new Triangle(pt20, pt20h, pt18h));

                    listm1.add(new Triangle(pt20, pt19, pt19h));
                    listm1.add(new Triangle(pt20, pt20h, pt19h));

                    listm1.add(new Triangle(pt17, pt19, pt19h));
                    listm1.add(new Triangle(pt17, pt17h, pt19h));

                }
            }
        }

        //mur 3 drawing
        Vertex pm31 = mur3.get(0);
        Vertex pm32 = mur3.get(1);
        Vertex pm33 = mur3.get(2);
        Vertex pm34 = mur3.get(3);
        Vertex pm35 = mur3.get(4);
        Vertex pm36 = mur3.get(5);
        Vertex pm37 = mur3.get(6);
        Vertex pm38 = mur3.get(7);

        Vertex pm31h = mur3h.get(0);
        Vertex pm32h = mur3h.get(1);
        Vertex pm33h = mur3h.get(2);
        Vertex pm34h = mur3h.get(3);
        Vertex pm35h = mur3h.get(4);
        Vertex pm36h = mur3h.get(5);
        Vertex pm37h = mur3h.get(6);
        Vertex pm38h = mur3h.get(7);

        listm3.add(new Triangle(pm31, pm32, pm33));
        listm3.add(new Triangle(pm31, pm33, pm34));

        listm3.add(new Triangle(pm35, pm36, pm37));
        listm3.add(new Triangle(pm35, pm37, pm38));

        listm3.add(new Triangle(pm31h, pm32h, pm33h));
        listm3.add(new Triangle(pm31h, pm33h, pm34h));

        listm3.add(new Triangle(pm35h, pm36h, pm37h));
        listm3.add(new Triangle(pm35h, pm37h, pm38h));

        listm3.add(new Triangle(pm31, pm31h, pm32));
        listm3.add(new Triangle(pm31h, pm32h, pm32));

        listm3.add(new Triangle(pm33, pm33h, pm34));
        listm3.add(new Triangle(pm33h, pm34h, pm34));

        listm3.add(new Triangle(pm34, pm34h, pm35));
        listm3.add(new Triangle(pm34h, pm35h, pm35));

        listm3.add(new Triangle(pm35, pm35h, pm36));
        listm3.add(new Triangle(pm35h, pm36h, pm36));

        listm3.add(new Triangle(pm37, pm37h, pm38));
        listm3.add(new Triangle(pm37h, pm38h, pm38));

        listm3.add(new Triangle(pm38, pm38h, pm31));
        listm3.add(new Triangle(pm38h, pm31h, pm31));

        // mur 3 accs drawing 
        if (accmur3.isEmpty()) {

            listm3.add(new Triangle(pm32, pm32h, pm33));
            listm3.add(new Triangle(pm32h, pm33h, pm33));

            listm3.add(new Triangle(pm36, pm36h, pm37));
            listm3.add(new Triangle(pm36h, pm37h, pm37));

        }
        if (!accmur3.isEmpty()) {

            AccessoiresDTO ac1 = accmur3.get(0);
            Vertex pt1 = new Vertex(ac1.position.x.toPixel() - 230, pm33h.y, z);

            Vertex pt2 = new Vertex(ac1.position.x.toPixel() - 230, pm33.y, 0);

            Vertex pt1h = new Vertex(ac1.position.x.toPixel() - 230, pm36h.y, z);

            Vertex pt2h = new Vertex(ac1.position.x.toPixel() - 230, pm36h.y, 0);

            listm3.add(new Triangle(pm33h, pt1, pt2));
            listm3.add(new Triangle(pm33h, pm33, pt2));
            listm3.add(new Triangle(pm36h, pt1h, pt2h));
            listm3.add(new Triangle(pm36h, pm36, pt2h));

            System.out.println(z);

            int z1 = controller.getDimensions().getHauteur().toPixel();

            int x1 = Math.abs(806 / 3 - ac1.position.getY().toPixel());
            int x = Math.abs(806 / 3 - ac1.position.getY().toPixel() - ac1.dimensions.getHauteur().toPixel());

            if (x < x1) {

                int temp = x;
                x = x1;
                x1 = temp;
            }

            System.out.println("y1=" + (z1 - x1));
            System.out.println("y2=" + (z1 - x));

            Vertex pt3 = new Vertex(ac1.position.x.toPixel() - 230, pm33h.y, z1 - x1);

            Vertex pt4 = new Vertex(ac1.position.x.toPixel() - 230, pm33.y, z1 - x);

            Vertex pt5 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm33h.y, z1 - x1);

            Vertex pt6 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm33.y, z1 - x);

            Vertex pt7 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm33h.y, z);

            Vertex pt8 = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm33.y, 0);

            Vertex pt3h = new Vertex(ac1.position.x.toPixel() - 230, pm36h.y, z1 - x1);

            Vertex pt4h = new Vertex(ac1.position.x.toPixel() - 230, pm36.y, z1 - x);

            Vertex pt5h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm36h.y, z1 - x1);

            Vertex pt6h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm36.y, z1 - x);

            Vertex pt7h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm36h.y, z);

            Vertex pt8h = new Vertex(ac1.position.x.toPixel() - 230 + ac1.dimensions.getLongueur().toPixel(), pm36.y, 0);

            listm3.add(new Triangle(pt1, pt7, pt5));
            listm3.add(new Triangle(pt1, pt3, pt5));

            listm3.add(new Triangle(pt4, pt6, pt8));
            listm3.add(new Triangle(pt4, pt2, pt8));

            listm3.add(new Triangle(pt1h, pt7h, pt5h));
            listm3.add(new Triangle(pt1h, pt3h, pt5h));

            listm3.add(new Triangle(pt4h, pt6h, pt8h));
            listm3.add(new Triangle(pt4h, pt2h, pt8h));

            listm3.add(new Triangle(pt3, pt3h, pt4h));
            listm3.add(new Triangle(pt3, pt4, pt4h));

            listm3.add(new Triangle(pt3, pt3h, pt5h));
            listm3.add(new Triangle(pt3, pt5, pt5h));

            listm3.add(new Triangle(pt5, pt5h, pt6h));
            listm3.add(new Triangle(pt5, pt6, pt6h));

            listm3.add(new Triangle(pt6, pt6h, pt4h));
            listm3.add(new Triangle(pt6, pt4, pt4h));

            if (accmur3.size() == 1) {
                listm3.add(new Triangle(pt7, pm32h, pm32));
                listm3.add(new Triangle(pt7, pt8, pm32));

                listm3.add(new Triangle(pt7h, pm37h, pm37));
                listm3.add(new Triangle(pt7h, pt8h, pm37));

            } else {

                AccessoiresDTO ac2 = accmur3.get(1);

                Vertex pt9 = new Vertex(ac2.position.x.toPixel() - 230, pm33h.y, z);

                Vertex pt10 = new Vertex(ac2.position.x.toPixel() - 230, pm33.y, 0);

                listm3.add(new Triangle(pt7, pt9, pt10));
                listm3.add(new Triangle(pt7, pt8, pt10));

                int x3 = Math.abs(806 / 3 - ac2.position.getY().toPixel());
                int xx = Math.abs(806 / 3 - ac2.position.getY().toPixel() - ac2.dimensions.getHauteur().toPixel());
                System.out.println("y3=" + (z1 - x3));

                Vertex pt11 = new Vertex(ac2.position.x.toPixel() - 230, pm33.y, z1 - x3);
                Vertex pt12 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm33.y, z1 - x3);
                Vertex pt13 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm33.y, z);
                Vertex ptxx1 = new Vertex(ac2.position.x.toPixel() - 230, pm33.y, z1 - xx);
                Vertex ptxx2 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm33.y, z1 - xx);
                Vertex pt14 = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm33.y, 0);
                listm3.add(new Triangle(pt9, pt13, pt12));
                listm3.add(new Triangle(pt9, pt11, pt12));

                listm3.add(new Triangle(ptxx1, ptxx2, pt14));
                listm3.add(new Triangle(ptxx1, pt10, pt14));

                Vertex pt9h = new Vertex(ac2.position.x.toPixel() - 230, pm36h.y, z);
                Vertex pt10h = new Vertex(ac2.position.x.toPixel() - 230, pm36.y, 0);
                Vertex pt11h = new Vertex(ac2.position.x.toPixel() - 230, pm36.y, z1 - x3);
                Vertex pt12h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm36.y, z1 - x3);
                Vertex pt13h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm36.y, z);
                Vertex ptxx1h = new Vertex(ac2.position.x.toPixel() - 230, pm36.y, z1 - xx);
                Vertex ptxx2h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm36.y, z1 - xx);
                Vertex pt14h = new Vertex(ac2.position.x.toPixel() - 230 + ac2.dimensions.getLongueur().toPixel(), pm36.y, 0);

                listm3.add(new Triangle(pt7h, pt9h, pt10h));
                listm3.add(new Triangle(pt7h, pt8h, pt10h));

                listm3.add(new Triangle(pt9h, pt13h, pt12h));
                listm3.add(new Triangle(pt9h, pt11h, pt12h));

                listm3.add(new Triangle(ptxx1h, ptxx2h, pt14h));
                listm3.add(new Triangle(ptxx1h, pt10h, pt14h));

                listm3.add(new Triangle(pt11, pt11h, pt12h));
                listm3.add(new Triangle(pt11, pt12, pt12h));

                listm3.add(new Triangle(pt11, pt11h, pt10h));
                listm3.add(new Triangle(pt11, pt10, pt10h));

                listm3.add(new Triangle(ptxx1, ptxx1h, ptxx2h));
                listm3.add(new Triangle(ptxx1, ptxx2, ptxx2h));

                listm3.add(new Triangle(pt14, pt14h, pt12h));
                listm3.add(new Triangle(pt14, pt12, pt12h));

                if (accmur3.size() == 2) {
                    listm3.add(new Triangle(pt13, pm32h, pm32));
                    listm3.add(new Triangle(pt13, pt14, pm32));

                    listm3.add(new Triangle(pt13h, pm37h, pm37));
                    listm3.add(new Triangle(pt13h, pt14h, pm37));

                } else {

                    AccessoiresDTO ac3 = accmur3.get(2);
                    Vertex pt15 = new Vertex(ac3.position.x.toPixel() - 230, pm33h.y, z);

                    Vertex pt16 = new Vertex(ac3.position.x.toPixel() - 230, pm33.y, 0);

                    listm3.add(new Triangle(pt13, pt15, pt16));
                    listm3.add(new Triangle(pt13, pt14, pt16));

                    int x4 = Math.abs(806 / 3 - ac3.position.getY().toPixel());
                    int x5 = Math.abs(806 / 3 - ac3.position.getY().toPixel() - ac3.dimensions.getHauteur().toPixel());

                    Vertex pt17 = new Vertex(ac3.position.x.toPixel() - 230, pm33h.y, z1 - x4);
                    Vertex pt18 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm33h.y, z1 - x4);

                    Vertex pt19 = new Vertex(ac3.position.x.toPixel() - 230, pm33h.y, z1 - x5);
                    Vertex pt20 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm33h.y, z1 - x5);

                    Vertex pt21 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm33h.y, z1);
                    Vertex pt22 = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm33h.y, 0);

                    listm3.add(new Triangle(pt15, pt21, pt18));
                    listm3.add(new Triangle(pt15, pt17, pt18));

                    listm3.add(new Triangle(pt19, pt20, pt22));
                    listm3.add(new Triangle(pt19, pt16, pt22));

                    listm3.add(new Triangle(pt21, pm32h, pm32));
                    listm3.add(new Triangle(pt21, pt22, pm32));

                    Vertex pt15h = new Vertex(ac3.position.x.toPixel() - 230, pm36h.y, z);

                    Vertex pt16h = new Vertex(ac3.position.x.toPixel() - 230, pm36.y, 0);

                    Vertex pt17h = new Vertex(ac3.position.x.toPixel() - 230, pm36h.y, z1 - x4);
                    Vertex pt18h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm36h.y, z1 - x4);

                    Vertex pt19h = new Vertex(ac3.position.x.toPixel() - 230, pm36h.y, z1 - x5);
                    Vertex pt20h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm36h.y, z1 - x5);

                    Vertex pt21h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm36h.y, z1);
                    Vertex pt22h = new Vertex(ac3.position.x.toPixel() - 230 + ac3.dimensions.getLongueur().toPixel(), pm36h.y, 0);

                    listm3.add(new Triangle(pt13h, pt15h, pt16h));
                    listm3.add(new Triangle(pt13h, pt14h, pt16h));

                    listm3.add(new Triangle(pt15h, pt21h, pt18h));
                    listm3.add(new Triangle(pt15h, pt17h, pt18h));

                    listm3.add(new Triangle(pt19h, pt20h, pt22h));
                    listm3.add(new Triangle(pt19h, pt16h, pt22h));

                    listm3.add(new Triangle(pt21h, pm37h, pm37));
                    listm3.add(new Triangle(pt21h, pt22h, pm37));

                    listm3.add(new Triangle(pt17, pt18, pt18h));
                    listm3.add(new Triangle(pt17, pt17h, pt18h));

                    listm3.add(new Triangle(pt20, pt18, pt18h));
                    listm3.add(new Triangle(pt20, pt20h, pt18h));

                    listm3.add(new Triangle(pt20, pt19, pt19h));
                    listm3.add(new Triangle(pt20, pt20h, pt19h));

                    listm3.add(new Triangle(pt17, pt19, pt19h));
                    listm3.add(new Triangle(pt17, pt17h, pt19h));

                }
            }
        }

        //mur 2 drawing
        Vertex pm21 = mur2.get(0);
        Vertex pm22 = mur2.get(1);
        Vertex pm23 = mur2.get(2);
        Vertex pm24 = mur2.get(3);
        Vertex pm25 = mur2.get(4);
        Vertex pm26 = mur2.get(5);
        Vertex pm27 = mur2.get(6);
        Vertex pm28 = mur2.get(7);

        Vertex pm21h = mur2h.get(0);
        Vertex pm22h = mur2h.get(1);
        Vertex pm23h = mur2h.get(2);
        Vertex pm24h = mur2h.get(3);
        Vertex pm25h = mur2h.get(4);
        Vertex pm26h = mur2h.get(5);
        Vertex pm27h = mur2h.get(6);
        Vertex pm28h = mur2h.get(7);

        listm2.add(new Triangle(pm21, pm22, pm27));
        listm2.add(new Triangle(pm21, pm27, pm28));

        listm2.add(new Triangle(pm23, pm24, pm25));
        listm2.add(new Triangle(pm23, pm25, pm26));

        listm2.add(new Triangle(pm21h, pm22h, pm27h));
        listm2.add(new Triangle(pm21h, pm27h, pm28h));

        listm2.add(new Triangle(pm23h, pm24h, pm25h));
        listm2.add(new Triangle(pm23h, pm25h, pm26h));

        listm2.add(new Triangle(pm21, pm21h, pm22));
        listm2.add(new Triangle(pm21h, pm22h, pm22));

        listm2.add(new Triangle(pm22, pm22h, pm23));
        listm2.add(new Triangle(pm22h, pm23h, pm23));

        listm2.add(new Triangle(pm23, pm23h, pm24));
        listm2.add(new Triangle(pm23h, pm24h, pm24));

        listm2.add(new Triangle(pm25, pm25h, pm26));
        listm2.add(new Triangle(pm25h, pm26h, pm26));

        listm2.add(new Triangle(pm26, pm26h, pm27));
        listm2.add(new Triangle(pm26h, pm27h, pm27));

        listm2.add(new Triangle(pm27, pm27h, pm28));
        listm2.add(new Triangle(pm27h, pm28h, pm28));

        // mur 2 accs drawing 
        if (accmur2.isEmpty()) {

            listm2.add(new Triangle(pm21h, pm28h, pm28));
            listm2.add(new Triangle(pm21h, pm21, pm28));
            listm2.add(new Triangle(pm25, pm25h, pm24));
            listm2.add(new Triangle(pm25h, pm24h, pm24));

        }

        if (!accmur2.isEmpty()) {
            AccessoiresDTO ac1 = accmur2.get(0);

            double distt = Math.abs(1344 / 4 - ac1.position.x.toPixel() ) - 50;
            double distt1 = distt + ac1.dimensions.getLongueur().toPixel();

            double dst = Math.abs(806 / 3 - ac1.position.y.toPixel());

            double dst1 = dst + ac1.dimensions.getHauteur().toPixel();

            Vertex pt1 = new Vertex(pm21h.x, pm21.y + distt, z);

            Vertex pt2 = new Vertex(pm21h.x, pm21.y + distt, 0);

            Vertex pt3 = new Vertex(pm21h.x, pm21.y + distt1, z);

            Vertex pt4 = new Vertex(pm21h.x, pm21.y + distt1, 0);

            Vertex pt5 = new Vertex(pm21h.x, pm21.y + distt, z - dst);
            Vertex pt6 = new Vertex(pm21h.x, pm21.y + distt, z - dst1);

            Vertex pt7 = new Vertex(pm21h.x, pm21.y + distt1, z - dst);
            Vertex pt8 = new Vertex(pm21h.x, pm21.y + distt1, z - dst1);

            Vertex pt1h = new Vertex(pm24h.x, pm21.y + distt, z);

            Vertex pt2h = new Vertex(pm24h.x, pm21.y + distt, 0);

            Vertex pt3h = new Vertex(pm24h.x, pm21.y + distt1, z);

            Vertex pt4h = new Vertex(pm24h.x, pm21.y + distt1, 0);

            Vertex pt5h = new Vertex(pm24h.x, pm21.y + distt, z - dst);
            Vertex pt6h = new Vertex(pm24h.x, pm21.y + distt, z - dst1);

            Vertex pt7h = new Vertex(pm24h.x, pm21.y + distt1, z - dst);
            Vertex pt8h = new Vertex(pm24h.x, pm21.y + distt1, z - dst1);

            listm2.add(new Triangle(pm21h, pt1, pt2));
            listm2.add(new Triangle(pm21h, pm21, pt2));

            listm2.add(new Triangle(pt1, pt3, pt7));
            listm2.add(new Triangle(pt1, pt5, pt7));

            listm2.add(new Triangle(pt6, pt8, pt4));
            listm2.add(new Triangle(pt6, pt2, pt4));

            listm2.add(new Triangle(pm24h, pt1h, pt2h));
            listm2.add(new Triangle(pm24h, pm24, pt2h));

            listm2.add(new Triangle(pt1h, pt3h, pt7h));
            listm2.add(new Triangle(pt1h, pt5h, pt7h));

            listm2.add(new Triangle(pt6h, pt8h, pt4h));
            listm2.add(new Triangle(pt6h, pt2h, pt4h));

            listm2.add(new Triangle(pt5, pt7, pt7h));
            listm2.add(new Triangle(pt5, pt5h, pt7h));

            listm2.add(new Triangle(pt8, pt7, pt7h));
            listm2.add(new Triangle(pt8, pt8h, pt7h));

            listm2.add(new Triangle(pt8, pt6, pt6h));
            listm2.add(new Triangle(pt8, pt8h, pt6h));

            listm2.add(new Triangle(pt5, pt6, pt6h));
            listm2.add(new Triangle(pt5, pt5h, pt6h));

            if (accmur2.size() == 1) {
                listm2.add(new Triangle(pt3, pm28h, pm28));
                listm2.add(new Triangle(pt3, pt4, pm28));

                listm2.add(new Triangle(pt3h, pm25h, pm25));
                listm2.add(new Triangle(pt3h, pt4h, pm25));

            } else {

                AccessoiresDTO ac2 = accmur2.get(1);

                double dist3 = ac2.position.x.toPixel() - ac1.position.x.toPixel() - ac1.dimensions.getLongueur().toPixel() - 25;

                Vertex pt10 = new Vertex(pm21h.x, pt3.y + dist3, z);

                Vertex pt11 = new Vertex(pm21h.x, pt3.y + dist3, 0);

                Vertex pt10h = new Vertex(pm24h.x, pt3.y + dist3, z);

                Vertex pt11h = new Vertex(pm24h.x, pt3.y + dist3, 0);

                int x3 = Math.abs(806 / 3 - ac2.position.getY().toPixel()) - 50;
                int x4 = Math.abs(806 / 3 - ac2.position.getY().toPixel() - ac2.dimensions.getHauteur().toPixel()) - 50;

                Vertex pt12 = new Vertex(pm21h.x, pt3.y + dist3, z - x3);

                Vertex pt13 = new Vertex(pm21h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x3);

                Vertex pt14 = new Vertex(pm21h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z);

                Vertex pt12h = new Vertex(pm24h.x, pt3.y + dist3, z - x3);

                Vertex pt13h = new Vertex(pm24h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x3);

                Vertex pt14h = new Vertex(pm24h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z);

                listm2.add(new Triangle(pt3, pt10, pt11));
                listm2.add(new Triangle(pt3, pt4, pt11));

                listm2.add(new Triangle(pt10, pt14, pt13));
                listm2.add(new Triangle(pt10, pt12, pt13));

                listm2.add(new Triangle(pt3h, pt10h, pt11h));
                listm2.add(new Triangle(pt3h, pt4h, pt11h));

                listm2.add(new Triangle(pt10h, pt14h, pt13h));
                listm2.add(new Triangle(pt10h, pt12h, pt13h));

                Vertex pt15 = new Vertex(pm21h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), 0);

                Vertex pt16 = new Vertex(pm21h.x, pt3.y + dist3, z - x4);

                Vertex pt17 = new Vertex(pm21h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x4);

                Vertex pt15h = new Vertex(pm24h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), 0);

                Vertex pt16h = new Vertex(pm24h.x, pt3.y + dist3, z - x4);

                Vertex pt17h = new Vertex(pm24h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x4);

                listm2.add(new Triangle(pt16, pt17, pt15));
                listm2.add(new Triangle(pt16, pt11, pt15));

                listm2.add(new Triangle(pt14, pm28h, pm28));
                listm2.add(new Triangle(pt14, pt15, pm28));
                
                listm2.add(new Triangle(pt14h, pm25h, pm25));
                listm2.add(new Triangle(pt14h, pt15h, pm25));

                listm2.add(new Triangle(pt16h, pt17h, pt15h));
                listm2.add(new Triangle(pt16h, pt11h, pt15h));

                listm2.add(new Triangle(pt12, pt13, pt13h));
                listm2.add(new Triangle(pt12, pt12h, pt13h));
                
                listm2.add(new Triangle(pt17, pt13, pt13h));
                listm2.add(new Triangle(pt17, pt17h, pt13h));
                
                listm2.add(new Triangle(pt17, pt16, pt16h));
                listm2.add(new Triangle(pt17, pt17h, pt16h));
                
                listm2.add(new Triangle(pt12, pt16, pt16h));
                listm2.add(new Triangle(pt12, pt12h, pt16h));

            }
        }

        //mur 4 drawing
        Vertex pm41 = mur4.get(0);
        Vertex pm42 = mur4.get(1);
        Vertex pm43 = mur4.get(2);
        Vertex pm44 = mur4.get(3);
        Vertex pm45 = mur4.get(4);
        Vertex pm46 = mur4.get(5);
        Vertex pm47 = mur4.get(6);
        Vertex pm48 = mur4.get(7);

        Vertex pm41h = mur4h.get(0);
        Vertex pm42h = mur4h.get(1);
        Vertex pm43h = mur4h.get(2);
        Vertex pm44h = mur4h.get(3);
        Vertex pm45h = mur4h.get(4);
        Vertex pm46h = mur4h.get(5);
        Vertex pm47h = mur4h.get(6);
        Vertex pm48h = mur4h.get(7);

        listm4.add(new Triangle(pm41, pm42, pm43));
        listm4.add(new Triangle(pm41, pm43, pm48));

        listm4.add(new Triangle(pm44, pm45, pm46));
        listm4.add(new Triangle(pm44, pm47, pm46));

        listm4.add(new Triangle(pm41h, pm42h, pm43h));
        listm4.add(new Triangle(pm41h, pm43h, pm48h));

        listm4.add(new Triangle(pm44h, pm45h, pm46h));
        listm4.add(new Triangle(pm44h, pm47h, pm46h));

        listm4.add(new Triangle(pm42, pm42h, pm43));
        listm4.add(new Triangle(pm42h, pm43h, pm43));

        listm4.add(new Triangle(pm43, pm43h, pm44));
        listm4.add(new Triangle(pm43h, pm44h, pm44));

        listm4.add(new Triangle(pm44, pm44h, pm45));
        listm4.add(new Triangle(pm44h, pm45h, pm45));

        listm4.add(new Triangle(pm46, pm46h, pm47));
        listm4.add(new Triangle(pm46h, pm47h, pm47));

        listm4.add(new Triangle(pm47, pm47h, pm48));
        listm4.add(new Triangle(pm47h, pm48h, pm48));

        listm4.add(new Triangle(pm48, pm48h, pm41));
        listm4.add(new Triangle(pm48h, pm41h, pm41));

        // mur 4 accs drawing 
        if (accmur4.isEmpty()) {

            listm4.add(new Triangle(pm42h, pm41h, pm41));
            listm4.add(new Triangle(pm42h, pm42, pm41));
            
            listm4.add(new Triangle(pm45, pm45h, pm46));
            listm4.add(new Triangle(pm45h, pm46h, pm46));

        }

        if (!accmur4.isEmpty()) {
            AccessoiresDTO ac1 = accmur4.get(0);

            double distt = Math.abs(1344 / 4 - ac1.position.x.toPixel() ) - 50;
            double distt1 = distt + ac1.dimensions.getLongueur().toPixel();

            double dst = Math.abs(806 / 3 - ac1.position.y.toPixel());

            double dst1 = dst + ac1.dimensions.getHauteur().toPixel();

            Vertex pt1 = new Vertex(pm42h.x, pm42.y + distt, z);

            Vertex pt2 = new Vertex(pm42h.x, pm42.y + distt, 0);

            Vertex pt3 = new Vertex(pm42h.x, pm42.y + distt1, z);

            Vertex pt4 = new Vertex(pm42h.x, pm42.y + distt1, 0);

            Vertex pt5 = new Vertex(pm42h.x, pm42.y + distt, z - dst);
            Vertex pt6 = new Vertex(pm42h.x, pm42.y + distt, z - dst1);

            Vertex pt7 = new Vertex(pm42h.x, pm42.y + distt1, z - dst);
            Vertex pt8 = new Vertex(pm42h.x, pm42.y + distt1, z - dst1);

            Vertex pt1h = new Vertex(pm45h.x, pm42.y + distt, z);

            Vertex pt2h = new Vertex(pm45h.x, pm42.y + distt, 0);

            Vertex pt3h = new Vertex(pm45h.x, pm42.y + distt1, z);

            Vertex pt4h = new Vertex(pm45h.x, pm42.y + distt1, 0);

            Vertex pt5h = new Vertex(pm45h.x, pm42.y + distt, z - dst);
            Vertex pt6h = new Vertex(pm45h.x, pm42.y + distt, z - dst1);

            Vertex pt7h = new Vertex(pm45h.x, pm42.y + distt1, z - dst);
            Vertex pt8h = new Vertex(pm45h.x, pm42.y + distt1, z - dst1);

            listm4.add(new Triangle(pm42h, pt1, pt2));
            listm4.add(new Triangle(pm42h, pm42, pt2));

            listm4.add(new Triangle(pt1, pt3, pt7));
            listm4.add(new Triangle(pt1, pt5, pt7));

            listm4.add(new Triangle(pt6, pt8, pt4));
            listm4.add(new Triangle(pt6, pt2, pt4));

            listm4.add(new Triangle(pm45h, pt1h, pt2h));
            listm4.add(new Triangle(pm45h, pm45, pt2h));

            listm4.add(new Triangle(pt1h, pt3h, pt7h));
            listm4.add(new Triangle(pt1h, pt5h, pt7h));

            listm4.add(new Triangle(pt6h, pt8h, pt4h));
            listm4.add(new Triangle(pt6h, pt2h, pt4h));

            listm4.add(new Triangle(pt5, pt7, pt7h));
            listm4.add(new Triangle(pt5, pt5h, pt7h));

            listm4.add(new Triangle(pt8, pt7, pt7h));
            listm4.add(new Triangle(pt8, pt8h, pt7h));

            listm4.add(new Triangle(pt8, pt6, pt6h));
            listm4.add(new Triangle(pt8, pt8h, pt6h));

            listm4.add(new Triangle(pt5, pt6, pt6h));
            listm4.add(new Triangle(pt5, pt5h, pt6h));

            if (accmur4.size() == 1) {
                listm4.add(new Triangle(pt3, pm41h, pm41));
                listm4.add(new Triangle(pt3, pt4, pm41));

                listm4.add(new Triangle(pt3h, pm46h, pm46));
                listm4.add(new Triangle(pt3h, pt4h, pm46));

            } else {

                AccessoiresDTO ac2 = accmur4.get(1);

                double dist3 = ac2.position.x.toPixel() - ac1.position.x.toPixel() - ac1.dimensions.getLongueur().toPixel() - 25;

                Vertex pt10 = new Vertex(pm42h.x, pt3.y + dist3, z);

                Vertex pt11 = new Vertex(pm42h.x, pt3.y + dist3, 0);

                Vertex pt10h = new Vertex(pm45h.x, pt3.y + dist3, z);

                Vertex pt11h = new Vertex(pm45h.x, pt3.y + dist3, 0);

                int x3 = Math.abs(806 / 3 - ac2.position.getY().toPixel()) - 50;
                int x4 = Math.abs(806 / 3 - ac2.position.getY().toPixel() - ac2.dimensions.getHauteur().toPixel()) - 50;

                Vertex pt12 = new Vertex(pm42h.x, pt3.y + dist3, z - x3);

                Vertex pt13 = new Vertex(pm42h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x3);

                Vertex pt14 = new Vertex(pm42h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z);

                Vertex pt12h = new Vertex(pm45h.x, pt3.y + dist3, z - x3);

                Vertex pt13h = new Vertex(pm45h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x3);

                Vertex pt14h = new Vertex(pm45h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z);

                listm4.add(new Triangle(pt3, pt10, pt11));
                listm4.add(new Triangle(pt3, pt4, pt11));

                listm4.add(new Triangle(pt10, pt14, pt13));
                listm4.add(new Triangle(pt10, pt12, pt13));

                listm4.add(new Triangle(pt3h, pt10h, pt11h));
                listm4.add(new Triangle(pt3h, pt4h, pt11h));

                listm4.add(new Triangle(pt10h, pt14h, pt13h));
                listm4.add(new Triangle(pt10h, pt12h, pt13h));

                Vertex pt15 = new Vertex(pm42.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), 0);

                Vertex pt16 = new Vertex(pm42.x, pt3.y + dist3, z - x4);

                Vertex pt17 = new Vertex(pm42h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x4);

                Vertex pt15h = new Vertex(pm45h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), 0);

                Vertex pt16h = new Vertex(pm45h.x, pt3.y + dist3, z - x4);

                Vertex pt17h = new Vertex(pm45h.x, pt10.y + ac2.dimensions.getLongueur().toPixel(), z - x4);

                listm4.add(new Triangle(pt16, pt17, pt15));
                listm4.add(new Triangle(pt16, pt11, pt15));

                listm4.add(new Triangle(pt14, pm41h, pm41));
                listm4.add(new Triangle(pt14, pt15, pm41));
                
                listm4.add(new Triangle(pt14h, pm46h, pm46));
                listm4.add(new Triangle(pt14h, pt15h, pm46));

                listm4.add(new Triangle(pt16h, pt17h, pt15h));
                listm4.add(new Triangle(pt16h, pt11h, pt15h));

                listm4.add(new Triangle(pt12, pt13, pt13h));
                listm4.add(new Triangle(pt12, pt12h, pt13h));
                
                listm4.add(new Triangle(pt17, pt13, pt13h));
                listm4.add(new Triangle(pt17, pt17h, pt13h));
                
                listm4.add(new Triangle(pt17, pt16, pt16h));
                listm4.add(new Triangle(pt17, pt17h, pt16h));
                
                listm4.add(new Triangle(pt12, pt16, pt16h));
                listm4.add(new Triangle(pt12, pt12h, pt16h));

            }
        }

    }

    
    public void exporterRallongeToit(Controleur c, List<Vertex> list, List<Triangle> list1) {
        Imperial distancesupp_2 = c.getDistanceSupp().division();
        Imperial longueur = c.getDimensions().getLongueur();
        Imperial profondeur = c.getDimensions().getProfondeur();
        Imperial epaisseur_2 = c.getEpaisseur().division();
        Imperial epaisseur = c.getEpaisseur();
        int hauteur = c.getDimensions().getHauteur().toPixel();
        List<Vertex> vertexList = new ArrayList<>();
        if (c.getSensToit() == SensToit.Arriere_facade){
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
            Vertex v1 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt11.getX().toPixel(), pt11.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt13.getX().toPixel(), pt13.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt14.getX().toPixel(), pt14.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt16.getX().toPixel(), pt16.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v10 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v11 = new Vertex(pt11.getX().toPixel(), pt11.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v13 = new Vertex(pt13.getX().toPixel(), pt13.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v14 = new Vertex(pt14.getX().toPixel(), pt14.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v15 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt16.getX().toPixel(), pt16.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v5, v6, v14));
            list1.add(new Triangle(v5, v13, v14));
            
            list1.add(new Triangle(v3, v8, v16));
            list1.add(new Triangle(v3, v11, v16));
            
            list1.add(new Triangle(v1, v2, v10));
            list1.add(new Triangle(v1, v9, v10));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v9, v16, v11));
            
            list1.add(new Triangle(v1, v16, v9));
            list1.add(new Triangle(v1, v8, v16));
            
            list1.add(new Triangle(v6, v7, v15));
            list1.add(new Triangle(v6, v14, v15));
            
            list1.add(new Triangle(v2, v3, v10));
            list1.add(new Triangle(v10, v3, v11));
            
            list1.add(new Triangle(v4, v5, v13));
            list1.add(new Triangle(v4, v12, v13));
            
            list1.add(new Triangle(v14, v15, v12));
            list1.add(new Triangle(v14, v12, v13));

        }
        
        if (c.getSensToit() == SensToit.Facade_arriere){
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
            Vertex v1 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt3.getX().toPixel(), pt3.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt4.getX().toPixel(), pt4.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt5.getX().toPixel(), pt5.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt6.getX().toPixel(), pt6.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt7.getX().toPixel(), pt7.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt8.getX().toPixel(), pt8.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v10 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v11 = new Vertex(pt3.getX().toPixel(), pt3.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt4.getX().toPixel(), pt4.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v13 = new Vertex(pt5.getX().toPixel(), pt5.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v14 = new Vertex(pt6.getX().toPixel(), pt6.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v15 = new Vertex(pt7.getX().toPixel(), pt7.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt8.getX().toPixel(), pt8.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v5, v6, v14));
            list1.add(new Triangle(v5, v13, v14));
            
            list1.add(new Triangle(v3, v8, v16));
            list1.add(new Triangle(v3, v11, v16));
            
            list1.add(new Triangle(v1, v2, v10));
            list1.add(new Triangle(v1, v9, v10));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v9, v16, v11));
            
            list1.add(new Triangle(v1, v16, v9));
            list1.add(new Triangle(v1, v8, v16));
            
            list1.add(new Triangle(v6, v7, v15));
            list1.add(new Triangle(v6, v14, v15));
            
            list1.add(new Triangle(v2, v3, v10));
            list1.add(new Triangle(v10, v3, v11));
            
            list1.add(new Triangle(v4, v5, v13));
            list1.add(new Triangle(v4, v12, v13));
            
            list1.add(new Triangle(v14, v15, v12));
            list1.add(new Triangle(v14, v12, v13));
        }
        
        if (c.getSensToit() == SensToit.Droite_gauche){
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
            Vertex v1 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt27.getX().toPixel(), pt27.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt29.getX().toPixel(), pt29.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt30.getX().toPixel(), pt30.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt32.getX().toPixel(), pt32.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v10 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v11 = new Vertex(pt27.getX().toPixel(), pt27.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v13 = new Vertex(pt29.getX().toPixel(), pt29.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v14 = new Vertex(pt30.getX().toPixel(), pt30.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v15 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt32.getX().toPixel(), pt32.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v5, v6, v14));
            list1.add(new Triangle(v5, v13, v14));
            
            list1.add(new Triangle(v3, v8, v16));
            list1.add(new Triangle(v3, v11, v16));
            
            list1.add(new Triangle(v1, v2, v10));
            list1.add(new Triangle(v1, v9, v10));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v9, v16, v11));
            
            list1.add(new Triangle(v1, v16, v9));
            list1.add(new Triangle(v1, v8, v16));
            
            list1.add(new Triangle(v6, v7, v15));
            list1.add(new Triangle(v6, v14, v15));
            
            list1.add(new Triangle(v2, v3, v10));
            list1.add(new Triangle(v10, v3, v11));
            
            list1.add(new Triangle(v4, v5, v13));
            list1.add(new Triangle(v4, v12, v13));
            
            list1.add(new Triangle(v14, v15, v12));
            list1.add(new Triangle(v14, v12, v13));
        }
        if((c.getSensToit() == SensToit.Gauche_droite)){
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
            Vertex v1 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt19.getX().toPixel(), pt19.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt20.getX().toPixel(), pt20.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt21.getX().toPixel(), pt21.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt22.getX().toPixel(), pt22.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt23.getX().toPixel(), pt23.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt24.getX().toPixel(), pt24.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v10 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v11 = new Vertex(pt19.getX().toPixel(), pt19.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt20.getX().toPixel(), pt20.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v13 = new Vertex(pt21.getX().toPixel(), pt21.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v14 = new Vertex(pt22.getX().toPixel(), pt22.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v15 = new Vertex(pt23.getX().toPixel(), pt23.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt24.getX().toPixel(), pt24.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + distancesupp_2.toPixel())));
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v5, v6, v14));
            list1.add(new Triangle(v5, v13, v14));
            
            list1.add(new Triangle(v3, v8, v16));
            list1.add(new Triangle(v3, v11, v16));
            
            list1.add(new Triangle(v1, v2, v10));
            list1.add(new Triangle(v1, v9, v10));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v9, v16, v11));
            
            list1.add(new Triangle(v1, v16, v9));
            list1.add(new Triangle(v1, v8, v16));
            
            list1.add(new Triangle(v6, v7, v15));
            list1.add(new Triangle(v6, v14, v15));
            
            list1.add(new Triangle(v2, v3, v10));
            list1.add(new Triangle(v10, v3, v11));
            
            list1.add(new Triangle(v4, v5, v13));
            list1.add(new Triangle(v4, v12, v13));
            
            list1.add(new Triangle(v14, v15, v12));
            list1.add(new Triangle(v14, v12, v13));
        }
            
            
        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Fini_RallongeToit.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : list1) {
                out.println(tr.toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }
    
    }


    public void exporterPignon(Controleur c, List<Vertex> list, List<Triangle> list1) {
        Imperial distancesupp_2 = c.getDistanceSupp().division();
        Imperial longueur = c.getDimensions().getLongueur();
        Imperial profondeur = c.getDimensions().getProfondeur();
        Imperial epaisseur_2 = c.getEpaisseur().division();
        Imperial epaisseur = c.getEpaisseur();
        int hauteur = c.getDimensions().getHauteur().toPixel();
        List<Vertex> vertexList = new ArrayList<>();
        if (c.getSensToit() == SensToit.Arriere_facade){
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
            Vertex v1 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt19.getX().toPixel(), pt19.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt20.getX().toPixel(), pt20.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt21.getX().toPixel(), pt21.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt22.getX().toPixel(), pt22.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt23.getX().toPixel(), pt23.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt24.getX().toPixel(), pt24.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v10 = new Vertex(pt24.getX().toPixel(), pt24.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v11 = new Vertex(pt23.getX().toPixel(), pt23.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v12 = new Vertex(pt22.getX().toPixel(), pt22.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v2, v3, v9));
            list1.add(new Triangle(v3, v9, v10));
            
            list1.add(new Triangle(v4, v5, v11));
            list1.add(new Triangle(v5, v12, v11));
            
            list1.add(new Triangle(v5, v6, v12));
            list1.add(new Triangle(v3, v8, v10));

            list1.add(new Triangle(v1, v2, v9));
            
            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v8, v10));
            
            list1.add(new Triangle(v6, v7, v11));
            list1.add(new Triangle(v12, v11, v6));
            
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
            
            Vertex v13 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur);
            Vertex v14 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur);
            Vertex v15 = new Vertex(pt27.getX().toPixel(), pt27.getY().toPixel(), hauteur);
            Vertex v16 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur);
            Vertex v17 = new Vertex(pt29.getX().toPixel(), pt29.getY().toPixel(), hauteur);
            Vertex v18 = new Vertex(pt30.getX().toPixel(), pt30.getY().toPixel(), hauteur);
            Vertex v19 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur);
            Vertex v20 = new Vertex(pt32.getX().toPixel(), pt32.getY().toPixel(), hauteur);
            Vertex v21 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v22 = new Vertex(pt32.getX().toPixel(), pt32.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v23 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v24 = new Vertex(pt30.getX().toPixel(), pt30.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v13, v14, v15));
            list1.add(new Triangle(v13, v20, v15));
        
            list1.add(new Triangle(v16, v17, v18));
            list1.add(new Triangle(v16, v18, v19));
            
            list1.add(new Triangle(v14, v15, v21));
            list1.add(new Triangle(v15, v21, v22));
            
            list1.add(new Triangle(v16, v17, v24));
            list1.add(new Triangle(v16, v23, v24));
            
            list1.add(new Triangle(v17, v18, v24));
            list1.add(new Triangle(v15, v20, v22));

            list1.add(new Triangle(v13, v14, v21));
            
            list1.add(new Triangle(v13, v22, v21));
            list1.add(new Triangle(v13, v20, v22));
            
            list1.add(new Triangle(v18, v19, v23));
            list1.add(new Triangle(v24, v23, v18));

        }
        
        if (c.getSensToit() == SensToit.Facade_arriere){
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
            Vertex v1 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt19.getX().toPixel(), pt19.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt20.getX().toPixel(), pt20.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt21.getX().toPixel(), pt21.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt22.getX().toPixel(), pt22.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt23.getX().toPixel(), pt23.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt24.getX().toPixel(), pt24.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v10 = new Vertex(pt19.getX().toPixel(), pt19.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v11 = new Vertex(pt20.getX().toPixel(), pt20.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v12 = new Vertex(pt21.getX().toPixel(), pt21.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v2, v3, v9));
            list1.add(new Triangle(v3, v9, v10));
            
            list1.add(new Triangle(v4, v5, v11));
            list1.add(new Triangle(v5, v12, v11));
            
            list1.add(new Triangle(v5, v6, v12));
            list1.add(new Triangle(v3, v8, v10));

            list1.add(new Triangle(v1, v2, v9));
            
            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v8, v10));
            
            list1.add(new Triangle(v6, v7, v11));
            list1.add(new Triangle(v12, v11, v6));
            
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
            
            Vertex v13 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur);
            Vertex v14 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur);
            Vertex v15 = new Vertex(pt27.getX().toPixel(), pt27.getY().toPixel(), hauteur);
            Vertex v16 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur);
            Vertex v17 = new Vertex(pt29.getX().toPixel(), pt29.getY().toPixel(), hauteur);
            Vertex v18 = new Vertex(pt30.getX().toPixel(), pt30.getY().toPixel(), hauteur);
            Vertex v19 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur);
            Vertex v20 = new Vertex(pt32.getX().toPixel(), pt32.getY().toPixel(), hauteur);
            Vertex v21 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v22 = new Vertex(pt27.getX().toPixel(), pt27.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v23 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v24 = new Vertex(pt29.getX().toPixel(), pt29.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v13, v14, v15));
            list1.add(new Triangle(v13, v20, v15));
        
            list1.add(new Triangle(v16, v17, v18));
            list1.add(new Triangle(v16, v18, v19));
            
            list1.add(new Triangle(v14, v15, v21));
            list1.add(new Triangle(v15, v21, v22));
            
            list1.add(new Triangle(v16, v17, v24));
            list1.add(new Triangle(v16, v23, v24));
            
            list1.add(new Triangle(v17, v18, v24));
            list1.add(new Triangle(v15, v20, v22));

            list1.add(new Triangle(v13, v14, v21));
            
            list1.add(new Triangle(v13, v22, v21));
            list1.add(new Triangle(v13, v20, v22));
            
            list1.add(new Triangle(v18, v19, v23));
            list1.add(new Triangle(v24, v23, v18));

        }
        
        if (c.getSensToit() == SensToit.Gauche_droite){
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
            Vertex v1 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt3.getX().toPixel(), pt3.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt4.getX().toPixel(), pt4.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt5.getX().toPixel(), pt5.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt6.getX().toPixel(), pt6.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt7.getX().toPixel(), pt7.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt8.getX().toPixel(), pt8.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v10 = new Vertex(pt3.getX().toPixel(), pt3.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v11 = new Vertex(pt4.getX().toPixel(), pt4.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v12 = new Vertex(pt5.getX().toPixel(), pt5.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v2, v3, v9));
            list1.add(new Triangle(v3, v9, v10));
            
            list1.add(new Triangle(v4, v5, v11));
            list1.add(new Triangle(v5, v12, v11));
            
            list1.add(new Triangle(v5, v6, v12));
            list1.add(new Triangle(v3, v8, v10));

            list1.add(new Triangle(v1, v2, v9));
            
            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v8, v10));
            
            list1.add(new Triangle(v6, v7, v11));
            list1.add(new Triangle(v12, v11, v6));
            
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
            
            Vertex v13 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur);
            Vertex v14 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur);
            Vertex v15 = new Vertex(pt11.getX().toPixel(), pt11.getY().toPixel(), hauteur);
            Vertex v16 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur);
            Vertex v17 = new Vertex(pt13.getX().toPixel(), pt13.getY().toPixel(), hauteur);
            Vertex v18 = new Vertex(pt14.getX().toPixel(), pt14.getY().toPixel(), hauteur);
            Vertex v19 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur);
            Vertex v20 = new Vertex(pt16.getX().toPixel(), pt16.getY().toPixel(), hauteur);
            Vertex v21 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v22 = new Vertex(pt11.getX().toPixel(), pt11.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v23 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v24 = new Vertex(pt13.getX().toPixel(), pt13.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v13, v14, v15));
            list1.add(new Triangle(v13, v20, v15));
        
            list1.add(new Triangle(v16, v17, v18));
            list1.add(new Triangle(v16, v18, v19));
            
            list1.add(new Triangle(v14, v15, v21));
            list1.add(new Triangle(v15, v21, v22));
            
            list1.add(new Triangle(v16, v17, v24));
            list1.add(new Triangle(v16, v23, v24));
            
            list1.add(new Triangle(v17, v18, v24));
            list1.add(new Triangle(v15, v20, v22));

            list1.add(new Triangle(v13, v14, v21));
            
            list1.add(new Triangle(v13, v22, v21));
            list1.add(new Triangle(v13, v20, v22));
            
            list1.add(new Triangle(v18, v19, v23));
            list1.add(new Triangle(v24, v23, v18));

        }
        
        if (c.getSensToit() == SensToit.Droite_gauche){
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
            Vertex v1 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt3.getX().toPixel(), pt3.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt4.getX().toPixel(), pt4.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt5.getX().toPixel(), pt5.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt6.getX().toPixel(), pt6.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt7.getX().toPixel(), pt7.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt8.getX().toPixel(), pt8.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v10 = new Vertex(pt8.getX().toPixel(), pt8.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v11 = new Vertex(pt7.getX().toPixel(), pt7.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v12 = new Vertex(pt6.getX().toPixel(), pt6.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v1, v2, v3));
            list1.add(new Triangle(v1, v8, v3));
        
            list1.add(new Triangle(v4, v5, v6));
            list1.add(new Triangle(v4, v6, v7));
            
            list1.add(new Triangle(v2, v3, v9));
            list1.add(new Triangle(v3, v9, v10));
            
            list1.add(new Triangle(v4, v5, v11));
            list1.add(new Triangle(v5, v12, v11));
            
            list1.add(new Triangle(v5, v6, v12));
            list1.add(new Triangle(v3, v8, v10));

            list1.add(new Triangle(v1, v2, v9));
            
            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v8, v10));
            
            list1.add(new Triangle(v6, v7, v11));
            list1.add(new Triangle(v12, v11, v6));
            
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
            
            Vertex v13 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur);
            Vertex v14 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur);
            Vertex v15 = new Vertex(pt11.getX().toPixel(), pt11.getY().toPixel(), hauteur);
            Vertex v16 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur);
            Vertex v17 = new Vertex(pt13.getX().toPixel(), pt13.getY().toPixel(), hauteur);
            Vertex v18 = new Vertex(pt14.getX().toPixel(), pt14.getY().toPixel(), hauteur);
            Vertex v19 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur);
            Vertex v20 = new Vertex(pt16.getX().toPixel(), pt16.getY().toPixel(), hauteur);
            Vertex v21 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v22 = new Vertex(pt16.getX().toPixel(), pt16.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())));
            Vertex v23 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            Vertex v24 = new Vertex(pt14.getX().toPixel(), pt14.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel())) - epaisseur_2.toPixel());
            
            list1.add(new Triangle(v13, v14, v15));
            list1.add(new Triangle(v13, v20, v15));
        
            list1.add(new Triangle(v16, v17, v18));
            list1.add(new Triangle(v16, v18, v19));
            
            list1.add(new Triangle(v14, v15, v21));
            list1.add(new Triangle(v15, v21, v22));
            
            list1.add(new Triangle(v16, v17, v24));
            list1.add(new Triangle(v16, v23, v24));
            
            list1.add(new Triangle(v17, v18, v24));
            list1.add(new Triangle(v15, v20, v22));

            list1.add(new Triangle(v13, v14, v21));
            
            list1.add(new Triangle(v13, v22, v21));
            list1.add(new Triangle(v13, v20, v22));
            
            list1.add(new Triangle(v18, v19, v23));
            list1.add(new Triangle(v24, v23, v18));
        }
        
        
        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Fini_PignonToit.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : list1) {
                out.println(tr.toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }
        
    }

    
    public void exporterDessusToit(Controleur c,List<Vertex> list, List<Triangle> list1) {
        Imperial distancesupp_2 = c.getDistanceSupp().division();
        Imperial longueur = c.getDimensions().getLongueur();
        Imperial profondeur = c.getDimensions().getProfondeur();
        Imperial epaisseur_2 = c.getEpaisseur().division();
        Imperial epaisseur = c.getEpaisseur();
        int hauteur = c.getDimensions().getHauteur().toPixel();
        if (c.getSensToit() == SensToit.Arriere_facade){
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
            Vertex v1 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt3.getX().toPixel(), pt3.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt4.getX().toPixel(), pt4.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt5.getX().toPixel(), pt5.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt6.getX().toPixel(), pt6.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt7.getX().toPixel(), pt7.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt8.getX().toPixel(), pt8.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v10 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v11 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v13 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v14 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v15 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v17 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v18 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            list1.add(new Triangle(v1, v3, v2));
            list1.add(new Triangle(v1, v3, v8));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v4, v6, v5));
            list1.add(new Triangle(v4, v7, v6));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v10, v12, v11));

            list1.add(new Triangle(v11, v14, v12));
            list1.add(new Triangle(v11, v14, v13));

            list1.add(new Triangle(v3, v14, v13));
            list1.add(new Triangle(v3, v13, v8));

            list1.add(new Triangle(v1, v9, v8));
            list1.add(new Triangle(v2, v10, v3));

            list1.add(new Triangle(v11, v13, v8));
            list1.add(new Triangle(v11, v9, v8));

            list1.add(new Triangle(v3, v12, v14));
            list1.add(new Triangle(v3, v10, v12));
            
            list1.add(new Triangle(v6, v16, v15));
            list1.add(new Triangle(v6, v15, v5));
            
            list1.add(new Triangle(v15, v18, v16));
            list1.add(new Triangle(v15, v18, v17));
            
            list1.add(new Triangle(v15, v17, v4));
            list1.add(new Triangle(v15, v5, v4));
            
            list1.add(new Triangle(v16, v18, v6));
            list1.add(new Triangle(v16, v7, v6));
        }
        if (c.getSensToit() == SensToit.Facade_arriere){
            Points pt9 = (new Points(new Imperial(2, 0, 0),
                    new Imperial(2, 0, 0).addition(profondeur)));
            Points pt10 = (new Points(pt9.getX().addition(longueur),
                    pt9.getY()));
            Points pt11 = (new Points(pt10.getX(),
                    pt10.getY().soustraction(epaisseur_2).addition(distancesupp_2)));
            Points pt12 = (new Points(pt11.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt11.getY()));
            Points pt13 = (new Points(pt12.getX(),
                    pt12.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt14 = (new Points(pt9.getX().addition(distancesupp_2).addition(epaisseur_2),
                    pt13.getY()));
            Points pt15 = (new Points(pt14.getX(),
                    pt12.getY()));
            Points pt16 = (new Points(pt9.getX(),
                    pt15.getY()));
            
            Points pt1 = (new Points(new Imperial(2, 0, 0),
                    new Imperial(2, 0, 0)));
            Points pt2 = (new Points(pt1.getX().addition(longueur),
                    pt1.getY()));
            Points pt3 = (new Points(pt2.getX(),
                    pt2.getY().soustraction(distancesupp_2).addition(epaisseur_2)));
            Points pt4 = (new Points(pt3.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt3.getY()));
            Points pt5 = (new Points(pt4.getX(),
                    pt4.getY().addition(distancesupp_2).addition(epaisseur_2)));
            Points pt6 = (new Points(pt1.getX().addition(distancesupp_2).addition(epaisseur_2),
                    pt5.getY()));
            Points pt7 = (new Points(pt6.getX(),
                    pt3.getY()));
            Points pt8 = (new Points(pt1.getX(),
                    pt4.getY()));
            Vertex v1 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt3.getX().toPixel(), pt3.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt4.getX().toPixel(), pt4.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt5.getX().toPixel(), pt5.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt6.getX().toPixel(), pt6.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt7.getX().toPixel(), pt7.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt8.getX().toPixel(), pt8.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt1.getX().toPixel(), pt1.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v10 = new Vertex(pt2.getX().toPixel(), pt2.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v11 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v13 = new Vertex(pt9.getX().toPixel(), pt9.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v14 = new Vertex(pt10.getX().toPixel(), pt10.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v15 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v17 = new Vertex(pt12.getX().toPixel(), pt12.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v18 = new Vertex(pt15.getX().toPixel(), pt15.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            list1.add(new Triangle(v1, v3, v2));
            list1.add(new Triangle(v1, v3, v8));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v4, v6, v5));
            list1.add(new Triangle(v4, v7, v6));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v10, v12, v11));

            list1.add(new Triangle(v11, v14, v12));
            list1.add(new Triangle(v11, v14, v13));

            list1.add(new Triangle(v3, v14, v13));
            list1.add(new Triangle(v3, v13, v8));

            list1.add(new Triangle(v1, v9, v8));
            list1.add(new Triangle(v2, v10, v3));

            list1.add(new Triangle(v11, v13, v8));
            list1.add(new Triangle(v11, v9, v8));

            list1.add(new Triangle(v3, v12, v14));
            list1.add(new Triangle(v3, v10, v12));
            
            list1.add(new Triangle(v6, v16, v15));
            list1.add(new Triangle(v6, v15, v5));
            
            list1.add(new Triangle(v15, v18, v16));
            list1.add(new Triangle(v15, v18, v17));
            
            list1.add(new Triangle(v15, v17, v4));
            list1.add(new Triangle(v15, v5, v4));
            
            list1.add(new Triangle(v16, v18, v6));
            list1.add(new Triangle(v16, v7, v6));
        }
        
        if (c.getSensToit() == SensToit.Droite_gauche){
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
            
            Vertex v1 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt19.getX().toPixel(), pt19.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt20.getX().toPixel(), pt20.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt21.getX().toPixel(), pt21.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt22.getX().toPixel(), pt22.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt23.getX().toPixel(), pt23.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt24.getX().toPixel(), pt24.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v10 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v11 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v13 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v14 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v15 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v17 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v18 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            list1.add(new Triangle(v1, v3, v2));
            list1.add(new Triangle(v1, v3, v8));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v4, v6, v5));
            list1.add(new Triangle(v4, v7, v6));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v10, v12, v11));

            list1.add(new Triangle(v11, v14, v12));
            list1.add(new Triangle(v11, v14, v13));

            list1.add(new Triangle(v3, v14, v13));
            list1.add(new Triangle(v3, v13, v8));

            list1.add(new Triangle(v1, v9, v8));
            list1.add(new Triangle(v2, v10, v3));

            list1.add(new Triangle(v11, v13, v8));
            list1.add(new Triangle(v11, v9, v8));

            list1.add(new Triangle(v3, v12, v14));
            list1.add(new Triangle(v3, v10, v12));
            
            list1.add(new Triangle(v6, v16, v15));
            list1.add(new Triangle(v6, v15, v5));
            
            list1.add(new Triangle(v15, v18, v16));
            list1.add(new Triangle(v15, v18, v17));
            
            list1.add(new Triangle(v15, v17, v4));
            list1.add(new Triangle(v15, v5, v4));
            
            list1.add(new Triangle(v16, v18, v6));
            list1.add(new Triangle(v16, v7, v6));
        }
        
        if (c.getSensToit() == SensToit.Gauche_droite){
            Points pt25 = (new Points(new Imperial(2, 0, 0).addition(longueur),
                    new Imperial(2, 0, 0)));
            Points pt26 = (new Points(pt25.getX(),
                    new Imperial(2, 0, 0).addition(profondeur)));
            Points pt27 = (new Points(pt26.getX().soustraction(epaisseur_2).addition(distancesupp_2),
                    pt26.getY()));
            Points pt28 = (new Points(pt27.getX(),
                    pt27.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt29 = (new Points(pt28.getX().soustraction(epaisseur_2).soustraction(distancesupp_2),
                    pt28.getY()));
            Points pt30 = (new Points(pt29.getX(),
                    pt25.getY().addition(epaisseur_2).addition(distancesupp_2)));
            Points pt31 = (new Points(pt27.getX(),
                    pt30.getY()));
            Points pt32 = (new Points(pt31.getX(),
                    pt25.getY()));
            
            Points pt17 = (new Points(new Imperial(2, 0, 0),
                    new Imperial(2, 0, 0)));
            Points pt18 = (new Points(pt17.getX(),
                    new Imperial(2, 0, 0).addition(profondeur)));
            Points pt19 = (new Points(pt18.getX().addition(epaisseur_2).soustraction(distancesupp_2),
                    pt18.getY()));
            Points pt20 = (new Points(pt19.getX(),
                    pt19.getY().soustraction(epaisseur_2).soustraction(distancesupp_2)));
            Points pt21 = (new Points(pt20.getX().addition(epaisseur_2).addition(distancesupp_2),
                    pt20.getY()));
            Points pt22 = (new Points(pt21.getX(),
                    pt17.getY().addition(epaisseur_2).addition(distancesupp_2)));
            Points pt23 = (new Points(pt20.getX(),
                    pt22.getY()));
            Points pt24 = (new Points(pt23.getX(),
                    pt17.getY()));
            
            Vertex v1 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur);
            Vertex v2 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur);
            Vertex v3 = new Vertex(pt19.getX().toPixel(), pt19.getY().toPixel(), hauteur);
            Vertex v4 = new Vertex(pt20.getX().toPixel(), pt20.getY().toPixel(), hauteur);
            Vertex v5 = new Vertex(pt21.getX().toPixel(), pt21.getY().toPixel(), hauteur);
            Vertex v6 = new Vertex(pt22.getX().toPixel(), pt22.getY().toPixel(), hauteur);
            Vertex v7 = new Vertex(pt23.getX().toPixel(), pt23.getY().toPixel(), hauteur);
            Vertex v8 = new Vertex(pt24.getX().toPixel(), pt24.getY().toPixel(), hauteur);
            Vertex v9 = new Vertex(pt17.getX().toPixel(), pt17.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v10 = new Vertex(pt18.getX().toPixel(), pt18.getY().toPixel(), hauteur + epaisseur_2.toPixel());
            Vertex v11 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v12 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v13 = new Vertex(pt25.getX().toPixel(), pt25.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v14 = new Vertex(pt26.getX().toPixel(), pt26.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() + distancesupp_2.toPixel())));
            Vertex v15 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v16 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v17 = new Vertex(pt28.getX().toPixel(), pt28.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            Vertex v18 = new Vertex(pt31.getX().toPixel(), pt31.getY().toPixel(), hauteur + epaisseur_2.toPixel() + (int) (Math.tan(Math.toRadians(c.getAngle())) * (longueur.toPixel() + epaisseur_2.toPixel() +  distancesupp_2.toPixel())) - epaisseur_2.toPixel());
            list1.add(new Triangle(v1, v3, v2));
            list1.add(new Triangle(v1, v3, v8));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v4, v6, v5));
            list1.add(new Triangle(v4, v7, v6));

            list1.add(new Triangle(v1, v10, v9));
            list1.add(new Triangle(v1, v10, v2));

            list1.add(new Triangle(v9, v10, v11));
            list1.add(new Triangle(v10, v12, v11));

            list1.add(new Triangle(v11, v14, v12));
            list1.add(new Triangle(v11, v14, v13));

            list1.add(new Triangle(v3, v14, v13));
            list1.add(new Triangle(v3, v13, v8));

            list1.add(new Triangle(v1, v9, v8));
            list1.add(new Triangle(v2, v10, v3));

            list1.add(new Triangle(v11, v13, v8));
            list1.add(new Triangle(v11, v9, v8));

            list1.add(new Triangle(v3, v12, v14));
            list1.add(new Triangle(v3, v10, v12));
            
            list1.add(new Triangle(v6, v16, v15));
            list1.add(new Triangle(v6, v15, v5));
            
            list1.add(new Triangle(v15, v18, v16));
            list1.add(new Triangle(v15, v18, v17));
            
            list1.add(new Triangle(v15, v17, v4));
            list1.add(new Triangle(v15, v5, v4));
            
            list1.add(new Triangle(v16, v18, v6));
            list1.add(new Triangle(v16, v7, v6));
        }
        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Fini_Dessus.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : list1) {
                out.println(tr.toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }
    }

    @Override
    public void createSTL(List<Triangle> list1) {
    }

    void createSTL1(List<Vertex> vertexList, List<Triangle> list1, List<AccessoiresDTO> accs, double z, List<Triangle> listm1, List<Triangle> listm2, List<Triangle> listm3, List<Triangle> listm4) {

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Fini_F.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : listm1) {
                out.println(tr.toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Fini_G.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : listm2) {
                out.println(tr.toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Fini_A.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : listm3) {
                out.println(tr.toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Fini_D.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : listm4) {
                out.println(tr.toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

    }

    @Override
    public void exporterMur(List<Vertex> vertexList, List<Triangle> triangles, double z, List<AccessoiresDTO> accs) {

    }

    @Override
    public void exporterRallongeToit(List<Vertex> vertexList, List<Triangle> triangles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void exporterPignon(List<Vertex> vertexList, List<Triangle> triangles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void exporterDessusToit(List<Vertex> vertexList, List<Triangle> triangles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
