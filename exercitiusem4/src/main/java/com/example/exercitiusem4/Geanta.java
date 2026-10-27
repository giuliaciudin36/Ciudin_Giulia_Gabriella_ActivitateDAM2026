package com.example.exercitiusem4;

import java.io.Serializable;

public class Geanta implements Serializable {
    private String brand; //edittext
    private boolean esteNoua; //switch
    private boolean areGarantie; //checkbox
    private String marime; //radiobutton
    private String material; //spinner
    private float rating; //ratingbar

    public Geanta(String brand, boolean esteNoua, boolean areGarantie, String marime, String material, float rating) {
        this.brand = brand;
        this.esteNoua = esteNoua;
        this.areGarantie = areGarantie;
        this.marime = marime;
        this.material = material;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Geanta{" +
                "brand='" + brand + '\'' +
                ", esteNoua=" + esteNoua +
                ", areGarantie=" + areGarantie +
                ", marime='" + marime + '\'' +
                ", material='" + material + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isEsteNoua() {
        return esteNoua;
    }

    public void setEsteNoua(boolean esteNoua) {
        this.esteNoua = esteNoua;
    }

    public boolean isAreGarantie() {
        return areGarantie;
    }

    public void setAreGarantie(boolean areGarantie) {
        this.areGarantie = areGarantie;
    }

    public String getMarime() {
        return marime;
    }

    public void setMarime(String marime) {
        this.marime = marime;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


}
