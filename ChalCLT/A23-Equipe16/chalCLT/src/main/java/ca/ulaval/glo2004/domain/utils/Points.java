/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.ulaval.glo2004.domain.utils;

import java.io.Serializable;

/**
 *
 * @author Utilisateur
 */
public class Points implements Serializable {

    public Imperial x;
    public Imperial y;

    public Points(Imperial x, Imperial y) {
        this.x = x;
        this.y = y;

    }

    public Imperial getX() {
        return x;
    }

    public void setX(Imperial x) {
        this.x = x;
    }

    public Imperial getY() {
        return y;
    }

    public void setY(Imperial y) {
        this.y = y;
    }

public static Points fromPixelsToImperial(int pixelX, int pixelY) {
    final double pixelsPerInch = 4.0; // Conversion factor

    Imperial xImperial = convertToImperial(pixelX, pixelsPerInch);
    Imperial yImperial = convertToImperial(pixelY, pixelsPerInch);

    return new Points(xImperial, yImperial);
}

public static Imperial convertToImperial(int pixels, double pixelsPerInch) {
    double totalInches = pixels / pixelsPerInch;

    int feet = (int) totalInches / 12;
    int inches = (int) totalInches % 12;
    double fractionalPart = totalInches - (feet * 12) - inches;

    return new Imperial(feet, inches, fractionalPart);
}









}
