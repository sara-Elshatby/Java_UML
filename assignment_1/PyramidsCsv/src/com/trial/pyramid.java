package com.trial;

public class pyramid {


    String Pharaoh;
    String Site;
    String ModernName;
    double Height;

    public pyramid(String pharaoh, String modernName, String site, double height) {
        this.Pharaoh = pharaoh;
        this.ModernName = modernName;
        this.Site = site;
        this.Height = height;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public String getPharaoh() {
        return Pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        Pharaoh = pharaoh;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        Site = site;
    }

    public String getModernName() {
        return ModernName;
    }

    public void setModernName(String modernName) {
        ModernName = modernName;
    }

    @Override
    public String toString() {
        return "pyramid{" +
                "Height=" + Height +
                ", Pharaoh='" + Pharaoh + '\'' +
                ", Site='" + Site + '\'' +
                ", ModernName='" + ModernName + '\'' +
                '}';
    }
}