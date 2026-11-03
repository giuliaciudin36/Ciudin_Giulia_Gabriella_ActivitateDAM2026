package com.example.exercitiusem4;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Geanta implements Parcelable {
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

    protected Geanta(Parcel in) {
        brand = in.readString();
        esteNoua = in.readByte() != 0;
        areGarantie = in.readByte() != 0;
        marime = in.readString();
        material = in.readString();
        rating = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(brand);
        dest.writeByte((byte) (esteNoua ? 1 : 0));
        dest.writeByte((byte) (areGarantie ? 1 : 0));
        dest.writeString(marime);
        dest.writeString(material);
        dest.writeFloat(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Geanta> CREATOR = new Creator<Geanta>() {
        @Override
        public Geanta createFromParcel(Parcel in) {
            return new Geanta(in);
        }

        @Override
        public Geanta[] newArray(int size) {
            return new Geanta[size];
        }
    };

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
