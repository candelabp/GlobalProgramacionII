
package Controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    static final String URL = "jdbc:h2:tcp://localhost/~/OneDrive\\Documentos\\BaseDeDatos/test";
    static final String USER = "Candela";
    static final String PASSWORD = "123";
    static final String DRIVER = "org.h2.Driver";
    
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void crearBaseDatos() {
        try (Connection connection = conectar();
             Statement statement = connection.createStatement()) {
             
            // Crear la tabla colectivos
            String crearTablaMicros = "CREATE TABLE IF NOT EXISTS colectivo ("
                    + "patente VARCHAR(255) PRIMARY KEY, "
                    + "cantPasajeros INT, "
                    + "modelo VARCHAR(255), "
                    + "kilometraje INT)";
            statement.executeUpdate(crearTablaMicros);
        
            // Crear la tabla socios
            String crearTablaChoferes = "CREATE TABLE IF NOT EXISTS socio ("
                    + "legajo INT PRIMARY KEY, "
                    + "nombre VARCHAR(255), "
                    + "colectivo_patente VARCHAR(255), "
                    + "FOREIGN KEY (colectivo_patente) REFERENCES colectivo(patente))";
            statement.executeUpdate(crearTablaChoferes);

            // Crear la tabla viajes
            String crearTablaViajes = "CREATE TABLE IF NOT EXISTS viaje ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "cantKM INT, "
                    + "cantidadPasajeros INT, "
                    + "socio_legajo INT, "
                    + "patente VARCHAR(255)," 
                    + "FOREIGN KEY (socio_legajo) REFERENCES socio(legajo),"
                    + "FOREIGN KEY (patente) REFERENCES colectivo(patente))";
            statement.executeUpdate(crearTablaViajes);

            System.out.println("Tablas creadas exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al crear la base de datos: " + e.getMessage());
        }
    }
    
    public static void agregarDatos() {
        try (Connection connection = conectar();
             Statement statement = connection.createStatement()) {
             
            // Insertar datos en la tabla colectivo
            String insertarMicros = "INSERT INTO colectivo (patente, cantPasajeros, modelo, kilometraje) VALUES "
                    + "('AB123', 80, 'Mercedez Benz', 0), "
                    + "('BZ678', 40, 'Iveco Daily', 0)";
            statement.executeUpdate(insertarMicros);
            
            // Insertar datos en la tabla socio
            String insertarChoferes = "INSERT INTO socio (legajo, nombre, colectivo_patente) VALUES "
                    + "(45207, 'Candela Puerta', 'AB123'), "
                    + "(59804, 'Benjamin Buchaillot', 'BZ678')";
            statement.executeUpdate(insertarChoferes);

            System.out.println("Datos insertados exitosamente");
        } catch (SQLException e) {
            System.err.println("Error al insertar los datos: " + e.getMessage());
        }
    }
  public static boolean verificarExistenRegistros() {
        try (Connection connection = conectar();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM colectivo")) {

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
         }
        
