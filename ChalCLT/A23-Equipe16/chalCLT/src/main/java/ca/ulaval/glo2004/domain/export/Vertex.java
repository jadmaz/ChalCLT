/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.export;

/**
 *
 * @author 14189
 */
class Vertex {

    public double x, y, z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toStlString() {
        return String.format("vertex %.6f %.6f %.6f", x, y, z);
    }

    @Override
    public String toString() {
        return "Vertex{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    public static Vertex subtract(Vertex v1, Vertex v2) {
        return new Vertex(v2.x - v1.x, v2.y - v1.y, v2.z - v1.z);
    }

    public static Vertex crossProduct(Vertex v1, Vertex v2) {
        return new Vertex(v1.y * v2.z - v1.z * v2.y,
                v1.z * v2.x - v1.x * v2.z,
                v1.x * v2.y - v1.y * v2.x);
    }

    public double norm() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vertex normalize() {
        double norm = this.norm();
        return new Vertex(x / norm, y / norm, z / norm);
    }
}
