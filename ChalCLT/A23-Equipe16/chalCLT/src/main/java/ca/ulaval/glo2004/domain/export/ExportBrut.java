/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.export;

import ca.ulaval.glo2004.domain.Controleur;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.domain.SensToit;
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
public class ExportBrut extends ExportSTL {

    public ExportBrut(String path) {
        super(path);
    }

    
    public void exporterMur(Controleur controller, List<Vertex> vertexList, List<Triangle> triangles, double z, List<AccessoiresDTO> accs) {
        List<Vertex> mur1 = new ArrayList<>();
        List<Vertex> mur2 = new ArrayList<>();
        List<Vertex> mur3 = new ArrayList<>();
        List<Vertex> mur4 = new ArrayList<>();

        if (controller.getSensToit() == SensToit.Facade_arriere || controller.getSensToit() == SensToit.Arriere_facade) {

            //mur1
            mur1.add(vertexList.get(0));
            mur1.add(vertexList.get(26));

            double dst = vertexList.get(26).x - vertexList.get(19).x;
            mur1.add(new Vertex(vertexList.get(19).x + dst, vertexList.get(19).y, vertexList.get(19).z));
            mur1.add(new Vertex(vertexList.get(11).x - dst, vertexList.get(11).y, vertexList.get(11).z));

            List<Vertex> mur1h = new ArrayList<>();

            for (Vertex point : mur1) {

                mur1h.add(new Vertex(point.x, point.y, z));

            }

            Vertex pm11 = mur1.get(0);
            Vertex pm12 = mur1.get(1);
            Vertex pm13 = mur1.get(2);
            Vertex pm14 = mur1.get(3);

            Vertex pm11h = mur1h.get(0);
            Vertex pm12h = mur1h.get(1);
            Vertex pm13h = mur1h.get(2);
            Vertex pm14h = mur1h.get(3);

            triangles.add(new Triangle(pm11, pm12, pm13));
            triangles.add(new Triangle(pm11, pm13, pm14));

            triangles.add(new Triangle(pm11h, pm12h, pm13h));
            triangles.add(new Triangle(pm11h, pm13h, pm14h));

            triangles.add(new Triangle(pm11, pm11h, pm14));
            triangles.add(new Triangle(pm11h, pm14, pm14h));

            triangles.add(new Triangle(pm12, pm13, pm12h));
            triangles.add(new Triangle(pm12h, pm13, pm13h));

            triangles.add(new Triangle(pm11, pm12, pm11h));
            triangles.add(new Triangle(pm12h, pm11h, pm12));

            triangles.add(new Triangle(pm14, pm13, pm14h));
            triangles.add(new Triangle(pm14h, pm13h, pm13));

            //mur2
            mur2.add(vertexList.get(28));

            double dstt = vertexList.get(29).y - vertexList.get(17).y;

            mur2.add(new Vertex(vertexList.get(16).x, vertexList.get(16).y - dstt, vertexList.get(16).z));
            mur2.add(new Vertex(vertexList.get(17).x, vertexList.get(17).y + dstt, vertexList.get(17).z));
            mur2.add(vertexList.get(29));

            Vertex pm21 = mur2.get(0);
            Vertex pm22 = mur2.get(1);
            Vertex pm23 = mur2.get(2);
            Vertex pm24 = mur2.get(3);
            List<Vertex> mur2h = new ArrayList<>();
            for (Vertex point : mur2) {

                mur2h.add(new Vertex(point.x, point.y, z));
            }
            Vertex pm21h = mur2h.get(0);
            Vertex pm22h = mur2h.get(1);
            Vertex pm23h = mur2h.get(2);
            Vertex pm24h = mur2h.get(3);

            triangles.add(new Triangle(pm21, pm22, pm23));
            triangles.add(new Triangle(pm21, pm23, pm24));

            triangles.add(new Triangle(pm21h, pm22h, pm23h));
            triangles.add(new Triangle(pm21h, pm23h, pm24h));

            triangles.add(new Triangle(pm21, pm21h, pm24));
            triangles.add(new Triangle(pm21h, pm24, pm24h));

            triangles.add(new Triangle(pm22, pm23, pm22h));
            triangles.add(new Triangle(pm22h, pm23, pm23h));

            triangles.add(new Triangle(pm21, pm22, pm21h));
            triangles.add(new Triangle(pm22h, pm21h, pm22));

            triangles.add(new Triangle(pm24, pm23, pm24h));
            triangles.add(new Triangle(pm24h, pm23h, pm23));

            //mur3
            mur3.add(vertexList.get(31));
            mur3.add(vertexList.get(5));

            double dsttt = vertexList.get(12).x - vertexList.get(5).x;
            mur3.add(new Vertex(vertexList.get(12).x - dst, vertexList.get(12).y, vertexList.get(12).z));
            mur3.add(new Vertex(vertexList.get(20).x + dst, vertexList.get(20).y, vertexList.get(20).z));

            List<Vertex> mur3h = new ArrayList<>();

            Vertex pm31 = mur3.get(0);
            Vertex pm32 = mur3.get(1);
            Vertex pm33 = mur3.get(2);
            Vertex pm34 = mur3.get(3);

            for (Vertex point : mur3) {

                mur3h.add(new Vertex(point.x, point.y, z));
            }
            Vertex pm31h = mur3h.get(0);
            Vertex pm32h = mur3h.get(1);
            Vertex pm33h = mur3h.get(2);
            Vertex pm34h = mur3h.get(3);

            triangles.add(new Triangle(pm31, pm32, pm33));
            triangles.add(new Triangle(pm31, pm33, pm34));

            triangles.add(new Triangle(pm31h, pm32h, pm33h));
            triangles.add(new Triangle(pm31h, pm33h, pm34h));

            triangles.add(new Triangle(pm31, pm31h, pm34));
            triangles.add(new Triangle(pm31h, pm34, pm34h));

            triangles.add(new Triangle(pm32, pm33, pm32h));
            triangles.add(new Triangle(pm32h, pm33, pm33h));

            triangles.add(new Triangle(pm31, pm32, pm31h));
            triangles.add(new Triangle(pm32h, pm31h, pm32));

            triangles.add(new Triangle(pm34, pm33, pm34h));
            triangles.add(new Triangle(pm34h, pm33h, pm33));

            //mur4
            mur4.add(vertexList.get(3));
            mur4.add(vertexList.get(2));
            double dist = vertexList.get(14).y - vertexList.get(2).y;

            mur4.add(new Vertex(vertexList.get(14).x, vertexList.get(14).y - dstt, vertexList.get(14).z));
            mur4.add(new Vertex(vertexList.get(15).x, vertexList.get(15).y + dstt, vertexList.get(15).z));

            List<Vertex> mur4h = new ArrayList<>();

            for (Vertex point : mur4) {

                mur4h.add(new Vertex(point.x, point.y, z));
            }

            Vertex pm41 = mur4.get(0);
            Vertex pm42 = mur4.get(1);
            Vertex pm43 = mur4.get(2);
            Vertex pm44 = mur4.get(3);
            Vertex pm41h = mur4h.get(0);
            Vertex pm42h = mur4h.get(1);
            Vertex pm43h = mur4h.get(2);
            Vertex pm44h = mur4h.get(3);

            triangles.add(new Triangle(pm41, pm42, pm43));
            triangles.add(new Triangle(pm41, pm43, pm44));

            triangles.add(new Triangle(pm41h, pm42h, pm43h));
            triangles.add(new Triangle(pm41h, pm43h, pm44h));

            triangles.add(new Triangle(pm41, pm41h, pm44));
            triangles.add(new Triangle(pm41h, pm44, pm44h));

            triangles.add(new Triangle(pm42, pm43, pm42h));
            triangles.add(new Triangle(pm42h, pm43, pm43h));

            triangles.add(new Triangle(pm41, pm42, pm41h));
            triangles.add(new Triangle(pm42h, pm41h, pm42));

            triangles.add(new Triangle(pm44, pm43, pm44h));
            triangles.add(new Triangle(pm44h, pm43h, pm43));
        } else {

            //mur1
            mur1.add(vertexList.get(6));
            mur1.add(vertexList.get(22));

            double dst = vertexList.get(23).x - vertexList.get(16).x;
            mur1.add(new Vertex(vertexList.get(17).x + dst, vertexList.get(17).y, vertexList.get(17).z));
            mur1.add(new Vertex(vertexList.get(13).x - dst, vertexList.get(13).y, vertexList.get(13).z));

            List<Vertex> mur1h = new ArrayList<>();

            for (Vertex point : mur1) {

                mur1h.add(new Vertex(point.x, point.y, z));

            }

            Vertex pm11 = mur1.get(0);
            Vertex pm12 = mur1.get(1);
            Vertex pm13 = mur1.get(2);
            Vertex pm14 = mur1.get(3);

            Vertex pm11h = mur1h.get(0);
            Vertex pm12h = mur1h.get(1);
            Vertex pm13h = mur1h.get(2);
            Vertex pm14h = mur1h.get(3);

            triangles.add(new Triangle(pm11, pm12, pm13));
            triangles.add(new Triangle(pm11, pm13, pm14));

            triangles.add(new Triangle(pm11h, pm12h, pm13h));
            triangles.add(new Triangle(pm11h, pm13h, pm14h));

            triangles.add(new Triangle(pm11, pm11h, pm14));
            triangles.add(new Triangle(pm11h, pm14, pm14h));

            triangles.add(new Triangle(pm12, pm13, pm12h));
            triangles.add(new Triangle(pm12h, pm13, pm13h));

            triangles.add(new Triangle(pm11, pm12, pm11h));
            triangles.add(new Triangle(pm12h, pm11h, pm12));

            triangles.add(new Triangle(pm14, pm13, pm14h));
            triangles.add(new Triangle(pm14h, pm13h, pm13));

            //mur2
            mur2.add(vertexList.get(30));

            double dstt = vertexList.get(29).y - vertexList.get(28).y;

            mur2.add(new Vertex(vertexList.get(20).x, vertexList.get(20).y - dstt, vertexList.get(20).z));
            mur2.add(new Vertex(vertexList.get(21).x, vertexList.get(21).y + dstt, vertexList.get(21).z));
            mur2.add(vertexList.get(31));

            Vertex pm21 = mur2.get(0);
            Vertex pm22 = mur2.get(1);
            Vertex pm23 = mur2.get(2);
            Vertex pm24 = mur2.get(3);
            List<Vertex> mur2h = new ArrayList<>();
            for (Vertex point : mur2) {

                mur2h.add(new Vertex(point.x, point.y, z));
            }
            Vertex pm21h = mur2h.get(0);
            Vertex pm22h = mur2h.get(1);
            Vertex pm23h = mur2h.get(2);
            Vertex pm24h = mur2h.get(3);

            triangles.add(new Triangle(pm21, pm22, pm23));
            triangles.add(new Triangle(pm21, pm23, pm24));

            triangles.add(new Triangle(pm21h, pm22h, pm23h));
            triangles.add(new Triangle(pm21h, pm23h, pm24h));

            triangles.add(new Triangle(pm21, pm21h, pm24));
            triangles.add(new Triangle(pm21h, pm24, pm24h));

            triangles.add(new Triangle(pm22, pm23, pm22h));
            triangles.add(new Triangle(pm22h, pm23, pm23h));

            triangles.add(new Triangle(pm21, pm22, pm21h));
            triangles.add(new Triangle(pm22h, pm21h, pm22));

            triangles.add(new Triangle(pm24, pm23, pm24h));
            triangles.add(new Triangle(pm24h, pm23h, pm23));

            //mur3
            mur3.add(vertexList.get(25));
            mur3.add(vertexList.get(9));

            double dsttt = vertexList.get(15).x - vertexList.get(5).x;
            mur3.add(new Vertex(vertexList.get(14).x - dst, vertexList.get(14).y, vertexList.get(14).z));
            mur3.add(new Vertex(vertexList.get(18).x + dst, vertexList.get(18).y, vertexList.get(18).z));

            List<Vertex> mur3h = new ArrayList<>();

            Vertex pm31 = mur3.get(0);
            Vertex pm32 = mur3.get(1);
            Vertex pm33 = mur3.get(2);
            Vertex pm34 = mur3.get(3);

            for (Vertex point : mur3) {

                mur3h.add(new Vertex(point.x, point.y, z));
            }
            Vertex pm31h = mur3h.get(0);
            Vertex pm32h = mur3h.get(1);
            Vertex pm33h = mur3h.get(2);
            Vertex pm34h = mur3h.get(3);

            triangles.add(new Triangle(pm31, pm32, pm33));
            triangles.add(new Triangle(pm31, pm33, pm34));

            triangles.add(new Triangle(pm31h, pm32h, pm33h));
            triangles.add(new Triangle(pm31h, pm33h, pm34h));

            triangles.add(new Triangle(pm31, pm31h, pm34));
            triangles.add(new Triangle(pm31h, pm34, pm34h));

            triangles.add(new Triangle(pm32, pm33, pm32h));
            triangles.add(new Triangle(pm32h, pm33, pm33h));

            triangles.add(new Triangle(pm31, pm32, pm31h));
            triangles.add(new Triangle(pm32h, pm31h, pm32));

            triangles.add(new Triangle(pm34, pm33, pm34h));
            triangles.add(new Triangle(pm34h, pm33h, pm33));

            //mur4
            mur4.add(vertexList.get(1));
            mur4.add(vertexList.get(0));
            double dist = vertexList.get(3).y - vertexList.get(2).y;

            mur4.add(new Vertex(vertexList.get(10).x, vertexList.get(10).y - dstt, vertexList.get(10).z));
            mur4.add(new Vertex(vertexList.get(11).x, vertexList.get(11).y + dstt, vertexList.get(11).z));

            List<Vertex> mur4h = new ArrayList<>();

            for (Vertex point : mur4) {

                mur4h.add(new Vertex(point.x, point.y, z));
            }

            Vertex pm41 = mur4.get(0);
            Vertex pm42 = mur4.get(1);
            Vertex pm43 = mur4.get(2);
            Vertex pm44 = mur4.get(3);
            Vertex pm41h = mur4h.get(0);
            Vertex pm42h = mur4h.get(1);
            Vertex pm43h = mur4h.get(2);
            Vertex pm44h = mur4h.get(3);

            triangles.add(new Triangle(pm41, pm42, pm43));
            triangles.add(new Triangle(pm41, pm43, pm44));

            triangles.add(new Triangle(pm41h, pm42h, pm43h));
            triangles.add(new Triangle(pm41h, pm43h, pm44h));

            triangles.add(new Triangle(pm41, pm41h, pm44));
            triangles.add(new Triangle(pm41h, pm44, pm44h));

            triangles.add(new Triangle(pm42, pm43, pm42h));
            triangles.add(new Triangle(pm42h, pm43, pm43h));

            triangles.add(new Triangle(pm41, pm42, pm41h));
            triangles.add(new Triangle(pm42h, pm41h, pm42));

            triangles.add(new Triangle(pm44, pm43, pm44h));
            triangles.add(new Triangle(pm44h, pm43h, pm43));

        }
    }

