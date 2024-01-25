/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.export;

import ca.ulaval.glo2004.domain.*;
import ca.ulaval.glo2004.domain.DTO.AccessoiresDTO;
import ca.ulaval.glo2004.domain.utils.Imperial;
import ca.ulaval.glo2004.domain.utils.Points;
import ca.ulaval.glo2004.gui.TypeExport;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author 14189
 */
public abstract class ExportSTL {
    private Chalet chalet;
    private TypeExport type;
    String path;
    public List<Vertex> vertexList = new ArrayList<>();

    public ExportSTL(String path) {
        
        this.path = path;

    }
    
   
    public abstract void exporterMur(List<Vertex> vertexList, List<Triangle> triangles, double z, List<AccessoiresDTO> accs);
    
    public abstract void exporterRallongeToit(List<Vertex> vertexList, List<Triangle> triangles);
    
    public abstract void exporterPignon(List<Vertex> vertexList, List<Triangle> triangles);
    
    public abstract void exporterDessusToit(List<Vertex> vertexList, List<Triangle> triangles);
    
    public abstract void createSTL(List<Triangle> triangles);

    
    public void getChaletCord(Chalet c) {
        List<Murs> murs = new ArrayList<>();
        List<Vertex> vertexList = new ArrayList<>();
        if (c.getListmurs() != null) {
            murs = c.getListmurs();
        } else {
            throw new RuntimeException("The list of murs is null.");
        }
        for (Murs mur : murs) {
            List<Points> pointsMur = mur.getPointsVueDessus();

            for (int i = 0; i < pointsMur.size(); i++) {
                int x = pointsMur.get(i).getX().toPixel();
                int y = pointsMur.get(i).getY().toPixel();

                Vertex point = new Vertex(x, y, 0);

                vertexList.add(point);
            }
        }

        Collections.sort(vertexList, new Comparator<Vertex>() {
            @Override
            public int compare(Vertex v1, Vertex v2) {
                int result = Double.compare(v1.x, v2.x);
                if (result == 0) { // Si les x sont égaux, on compare les y
                    result = Double.compare(v1.y, v2.y);
                }
                return result;
            }
        });

        this.vertexList = vertexList;

    }


    public void generateSTL(Chalet c,Controleur controller) {
        List<Triangle> triangles = new ArrayList<>();
        List<Triangle> triangles1 = new ArrayList<>();
        List<Triangle> triangles2 = new ArrayList<>();
        List<Triangle> trianglesrallonge = new ArrayList<>();
        List<Triangle> trianglespignon = new ArrayList<>();
        this.getChaletCord(c);
        
        double z = c.getDimensions().getHauteur().toPixel();
        List<AccessoiresDTO> accs = controller.getAccList();
       
        //export brut ChalCLT_Brut et ChalCLT_Brut_X
        ExportBrut export = new ExportBrut("");
        
        export.exporterMur(controller, vertexList, triangles,z,accs);
        export.createSTL( triangles);
        export.exporterRallongeToit(controller, vertexList, trianglesrallonge, z);
        export.exporterPignon(controller, vertexList, trianglespignon, z); ;
        //export retrait ChalCLT_Retrait_X_Y
        ExportRetrait export1 = new ExportRetrait("");
        export1.exporterMur(vertexList, triangles1,z,accs);
        export1.createSTL(triangles1);
        
        export1.createSTL1(vertexList,triangles1,accs);
        
        //export fini CHalCLT_Fini_X
        List<Triangle> trianglefini_m1 = new ArrayList<>();
        List<Triangle> trianglefini_m2 = new ArrayList<>();
        List<Triangle> trianglefini_m3 = new ArrayList<>();
        List<Triangle> trianglefini_m4 = new ArrayList<>();
        List<Triangle> trianglefini_r1 = new ArrayList<>();
        List<Triangle> trianglefini_p1 = new ArrayList<>();
        List<Triangle> trianglefini_d = new ArrayList<>();
        ExportFini export2 = new ExportFini("");
        
        export2.exporterMur(controller,vertexList, triangles2,z,accs,trianglefini_m1,trianglefini_m2,trianglefini_m3,trianglefini_m4);
        export2.exporterRallongeToit(controller, vertexList, trianglefini_r1);
        export2.exporterPignon(controller, vertexList, trianglefini_p1);
        export2.exporterDessusToit(controller, vertexList, trianglefini_d);
        export2.createSTL1(vertexList,triangles2,accs,z,trianglefini_m1,trianglefini_m2,trianglefini_m3,trianglefini_m4);
    }

}
