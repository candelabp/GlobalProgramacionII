package Controlador;

import Vista.Principal;




public class CooperativaChoferes {

    public static void main(String[] args) {
        Controladora control1 = new Controladora();
        Controladora control2 = new Controladora();
       try{
           Class.forName(Conexion.DRIVER);
           Conexion.crearBaseDatos();
            if (!Conexion.verificarExistenRegistros()) {
                Conexion.agregarDatos();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
      Principal principal = new Principal();
    principal.setVisible(true);
    principal.setLocationRelativeTo(null);

    control1.actualizarKilometraje("AB123");
    control2.actualizarKilometraje("BZ678");
       }
    
    }
