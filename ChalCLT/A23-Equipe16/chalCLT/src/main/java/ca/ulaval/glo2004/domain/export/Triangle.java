/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.export;

/**
 *
 * @author 14189
 */
class Triangle {

    public Vertex v1, v2, v3, normal;

    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        calculateNormal();
    }

    public void calculateNormal() {
        Vertex vec1 = Vertex.subtract(v2, v1);
        Vertex vec2 = Vertex.subtract(v3, v1);
        normal = Vertex.crossProduct(vec1, vec2).normalize();
    }

    public String toStlString() {
        return String.format("facet normal %.6f %.6f %.6f\n  outer loop\n    %s\n    %s\n    %s\n  endloop\nendfacet",
                normal.x, normal.y, normal.z, v1.toStlString(), v2.toStlString(), v3.toStlString());
    }
}
