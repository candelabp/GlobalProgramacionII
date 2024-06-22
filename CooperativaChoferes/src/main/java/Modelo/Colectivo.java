
package Modelo;


public class Colectivo {
  private int cantPasajeros;
private String patente;
private String modelo;
private int kilometraje;
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

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
    }



//constructores
    public Colectivo(int cantPasajeros, String patente, String modelo, int kilometraje) {
        this.cantPasajeros = cantPasajeros;
        this.patente = patente;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
    }
    public Colectivo(){
        
    }
    //metodos
     public void registrarKilometraje(int cantKm) {
        this.kilometraje += cantKm;
    }

}
