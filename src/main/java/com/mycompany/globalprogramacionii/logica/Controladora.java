/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.globalprogramacionii.logica;


import com.mycompany.globalprogramacionii.persistencia.ControladoraPersistencia;
import java.util.List;

/**
 *
 * @author cande
 */
public class Controladora {


ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void agregarRegistro(int cantKm, int cantPasajeros) {
       Viaje viaje = new Viaje();
       viaje.setCantKm(cantKm);
       
        Colectivo colectivo = new Colectivo();
        colectivo.setId(cantPasajeros > 40 ? 1 : 2);
        viaje.setColectivo(colectivo);

        Socio socio = new Socio();
        if (cantPasajeros > 40) {
            socio.setId(1); // Ajusta el ID y otros atributos según sea necesario
        } else {
            socio.setId(2); // Ajusta el ID y otros atributos según sea necesario
        }
        viaje.setSocio(socio);

       viaje.setCantPasajeros(cantPasajeros);
    controlpersis.agregarRegistro(viaje);
}

    public List<Socio> traerSocios() {
        return controlpersis.traerSocios();
    }

    public List<Colectivo> traerColectivos() {
       return controlpersis.traerColectivos();
   
}
    }