    public void exporterRallongeToit(Controleur controller, List<Vertex> list, List<Triangle> list1, double z) {
        List<Triangle> trianglesdessus = new ArrayList<>();
        int hauteur = (int) (Math.tan(Math.toRadians(controller.getAngle())) * (controller.getDimensions().getLongueur().toPixel()));
        if (controller.getSensToit() == SensToit.Facade_arriere || controller.getSensToit() == SensToit.Arriere_facade) {
            double dst = list.get(26).x - list.get(19).x;

            Vertex pt1 = new Vertex(list.get(0).x, list.get(0).y, z);
            Vertex pt2 = (new Vertex(list.get(26).x, list.get(26).y, z));
            Vertex pt4 = (new Vertex(list.get(19).x + dst, list.get(19).y, z));
            Vertex pt3 = (new Vertex(list.get(11).x - dst, list.get(11).y, z));
            Vertex pt5 = (new Vertex(list.get(0).x, list.get(0).y, z + hauteur));
            Vertex pt6 = (new Vertex(list.get(26).x, list.get(26).y, z + hauteur));
            Vertex pt7 = (new Vertex(list.get(19).x + dst, list.get(19).y, z + hauteur));
            Vertex pt8 = (new Vertex(list.get(11).x - dst, list.get(11).y, z + hauteur));

            list1.add(new Triangle(pt1, pt5, pt6));
            list1.add(new Triangle(pt1, pt2, pt6));

            list1.add(new Triangle(pt3, pt8, pt7));
            list1.add(new Triangle(pt3, pt4, pt7));

            list1.add(new Triangle(pt1, pt5, pt8));
            list1.add(new Triangle(pt1, pt3, pt8));

            list1.add(new Triangle(pt1, pt2, pt4));
            list1.add(new Triangle(pt1, pt3, pt4));

            list1.add(new Triangle(pt4, pt7, pt6));
            list1.add(new Triangle(pt4, pt2, pt6));

            list1.add(new Triangle(pt5, pt6, pt7));
            list1.add(new Triangle(pt5, pt8, pt7));

            // dessus toit
            Vertex ptt1 = list.get(31);
            Vertex ptt2 = list.get(5);

            Vertex ptt5 = new Vertex(pt5.x, pt5.y, pt5.z + 90);
            Vertex ptt6 = new Vertex(pt6.x, pt6.y, pt6.z + 90);

            Vertex ptt7 = new Vertex(ptt1.x, ptt1.y, ptt1.z + 90);
            Vertex ptt8 = new Vertex(ptt2.x, ptt2.y, ptt2.z + 90);

            trianglesdessus.add(new Triangle(pt5, pt6, ptt1));
            trianglesdessus.add(new Triangle(pt5, ptt2, ptt1));

            trianglesdessus.add(new Triangle(ptt5, ptt6, ptt7));
            trianglesdessus.add(new Triangle(ptt5, ptt8, ptt7));

            trianglesdessus.add(new Triangle(ptt5, pt5, ptt2));
            trianglesdessus.add(new Triangle(ptt5, ptt8, ptt2));

            trianglesdessus.add(new Triangle(ptt6, pt6, ptt1));
            trianglesdessus.add(new Triangle(ptt6, ptt7, ptt1));

            trianglesdessus.add(new Triangle(ptt6, pt6, pt5));
            trianglesdessus.add(new Triangle(ptt6, ptt5, pt5));

            trianglesdessus.add(new Triangle(ptt8, pt6, ptt1));
            trianglesdessus.add(new Triangle(ptt8, ptt2, ptt1));

        } else {
            double dst = list.get(28).x - list.get(25).x;

            Vertex pt1 = new Vertex(list.get(30).x, list.get(30).y, z);
            Vertex pt2 = (new Vertex(list.get(31).x, list.get(31).y, z));
            Vertex pt4 = (new Vertex(list.get(29).x-dst, list.get(29).y , z));
            Vertex pt3 = (new Vertex(list.get(26).x-dst, list.get(26).y , z));
            Vertex pt5 = (new Vertex(list.get(30).x, list.get(30).y, z + hauteur));
            Vertex pt6 = (new Vertex(list.get(31).x, list.get(31).y, z + hauteur));
            Vertex pt7 = (new Vertex(list.get(29).x-dst, list.get(29).y , z + hauteur));
            Vertex pt8 = (new Vertex(list.get(26).x-dst, list.get(26).y, z + hauteur));

            list1.add(new Triangle(pt1, pt5, pt6));
            list1.add(new Triangle(pt1, pt2, pt6));

            list1.add(new Triangle(pt3, pt8, pt7));
            list1.add(new Triangle(pt3, pt4, pt7));

            list1.add(new Triangle(pt1, pt5, pt8));
            list1.add(new Triangle(pt1, pt3, pt8));

            list1.add(new Triangle(pt1, pt2, pt4));
            list1.add(new Triangle(pt1, pt3, pt4));

            list1.add(new Triangle(pt4, pt7, pt6));
            list1.add(new Triangle(pt4, pt2, pt6));

            list1.add(new Triangle(pt5, pt6, pt7));
            list1.add(new Triangle(pt5, pt8, pt7));

            // dessus toit
            Vertex ptt1 = list.get(0);
            Vertex ptt2 = list.get(1);

            Vertex ptt5 = new Vertex(pt5.x, pt5.y, pt5.z + 90);
            Vertex ptt6 = new Vertex(pt6.x, pt6.y, pt6.z + 90);

            Vertex ptt7 = new Vertex(ptt1.x, ptt1.y, ptt1.z + 90);
            Vertex ptt8 = new Vertex(ptt2.x, ptt2.y, ptt2.z + 90);

            trianglesdessus.add(new Triangle(pt5, pt6, ptt2));
            trianglesdessus.add(new Triangle(pt5, ptt1, ptt2));

            trianglesdessus.add(new Triangle(pt5, ptt5, ptt7));
            trianglesdessus.add(new Triangle(pt5, ptt1, ptt7));

            trianglesdessus.add(new Triangle(ptt5, pt6, ptt2));
            trianglesdessus.add(new Triangle(ptt5, ptt1, ptt2));

            trianglesdessus.add(new Triangle(ptt6, ptt5, ptt7));
            trianglesdessus.add(new Triangle(ptt6, ptt8, ptt7));

            trianglesdessus.add(new Triangle(ptt6, pt6, pt5));
            trianglesdessus.add(new Triangle(ptt6, ptt5, pt5));

            trianglesdessus.add(new Triangle(ptt8, ptt2, pt6));
            trianglesdessus.add(new Triangle(ptt8, ptt6, pt6));

        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_RallongeToit.stl"))) {
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

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_DessusToit.stl"))) {
            out.println("solid chalet_walls");
            for (Triangle tr : trianglesdessus) {
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
    public void exporterRallongeToit(List<Vertex> list, List<Triangle> list1) {
        /*
        List<Vertex> rallonge = new ArrayList<>();
        rallonge.add(new Vertex(list.get(0).x,list.get(0).y,400));
        rallonge.add(new Vertex(list.get(26).x,list.get(26).y,400));
        rallonge.add(new Vertex(list.get(0).x,list.get(0).y,300));
        rallonge.add(new Vertex(list.get(26).x,list.get(26).y,300));
        
        
        list1.add(new Triangle(rallonge.get(0), rallonge.get(1), rallonge.get(2)));
        list1.add(new Triangle(rallonge.get(1), rallonge.get(3), rallonge.get(2)));
         */

    }

    public void exporterPignon(Controleur controller, List<Vertex> list, List<Triangle> list1, double z) {
        int hauteur = (int) (Math.tan(Math.toRadians(controller.getAngle())) * (controller.getDimensions().getLongueur().toPixel()));
        if (controller.getSensToit() == SensToit.Facade_arriere || controller.getSensToit() == SensToit.Arriere_facade) {

            double dstt = list.get(29).y - list.get(17).y;

            Vertex pt1 = new Vertex(list.get(28).x, list.get(28).y, z);

            Vertex pt2 = new Vertex(list.get(16).x, list.get(16).y - dstt, z);

            Vertex pt3 = new Vertex(list.get(17).x, list.get(17).y + dstt, z);

            Vertex pt4 = new Vertex(list.get(29).x, list.get(29).y, z);

            Vertex pt5 = new Vertex(list.get(28).x, list.get(28).y, z + hauteur);

            Vertex pt6 = new Vertex(list.get(16).x, list.get(16).y - dstt, z + hauteur);

            list1.add(new Triangle(pt1, pt2, pt3));
            list1.add(new Triangle(pt1, pt4, pt3));

            list1.add(new Triangle(pt1, pt2, pt6));
            list1.add(new Triangle(pt1, pt5, pt6));

            list1.add(new Triangle(pt1, pt5, pt4));
            list1.add(new Triangle(pt6, pt2, pt3));

            list1.add(new Triangle(pt4, pt3, pt6));
            list1.add(new Triangle(pt4, pt5, pt6));

        } else {

            double dstt = list.get(23).x - list.get(16).x;

            Vertex pt1 = new Vertex(list.get(6).x, list.get(6).y, z);

            Vertex pt2 = new Vertex(list.get(13).x-dstt, list.get(13).y, z);

            Vertex pt3 = new Vertex(list.get(17).x+dstt, list.get(17).y , z);

            Vertex pt4 = new Vertex(list.get(22).x, list.get(22).y, z);

            Vertex pt5 = new Vertex(list.get(6).x, list.get(6).y, z + hauteur);

             Vertex pt6 = new Vertex(list.get(13).x-dstt, list.get(13).y, z+hauteur);

            list1.add(new Triangle(pt1, pt2, pt3));
            list1.add(new Triangle(pt1, pt4, pt3));

            list1.add(new Triangle(pt1, pt2, pt6));
            list1.add(new Triangle(pt1, pt5, pt6));

            list1.add(new Triangle(pt1, pt5, pt4));

            list1.add(new Triangle(pt6, pt2, pt3));

            list1.add(new Triangle(pt4, pt3, pt6));
            list1.add(new Triangle(pt4, pt5, pt6));

        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_Pignon_1.stl"))) {
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

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_Pignon_2.stl"))) {
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
    public void exporterPignon(List<Vertex> list, List<Triangle> list1) {
        /*
        List<Vertex> pignon = new ArrayList<>();
        pignon.add(new Vertex(list.get(0).x,list.get(0).y,400)); //0
        pignon.add(new Vertex(list.get(26).x,list.get(26).y,400)); //1
        
        
        pignon.add(new Vertex(list.get(0).x,list.get(0).y,300));  //2
        pignon.add(new Vertex(list.get(26).x,list.get(26).y,300));  //3
        
        pignon.add(new Vertex(list.get(31).x,list.get(31).y,300));  //4
        pignon.add(new Vertex(list.get(5).x,list.get(5).y,300));  //5
        
        
        list1.add(new Triangle(pignon.get(0), pignon.get(2), pignon.get(5)));
        list1.add(new Triangle(pignon.get(1), pignon.get(3), pignon.get(4)));
         */

    }

    @Override
    public void exporterDessusToit(List<Vertex> list, List<Triangle> list1) {

    }

    @Override
    public void createSTL(List<Triangle> list1) {

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_F.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 0; i < 12; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("ChalCLT_Brut_F has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the ChalCLT_Brut_F.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_G.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 12; i < 24; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("ChalCLT_Brut_G has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the ChalCLT_Brut_G.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_A.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 24; i < 36; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("ChalCLT_Brut_A has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the ChalCLT_Brut_A.");
            e.printStackTrace();
        }

        try ( PrintWriter out = new PrintWriter(new File("ChalCLT_Brut_D.stl"))) {
            out.println("solid chalet_walls");
            int i;
            for (i = 36; i < 48; i++) {
                out.println(list1.get(i).toStlString());
            }
            out.println("endsolid chalet_walls");
            System.out.println("ChalCLT_Brut_D has been created successfully.");

        } catch (IOException e) {
            System.err.println("An error occurred while writing the ChalCLT_Brut_D.");
            e.printStackTrace();
        }

    }

    @Override
    public void exporterMur(List<Vertex> vertexList, List<Triangle> triangles, double z, List<AccessoiresDTO> accs) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
