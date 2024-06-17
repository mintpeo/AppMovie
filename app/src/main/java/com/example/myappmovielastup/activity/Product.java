package com.example.myappmovielastup.activity;

public class Product {

    private String productName;
    private String productType;
    private int imageResource;

    public Product(String productName, String productType, int imageResource) {
        this.productName = productName;
        this.productType = productType;
        this.imageResource = imageResource;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public int getImageResource() {
        return imageResource;
    }
}