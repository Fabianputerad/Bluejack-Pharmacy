package com.example.projectasg;

import java.io.Serializable;

public class Medicine implements Serializable {
    private String name, manu,price;
    private int image;

    public Medicine(String name, String manu, String price /*int image*/) {
        this.name = name;
        this.manu = manu;
       // this.image = image;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
