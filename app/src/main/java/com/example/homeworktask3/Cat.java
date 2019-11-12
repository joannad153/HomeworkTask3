package com.example.homeworktask3;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cat {

    @PrimaryKey
    @NonNull
    private String id;
    private String name;

    //TODO: find description in api
    private String description;
    private String weight_imperial;
    private String temperament;
    private String origin;
    private String life_span;
    private int dog_friendly;
    private String wikipedia_url;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getWeight_imperial() { return weight_imperial; }

    public void setWeight_imperial(String weight_imperial) { this.weight_imperial = weight_imperial;}

    public String getTemperament() { return temperament; }

    public void setTemperament(String temperament) { this.temperament = temperament; }

    public String getOrigin() { return origin; }

    public void setOrigin(String origin) { this.origin = origin; }

    public String getLife_span() { return life_span; }

    public void setLife_span(String life_span) { this.life_span = life_span; }

    public int getDog_friendly() { return dog_friendly; }

    public void setDog_friendly(int dog_friendly) { this.dog_friendly = dog_friendly; }

    public String getWikipedia_url() { return wikipedia_url; }

    public void setWikipedia_url(String wikipedia_url) { this.wikipedia_url = wikipedia_url; }

}
