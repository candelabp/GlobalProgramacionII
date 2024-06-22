
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Socio {
    private int legajo;
    private String nombre;
    private List<Viaje> viajes;
    private Colectivo conduce;

    public Socio() {
        this.viajes = new ArrayList<>();
    }

    public Socio(int legajo, String nombre, Colectivo colectivo) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.conduce = colectivo;
        this.viajes = new ArrayList<>();
    }

    public Socio(int aInt, String string) {
    }

    // Getters y setters
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

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }

    public Colectivo getColectivo() {
        return conduce;
    }

    public void setColectivo(Colectivo colectivo) {
        this.conduce = colectivo;
    }

    // Métodos
    public void realizarViaje(int cantKM, int cantidadPasajeros) {
        Viaje viaje = new Viaje(cantKM, cantidadPasajeros);
        viajes.add(viaje);
        conduce.registrarKilometraje(cantKM);
    }

    public void realizarIntercambio(Socio otroSocio) {
        Colectivo temp = this.conduce;
        this.conduce = otroSocio.conduce;
        otroSocio.conduce = temp;
    }

    public String mayorKilometraje() {
        return conduce.getPatente();
    }

    public int getTotalKilometraje() {
        return conduce.getKilometraje();
    }
}
