
package Modelo;

public class Viaje {
    private int cantKM;
    private int cantPasajeros;

    public int getCantKM() {
        return cantKM;
    }

    public void setCantKM(int cantKM) {
        this.cantKM = cantKM;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }
    
    //constructores

    public Viaje() {
    }

    public Viaje(int cantKM, int cantPasajeros) {
        this.cantKM = cantKM;
        this.cantPasajeros = cantPasajeros;
    }
    
}
