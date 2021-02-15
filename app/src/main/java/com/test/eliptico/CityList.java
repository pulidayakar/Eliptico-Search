package com.test.eliptico;

import java.util.List;

public class CityList {
    private String type;
    private String[] query;
    private List<FeaturedList> features;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getQuery() {
        return query;
    }

    public void setQuery(String[] query) {
        this.query = query;
    }

    public List<FeaturedList> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeaturedList> features) {
        this.features = features;
    }
}
