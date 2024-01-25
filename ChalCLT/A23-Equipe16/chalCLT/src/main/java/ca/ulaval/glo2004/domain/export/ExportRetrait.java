/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.export;

import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.gui.TypeExport;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 14189
 *
 *
 */
public class ExportRetrait extends ExportSTL {

    public ExportRetrait(String path) {
        super(path);
    }

    @Override
    public void exporterMur(List<Vertex> vertexList, List<Triangle> triangles, double z, List<AccessoiresDTO> accs) {
        List<Vertex> mur1 = new ArrayList<>();
        List<Vertex> mur2 = new ArrayList<>();
        List<Vertex> mur3 = new ArrayList<>();
        List<Vertex> mur4 = new ArrayList<>();

        //mur1 F
        mur1.add(vertexList.get(0));
        mur1.add(vertexList.get(26));
        mur1.add(vertexList.get(27));
        mur1.add(vertexList.get(18));
        mur1.add(vertexList.get(19));
        mur1.add(vertexList.get(11));
        mur1.add(vertexList.get(10));
        mur1.add(vertexList.get(1));
        double dst = vertexList.get(26).x - vertexList.get(19).x;

        mur1.add(new Vertex(vertexList.get(11).x - dst, vertexList.get(11).y, vertexList.get(11).z));
        mur1.add(new Vertex(vertexList.get(19).x + dst, vertexList.get(19).y, vertexList.get(19).z));

        List<Vertex> mur1h = new ArrayList<>();
        for (Vertex point : mur1) {

            mur1h.add(new Vertex(point.x, point.y, z));

        }
        //mur 1 drawing
        Vertex pm11 = mur1.get(0);
        Vertex pm12 = mur1.get(1);
        Vertex pm13 = mur1.get(2);
        Vertex pm14 = mur1.get(3);
        Vertex pm15 = mur1.get(4);
        Vertex pm16 = mur1.get(5);
        Vertex pm17 = mur1.get(6);
        Vertex pm18 = mur1.get(7);
        Vertex pm19 = mur1.get(8);
        Vertex pm10 = mur1.get(9);

        Vertex pm11h = mur1h.get(0);
        Vertex pm12h = mur1h.get(1);
        Vertex pm13h = mur1h.get(2);
        Vertex pm14h = mur1h.get(3);
        Vertex pm15h = mur1h.get(4);
        Vertex pm16h = mur1h.get(5);
        Vertex pm17h = mur1h.get(6);
        Vertex pm18h = mur1h.get(7);
        Vertex pm19h = mur1h.get(8);
        Vertex pm10h = mur1h.get(9);

        triangles.add(new Triangle(pm18, pm17, pm16));
        triangles.add(new Triangle(pm18, pm19, pm16));

        triangles.add(new Triangle(pm18h, pm17h, pm16h));
        triangles.add(new Triangle(pm18h, pm19h, pm16h));

        triangles.add(new Triangle(pm17, pm17h, pm16));
        triangles.add(new Triangle(pm17h, pm16h, pm16));

        triangles.add(new Triangle(pm18, pm19, pm18h));
        triangles.add(new Triangle(pm18h, pm19h, pm19));

        triangles.add(new Triangle(pm19, pm16, pm19h));
        triangles.add(new Triangle(pm19h, pm16h, pm16));

        triangles.add(new Triangle(pm18, pm17, pm18h));
        triangles.add(new Triangle(pm18h, pm17h, pm17));

        triangles.add(new Triangle(pm13, pm14, pm13h));
        triangles.add(new Triangle(pm13h, pm14h, pm14));

        triangles.add(new Triangle(pm15, pm14, pm15h));
        triangles.add(new Triangle(pm15h, pm14h, pm14));

        triangles.add(new Triangle(pm15, pm10, pm15h));
        triangles.add(new Triangle(pm15h, pm10h, pm10));

        triangles.add(new Triangle(pm13, pm10, pm13h));
        triangles.add(new Triangle(pm13h, pm10h, pm10));

        triangles.add(new Triangle(pm13, pm14, pm15));
        triangles.add(new Triangle(pm13, pm15, pm10));

        triangles.add(new Triangle(pm13h, pm14h, pm15h));
        triangles.add(new Triangle(pm13h, pm15h, pm10h));

        //mur3 A
        mur3.add(vertexList.get(30));
        mur3.add(vertexList.get(31));
        mur3.add(vertexList.get(5));
        mur3.add(vertexList.get(4));
        mur3.add(vertexList.get(13));
        mur3.add(vertexList.get(12));
        mur3.add(vertexList.get(20));
        mur3.add(vertexList.get(21));

        mur3.add(new Vertex(vertexList.get(20).x + dst, vertexList.get(20).y, vertexList.get(20).z));
        mur3.add(new Vertex(vertexList.get(12).x - dst, vertexList.get(12).y, vertexList.get(12).z));

        List<Vertex> mur3h = new ArrayList<>();

        for (Vertex point : mur3) {

            mur3h.add(new Vertex(point.x, point.y, z));
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
        Vertex pm39 = mur3.get(8);
        Vertex pm30 = mur3.get(9);

        Vertex pm31h = mur3h.get(0);
        Vertex pm32h = mur3h.get(1);
        Vertex pm33h = mur3h.get(2);
        Vertex pm34h = mur3h.get(3);
        Vertex pm35h = mur3h.get(4);
        Vertex pm36h = mur3h.get(5);
        Vertex pm37h = mur3h.get(6);
        Vertex pm38h = mur3h.get(7);
        Vertex pm39h = mur3h.get(8);
        Vertex pm30h = mur3h.get(9);

        triangles.add(new Triangle(pm38, pm37, pm39));
        triangles.add(new Triangle(pm38, pm39, pm31));

        triangles.add(new Triangle(pm38h, pm37h, pm39h));
        triangles.add(new Triangle(pm38h, pm39h, pm31h));

        triangles.add(new Triangle(pm38, pm37, pm37h));
        triangles.add(new Triangle(pm38h, pm37h, pm38));

        triangles.add(new Triangle(pm37, pm37h, pm39));
        triangles.add(new Triangle(pm37h, pm39h, pm39));

        triangles.add(new Triangle(pm38, pm31, pm38h));
        triangles.add(new Triangle(pm38h, pm31h, pm31));

        triangles.add(new Triangle(pm39, pm31, pm39h));
        triangles.add(new Triangle(pm39h, pm31h, pm31));

        triangles.add(new Triangle(pm34, pm35, pm36));
        triangles.add(new Triangle(pm34, pm36, pm30));

        triangles.add(new Triangle(pm34h, pm35h, pm36h));
        triangles.add(new Triangle(pm34h, pm36h, pm30h));

        triangles.add(new Triangle(pm34, pm35, pm34h));
        triangles.add(new Triangle(pm34h, pm35h, pm35));

        triangles.add(new Triangle(pm35, pm35h, pm36));
        triangles.add(new Triangle(pm35h, pm36h, pm36));

        triangles.add(new Triangle(pm30, pm36, pm30h));
        triangles.add(new Triangle(pm30h, pm36h, pm36));

        triangles.add(new Triangle(pm30, pm34, pm30h));
        triangles.add(new Triangle(pm30h, pm34h, pm34));

        //mur2
        mur2.add(vertexList.get(28));
        mur2.add(vertexList.get(22));
        mur2.add(vertexList.get(23));
        mur2.add(vertexList.get(16));
        mur2.add(vertexList.get(17));
        mur2.add(vertexList.get(24));
        mur2.add(vertexList.get(25));
        mur2.add(vertexList.get(29));
        mur2.add(new Vertex(vertexList.get(22).x, vertexList.get(0).y, vertexList.get(22).z));
        mur2.add(new Vertex(vertexList.get(16).x, vertexList.get(0).y, vertexList.get(16).z));

        mur2.add(new Vertex(vertexList.get(22).x, vertexList.get(31).y, mur2.get(9).z));
        mur2.add(new Vertex(vertexList.get(16).x, vertexList.get(31).y, mur2.get(10).z));

        List<Vertex> mur2h = new ArrayList<>();

        for (Vertex point : mur2) {

            mur2h.add(new Vertex(point.x, point.y, z));
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
        Vertex pm29 = mur2.get(8);
        Vertex pm20 = mur2.get(9);

        Vertex pm21h = mur2h.get(0);
        Vertex pm22h = mur2h.get(1);
        Vertex pm23h = mur2h.get(2);
        Vertex pm24h = mur2h.get(3);
        Vertex pm25h = mur2h.get(4);
        Vertex pm26h = mur2h.get(5);
        Vertex pm27h = mur2h.get(6);
        Vertex pm28h = mur2h.get(7);
        Vertex pm29h = mur2h.get(8);
        Vertex pm20h = mur2h.get(9);

        triangles.add(new Triangle(pm12, pm21, pm22));
        triangles.add(new Triangle(pm22, pm29, pm12));

        triangles.add(new Triangle(pm20, pm29, pm23));
        triangles.add(new Triangle(pm20, pm24, pm23));

        triangles.add(new Triangle(pm12h, pm21h, pm22h));
        triangles.add(new Triangle(pm22h, pm29h, pm12h));

        triangles.add(new Triangle(pm20h, pm29h, pm23h));
        triangles.add(new Triangle(pm20h, pm24h, pm23h));

        triangles.add(new Triangle(pm12, pm21, pm12h));
        triangles.add(new Triangle(pm21h, pm12h, pm21));

        triangles.add(new Triangle(pm21, pm22, pm21h));
        triangles.add(new Triangle(pm21h, pm22h, pm22));

        triangles.add(new Triangle(pm22, pm23, pm23h));
        triangles.add(new Triangle(pm23h, pm22h, pm22));

        triangles.add(new Triangle(pm23, pm24, pm24h));
        triangles.add(new Triangle(pm24h, pm23h, pm23));

        triangles.add(new Triangle(pm24, pm20, pm20h));
        triangles.add(new Triangle(pm20h, pm24h, pm24));

        triangles.add(new Triangle(pm12, pm20, pm20h));
        triangles.add(new Triangle(pm20h, pm12h, pm12));

        Vertex pm211 = mur2.get(10);
        Vertex pm212 = mur2.get(11);

        Vertex pm211h = mur2h.get(10);
        Vertex pm212h = mur2h.get(11);

        triangles.add(new Triangle(pm32, pm211, pm27));
        triangles.add(new Triangle(pm27, pm28, pm32));

        triangles.add(new Triangle(pm212, pm211, pm26));
        triangles.add(new Triangle(pm26, pm25, pm212));

        triangles.add(new Triangle(pm32h, pm211h, pm27h));
        triangles.add(new Triangle(pm27h, pm28h, pm32h));

        triangles.add(new Triangle(pm212h, pm211h, pm26h));
        triangles.add(new Triangle(pm26h, pm25h, pm212h));

        triangles.add(new Triangle(pm32, pm212, pm32h));
        triangles.add(new Triangle(pm32h, pm212h, pm212));

        triangles.add(new Triangle(pm32, pm28, pm32h));
        triangles.add(new Triangle(pm32h, pm28h, pm28));

        triangles.add(new Triangle(pm27, pm28, pm27h));
        triangles.add(new Triangle(pm27h, pm28h, pm28));

        triangles.add(new Triangle(pm27, pm26, pm27h));
        triangles.add(new Triangle(pm27h, pm26h, pm26));

        triangles.add(new Triangle(pm25, pm26, pm25h));
        triangles.add(new Triangle(pm25h, pm26h, pm26));

        triangles.add(new Triangle(pm25, pm212, pm25h));
        triangles.add(new Triangle(pm25h, pm212h, pm212));

        //mur4
        mur4.add(vertexList.get(3));
        mur4.add(vertexList.get(2));
        mur4.add(vertexList.get(6));
        mur4.add(vertexList.get(7));
        mur4.add(vertexList.get(14));
        mur4.add(vertexList.get(15));
        mur4.add(vertexList.get(8));
        mur4.add(vertexList.get(9));

        mur4.add(new Vertex(vertexList.get(7).x, vertexList.get(0).y, vertexList.get(7).z));
        mur4.add(new Vertex(vertexList.get(14).x, vertexList.get(0).y, vertexList.get(14).z));

        mur4.add(new Vertex(vertexList.get(7).x, vertexList.get(5).y, vertexList.get(7).z));
        mur4.add(new Vertex(vertexList.get(14).x, vertexList.get(5).y, vertexList.get(14).z));

        List<Vertex> mur4h = new ArrayList<>();

        for (Vertex point : mur4) {

            mur4h.add(new Vertex(point.x, point.y, z));
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

        Vertex pm411 = mur4.get(8);
        Vertex pm412 = mur4.get(9);

        Vertex pm411h = mur4h.get(8);
        Vertex pm412h = mur4h.get(9);

        triangles.add(new Triangle(pm11, pm42, pm43));
        triangles.add(new Triangle(pm43, pm411, pm11));

        triangles.add(new Triangle(pm411, pm44, pm45));
        triangles.add(new Triangle(pm411, pm412, pm45));

        triangles.add(new Triangle(pm11h, pm42h, pm43h));
        triangles.add(new Triangle(pm43h, pm411h, pm11h));

        triangles.add(new Triangle(pm411h, pm44h, pm45h));
        triangles.add(new Triangle(pm411h, pm412h, pm45h));

        triangles.add(new Triangle(pm42, pm11, pm42h));
        triangles.add(new Triangle(pm42h, pm11h, pm11));

        triangles.add(new Triangle(pm412, pm11, pm412h));
        triangles.add(new Triangle(pm412h, pm11h, pm11));

        triangles.add(new Triangle(pm412, pm45, pm412h));
        triangles.add(new Triangle(pm412h, pm45h, pm45));

        triangles.add(new Triangle(pm44, pm45, pm44h));
        triangles.add(new Triangle(pm44h, pm45h, pm45));

        triangles.add(new Triangle(pm44, pm43, pm44h));
        triangles.add(new Triangle(pm44h, pm43h, pm43));

        triangles.add(new Triangle(pm42, pm43, pm42h));
        triangles.add(new Triangle(pm42h, pm43h, pm43));

        Vertex pm413 = mur4.get(10);
        Vertex pm414 = mur4.get(11);

        Vertex pm413h = mur4h.get(10);
        Vertex pm414h = mur4h.get(11);

        triangles.add(new Triangle(pm33, pm41, pm48));
        triangles.add(new Triangle(pm33, pm413, pm48));

        triangles.add(new Triangle(pm413, pm47, pm46));
        triangles.add(new Triangle(pm413, pm414, pm46));

        triangles.add(new Triangle(pm33h, pm41h, pm48h));
        triangles.add(new Triangle(pm33h, pm413h, pm48h));

        triangles.add(new Triangle(pm413h, pm47h, pm46h));
        triangles.add(new Triangle(pm413h, pm414h, pm46h));

        triangles.add(new Triangle(pm33, pm41, pm33h));
        triangles.add(new Triangle(pm33h, pm41h, pm41));

        triangles.add(new Triangle(pm46, pm414, pm46h));
        triangles.add(new Triangle(pm46h, pm414h, pm414));

        triangles.add(new Triangle(pm46, pm47, pm46h));
        triangles.add(new Triangle(pm46h, pm47h, pm47));

        triangles.add(new Triangle(pm48, pm47, pm48h));
        triangles.add(new Triangle(pm48h, pm47h, pm47));

        triangles.add(new Triangle(pm48, pm41, pm48h));
        triangles.add(new Triangle(pm48h, pm41h, pm41));

        triangles.add(new Triangle(pm33, pm414, pm33h));
        triangles.add(new Triangle(pm33h, pm414h, pm414));

    }

    @Override
    public void exporterRallongeToit(List<Vertex> list, List<Triangle> list1) {
    }

    @Override
    public void exporterPignon(List<Vertex> list, List<Triangle> list1) {
    }

    @Override
    public void exporterDessusToit(List<Vertex> list, List<Triangle> list1) {
    }

    public void createSTL1(List<Vertex> vertexList, List<Triangle> list1, List<AccessoiresDTO> accs) {

        List<AccessoiresDTO> accmur1 = new ArrayList<>(); // facade
        List<AccessoiresDTO> accmur2 = new ArrayList<>();  // gauche
        List<AccessoiresDTO> accmur3 = new ArrayList<>();  // arriere
        List<AccessoiresDTO> accmur4 = new ArrayList<>();  //droite

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

        System.out.println(accmur1.size());
        System.out.println(accmur2.size());
        System.out.println(accmur3.size());
        System.out.println(accmur4.size());

        //mur 1 retrait
        int index = 3;
        for (AccessoiresDTO ac : accmur1) {

            double zmax = 100 + ac.dimensions.getHauteur().toPixel();
            double zmin = 100;

            double width = vertexList.get(19).y - vertexList.get(0).y;

            Vertex pt1 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt2 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt3 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt4 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt5 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt6 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt7 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmin);

            Vertex pt8 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmin);

            List<Triangle> triangles1 = new ArrayList();

            triangles1.add(new Triangle(pt1, pt2, pt3));
            triangles1.add(new Triangle(pt1, pt4, pt3));

            triangles1.add(new Triangle(pt5, pt6, pt7));
            triangles1.add(new Triangle(pt5, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt6));
            triangles1.add(new Triangle(pt1, pt2, pt6));

            triangles1.add(new Triangle(pt2, pt6, pt7));
            triangles1.add(new Triangle(pt2, pt3, pt7));

            triangles1.add(new Triangle(pt4, pt3, pt7));
            triangles1.add(new Triangle(pt4, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt8));
            triangles1.add(new Triangle(pt1, pt4, pt8));

            try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_F_" + index + ".stl"))) {
                out.println("solid chalet_walls");
                int i;
                for (Triangle t : triangles1) {
                    out.println(t.toStlString());
                }
                out.println("endsolid chalet_walls");
                System.out.println("STL file has been created successfully.");

            } catch (IOException e) {
                System.err.println("An error occurred while writing the STL file.");
                e.printStackTrace();
            }
            index++;

        }

        //mur 2 retrait 
        index = 3;
        for (AccessoiresDTO ac : accmur2) {

            double zmax = 100 + ac.dimensions.getHauteur().toPixel();
            double zmin = 100;

            double width = vertexList.get(19).y - vertexList.get(0).y;

            Vertex pt1 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt2 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt3 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt4 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt5 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt6 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt7 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmin);

            Vertex pt8 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmin);

