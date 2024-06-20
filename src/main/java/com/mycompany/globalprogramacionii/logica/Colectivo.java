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
    public class Colectivo implements Serializable {
    //atributos
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private int cantPasajeros;
    private String patente;
    private String modelo;
    private Socio chofer;
    //getters y setters

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Socio getChofer() {
        return chofer;
    }

    public void setChofer(Socio chofer) {
        this.chofer = chofer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    //constructores

    public Colectivo() {
    }

    public Colectivo(int cantPasajeros, String patente, String modelo, Socio chofer, int id) {
        this.cantPasajeros = cantPasajeros;
        this.patente = patente;
        this.modelo = modelo;
        this.chofer = chofer;
        this.id= id;
    }
    
}

