package com.example.kidsmulgame.model;

public class Shape {
    private String name;
    private String area;

    private String Circumference;
    private int image;

    public Shape(String name, String area, String circumference, int image) {
        this.name = name;
        this.area = area;
        Circumference = circumference;
        this.image = image;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCircumference() {
        return Circumference;
    }

    public void setCircumference(String circumference) {
        Circumference = circumference;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
