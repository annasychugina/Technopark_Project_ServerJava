/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.anna.models;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class Attraction implements Serializable {

    private long id;
    private String name;
    private String note;

    public Attraction(long id, String name, String note) {
        this.id = id;
        this.name = name;
        this.note = note;
    }

    public Attraction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
