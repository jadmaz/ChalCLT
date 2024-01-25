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
public class Imperial implements Serializable{
    private int pieds;
    private int pouces;
    private double fraction;
    
    public Imperial(int pieds, int pouces, double fraction) {
        this.pieds = pieds;
        this.pouces = pouces;
        this.fraction = fraction;

    }
    
    public int getPieds() {
        return pieds;
    }

    public int getPouces() {
        return pouces;
    }

    public double getFraction() {
        return fraction;
    }



    public void setPieds(int pieds) {
        this.pieds = pieds;
    }

    public void setPouces(int pouces) {
        this.pouces = pouces;
    }

    public void setFraction(double fraction) {
        this.fraction = fraction;
    }

    
    public Imperial addition(Imperial autreImperial) {
        int totalInches = this.pouces + autreImperial.pouces;
        double totalFraction = this.fraction + autreImperial.fraction;

        if (totalFraction >= 1) {
            totalFraction -= 1;
            totalInches += 1;
        }

        int additionalFeet = totalInches / 12;
        totalInches %= 12;

        int totalPieds = this.pieds + autreImperial.pieds + additionalFeet;

        return new Imperial(totalPieds, totalInches, totalFraction);
    }

    public Imperial soustraction(Imperial autreImperial) {
        int totalInches = this.pouces - autreImperial.pouces;
        double totalFraction = this.fraction - autreImperial.fraction;

        while (totalFraction < 0) {
            totalFraction += 1;
            totalInches -= 1;
        }

        int totalPieds = this.pieds - autreImperial.pieds;
        while (totalInches < 0) {
            totalInches += 12;
            totalPieds -= 1;
        }

        return new Imperial(totalPieds, totalInches, totalFraction);
    }

    public Imperial division() {
        double imperial_1 = this.pieds * 12 + this.pouces + this.fraction;
        double total = imperial_1 / 2;

        int totalPieds = (int) (total / 12);
        double restePouces = total % 12;
        double resteFraction = (restePouces - (int) restePouces);

        return new Imperial(totalPieds, (int)restePouces, resteFraction);
    }
    
    public int toPixel ()
    {
        double pouces_total = getPieds() * 12 + getPouces() + getFraction();
        double pixel = pouces_total * 4;
        return (int) Math.round(pixel);
    }
    
    public static Imperial fromString(String imperialString) {
    int feet = 0;
    int inches = 0;
    double fraction = 0.0;
 
    
    String[] parts = imperialString.split("\\s+");
 
    
    if (parts.length > 0 && parts[0].endsWith("'")) {
        feet = Integer.parseInt(parts[0].substring(0, parts[0].length() - 1));
    }
 
    
    if (parts.length > 1 && parts[1].endsWith("\"")) {
        inches = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
    }
 
    
    if (parts.length > 2 && parts[2].contains("/")) {
        String[] fractionParts = parts[2].split("/");
        fraction = Double.parseDouble(fractionParts[0]) / Double.parseDouble(fractionParts[1]);
    }
 
    return new Imperial(feet, inches, fraction);
}
    
    
    
    public static String toString(Imperial imperial)
    {
    int feet = imperial.getPieds();
    int inches = imperial.getPouces();
    double fraction = imperial.getFraction();

    String feetString = Integer.toString(feet);
    String inchesString = Integer.toString(inches);
    String fractionString = convertFractionToString(fraction);

    return feetString + "' " + inchesString + "\" " + fractionString;
    }
    
    
private static String convertFractionToString(double fraction) {
    if (fraction == 0) {
        return "";
    }

    // Set the maximum denominator
    final int maxDenominator = 164;
    
    int bestNumerator = 1;
    int bestDenominator = maxDenominator;
    double bestError = Math.abs(fraction - (double) bestNumerator / bestDenominator);

    // Iterate through possible denominators
    for (int denominator = 1; denominator <= maxDenominator; denominator++) {
        int numerator = (int) Math.round(fraction * denominator);
        double error = Math.abs(fraction - (double) numerator / denominator);

        if (error < bestError) {
            bestNumerator = numerator;
            bestDenominator = denominator;
            bestError = error;
        }
    }

    // Simplify the fraction
    int gcd = greatestCommonDivisor(bestNumerator, bestDenominator);
    bestNumerator /= gcd;
    bestDenominator /= gcd;

    if (bestDenominator == 1) { // This means the fraction is actually a whole number
        return "";
    }

    return bestNumerator + "/" + bestDenominator;
}

private static int greatestCommonDivisor(int a, int b) {
    while (b != 0) {
        int t = b;
        b = a % b;
        a = t;
    }
    return a;
}

public static Imperial fromPixel(int pixelValue) {
    double pouces_total = pixelValue / 4.0; // Conversion de pixels en pouces
    int pieds = (int) (pouces_total / 12);
    int pouces = (int) (pouces_total % 12);
    double fraction = pouces_total - pieds * 12 - pouces;

    return new Imperial(pieds, pouces, fraction);
}

}