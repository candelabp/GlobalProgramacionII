
package com.mycompany.globalprogramacionii.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


  @Entity
public class Viaje implements Serializable {
    //atributos
     @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
     
    private int cantKm;
    private int cantPasajeros;
    
    private Colectivo colectivo;
    private Socio socio;
    //getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantKm() {
        return cantKm;
    }

    public void setCantKm(int cantKm) {
        this.cantKm = cantKm;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    public Colectivo getColectivo() {
        return colectivo;
    }

    public void setColectivo(Colectivo colectivo) {
        this.colectivo = colectivo;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
    
    //constructores

    public Viaje() {
    }
    

    public Viaje(int cantKm, int cantPasajeros, int id, Socio socio, Colectivo colectivo) {
        this.cantKm = cantKm;
        this.cantPasajeros = cantPasajeros;
        this.id = id;
        this.socio= socio;
        this.colectivo = colectivo;
    }
    
}
  