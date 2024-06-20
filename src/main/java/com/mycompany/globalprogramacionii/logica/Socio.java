/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.globalprogramacionii.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author cande
 */
@Entity
public class Socio implements Serializable {
    //atributos
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private int legajo;
    private String nombre;
    private Colectivo conduce;
     //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Colectivo getConduce() {
        return conduce;
    }

    public void setConduce(Colectivo conduce) {
        this.conduce = conduce;
    }
    //constructores

    public Socio() {
    }

    public Socio(int legajo, String nombre, Colectivo conduce, int id) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.conduce = conduce;
        this.id = id;
    }
  
}

