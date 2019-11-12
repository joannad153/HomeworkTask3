package com.example.homeworktask3;

import java.util.ArrayList;

public class SearchResponse {
    public String id;
    public String name;
    public String description;
    public String weight_imperial;
    public String temperament;
    public String origin;
    public String life_span;
    public int dog_friendly;
    public String wikipedia_url;
    public ArrayList<Cat> results;

    public String getId() { return id; }

    public String getDescription() { return description; }

    public String getWeight_imperial() {
        return weight_imperial;
    }

    public String getName() {
        return name;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLife_span() {
        return life_span;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public ArrayList<Cat> getResults() {
        return results;
    }
}

