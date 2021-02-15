package com.test.eliptico;

public class FeaturedList {
    private String[] place_type;
    private String place_name;
    private double[] center;

    public String[] getPlace_type() {
        return place_type;
    }

    public void setPlace_type(String[] place_type) {
        this.place_type = place_type;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public double[] getCenter() {
        return center;
    }

    public void setCenter(double[] center) {
        this.center = center;
    }
}