            List<Triangle> triangles1 = new ArrayList();

            triangles1.add(new Triangle(pt1, pt2, pt3));
            triangles1.add(new Triangle(pt1, pt4, pt3));

            triangles1.add(new Triangle(pt5, pt6, pt7));
            triangles1.add(new Triangle(pt5, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt6));
            triangles1.add(new Triangle(pt1, pt2, pt6));

            triangles1.add(new Triangle(pt2, pt6, pt7));
            triangles1.add(new Triangle(pt2, pt3, pt7));

            triangles1.add(new Triangle(pt4, pt3, pt7));
            triangles1.add(new Triangle(pt4, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt8));
            triangles1.add(new Triangle(pt1, pt4, pt8));

            try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_G_" + index + ".stl"))) {
                out.println("solid chalet_walls");
                int i;
                for (Triangle t : triangles1) {
                    out.println(t.toStlString());
                }
                out.println("endsolid chalet_walls");
                System.out.println("STL file has been created successfully.");

            } catch (IOException e) {
                System.err.println("An error occurred while writing the STL file.");
                e.printStackTrace();
            }
            index++;

        }

        //mur 3 retrait 
        index = 3;
        for (AccessoiresDTO ac : accmur3) {

            double zmax = 100 + ac.dimensions.getHauteur().toPixel();
            double zmin = 100;

            double width = vertexList.get(19).y - vertexList.get(0).y;

            Vertex pt1 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt2 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt3 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt4 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt5 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt6 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt7 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmin);

            Vertex pt8 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmin);

            List<Triangle> triangles1 = new ArrayList();

            triangles1.add(new Triangle(pt1, pt2, pt3));
            triangles1.add(new Triangle(pt1, pt4, pt3));

            triangles1.add(new Triangle(pt5, pt6, pt7));
            triangles1.add(new Triangle(pt5, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt6));
            triangles1.add(new Triangle(pt1, pt2, pt6));

            triangles1.add(new Triangle(pt2, pt6, pt7));
            triangles1.add(new Triangle(pt2, pt3, pt7));

            triangles1.add(new Triangle(pt4, pt3, pt7));
            triangles1.add(new Triangle(pt4, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt8));
            triangles1.add(new Triangle(pt1, pt4, pt8));

            try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_A_" + index + ".stl"))) {
                out.println("solid chalet_walls");
                int i;
                for (Triangle t : triangles1) {
                    out.println(t.toStlString());
                }
                out.println("endsolid chalet_walls");
                System.out.println("STL file has been created successfully.");

            } catch (IOException e) {
                System.err.println("An error occurred while writing the STL file.");
                e.printStackTrace();
            }
            index++;

        }

        //mur 4 retrait 
        index = 3;
        for (AccessoiresDTO ac : accmur4) {

            double zmax = 100 + ac.dimensions.getHauteur().toPixel();
            double zmin = 100;

            double width = vertexList.get(19).y - vertexList.get(0).y;

            Vertex pt1 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt2 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmax);

            Vertex pt3 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt4 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmax);

            Vertex pt5 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt6 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel(), zmin);

            Vertex pt7 = new Vertex(ac.position.x.toPixel() + ac.dimensions.getLongueur().toPixel(), ac.position.y.toPixel() + width, zmin);

            Vertex pt8 = new Vertex(ac.position.x.toPixel(), ac.position.y.toPixel() + width, zmin);

            List<Triangle> triangles1 = new ArrayList();

            triangles1.add(new Triangle(pt1, pt2, pt3));
            triangles1.add(new Triangle(pt1, pt4, pt3));

            triangles1.add(new Triangle(pt5, pt6, pt7));
            triangles1.add(new Triangle(pt5, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt6));
            triangles1.add(new Triangle(pt1, pt2, pt6));

            triangles1.add(new Triangle(pt2, pt6, pt7));
            triangles1.add(new Triangle(pt2, pt3, pt7));

            triangles1.add(new Triangle(pt4, pt3, pt7));
            triangles1.add(new Triangle(pt4, pt8, pt7));

            triangles1.add(new Triangle(pt1, pt5, pt8));
            triangles1.add(new Triangle(pt1, pt4, pt8));

            try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_D_" + index + ".stl"))) {
                out.println("solid chalet_walls");
                int i;
                for (Triangle t : triangles1) {
                    out.println(t.toStlString());
                }
                out.println("endsolid chalet_walls");
                System.out.println("STL file has been created successfully.");

            } catch (IOException e) {
                System.err.println("An error occurred while writing the STL file.");
                e.printStackTrace();
            }
            index++;

        }

    }

    @Override
    public void createSTL(List<Triangle> list1) {

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_F_1.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 0; i < 12; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_F_2.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 12; i < 24; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_A_1.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 24; i < 36; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_A_2.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 36; i < 48; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_G_1.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 48; i < 68; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_G_2.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 68; i < 88; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_D_1.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 88; i < 108; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Retrait_D_2.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 108; i < 128; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("STL file has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the STL file.");
            e.printStackTrace();
        }
    }

}
