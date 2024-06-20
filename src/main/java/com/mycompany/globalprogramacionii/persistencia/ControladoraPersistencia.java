/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.globalprogramacionii.persistencia;


import com.mycompany.globalprogramacionii.logica.Colectivo;
import com.mycompany.globalprogramacionii.logica.Socio;
import com.mycompany.globalprogramacionii.logica.Viaje;
import java.util.List;

/**
 *
 * @author cande
 */
public class ControladoraPersistencia {
ViajeJpaController viajeJpa = new ViajeJpaController();
    public void agregarRegistro(Viaje viaje) {
        viajeJpa.create(viaje);
}
SocioJpaController socioJpa = new SocioJpaController();
    public List<Socio> traerSocios() {
      return socioJpa.findSocioEntities();
    }
ColectivoJpaController colectivoJpa = new ColectivoJpaController();
    public List<Colectivo> traerColectivos() {
       return colectivoJpa.findColectivoEntities();
    }

    }
