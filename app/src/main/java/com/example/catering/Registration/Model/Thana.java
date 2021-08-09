package com.example.catering.Registration.Model;

/**
 * Created By Md.Harun or rashid on 3 th, aug,2021
 * MOBILE : 01531946638
 * UNiVERSITY : EWU (CSE)
 **/
public class Thana {
    int id;
    String name;
    String is_updated;

    public Thana(int id, String name, String is_updated) {
        this.id = id;
        this.name = name;
        this.is_updated = is_updated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIs_updated() {
        return is_updated;
    }

    public void setIs_updated(String is_updated) {
        this.is_updated = is_updated;
    }
}
