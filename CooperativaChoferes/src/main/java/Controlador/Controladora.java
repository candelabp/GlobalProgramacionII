
package Controlador;

import Modelo.Colectivo;
import Modelo.Socio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Controladora {

    public static List<Socio> traerChoferes() {
        List<Socio> socios = new ArrayList<>();
        String query = "SELECT * FROM socio";

        try (Connection connection = Conexion.conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int legajo = resultSet.getInt("legajo");
                String nombre = resultSet.getString("nombre");
                String colectivoPatente = resultSet.getString("colectivo_patente");
                Colectivo colectivo = colectivoPatente != null ? obtenerColectivoPorPatente(colectivoPatente) : null;

                socios.add(new Socio(legajo, nombre, colectivo));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los socios: " + e.getMessage());
        }
        return socios;
    }

    public static Colectivo obtenerColectivoPorPatente(String patente) {
        Colectivo colectivo = null;
        String query = "SELECT * FROM colectivo WHERE patente = ?";

        try (Connection connection = Conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, patente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int cantPasajeros = resultSet.getInt("cantPasajeros");
                String modelo = resultSet.getString("modelo");
                int kilometraje = resultSet.getInt("kilometraje");
                colectivo = new Colectivo(cantPasajeros, patente, modelo, kilometraje);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el colectivo: " + e.getMessage());
        }
        return colectivo;
    }

    public List<Colectivo> traerColectivos() {
        List<Colectivo> colectivos = new ArrayList<>();
        String query = "SELECT * FROM colectivo";

        try (Connection connection = Conexion.conectar();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String patente = resultSet.getString("patente");
                int cantPasajeros = resultSet.getInt("cantPasajeros");
                String modelo = resultSet.getString("modelo");
                int kilometraje = resultSet.getInt("kilometraje");

                colectivos.add(new Colectivo(cantPasajeros, patente, modelo, kilometraje));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los colectivos: " + e.getMessage());
        }
        return colectivos;
    }

    public static Colectivo obtenerColectivoAdecuado(int cantPasajeros) {
        Colectivo colectivo = null;
        String query = "SELECT * FROM colectivo WHERE cantPasajeros >= ? ORDER BY cantPasajeros ASC LIMIT 1";

        try (Connection connection = Conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, cantPasajeros);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String patente = resultSet.getString("patente");
                int capacidad = resultSet.getInt("cantPasajeros");
                String modelo = resultSet.getString("modelo");
                int kilometraje = resultSet.getInt("kilometraje");
                colectivo = new Colectivo(capacidad, patente, modelo, kilometraje);
            } else {
                System.err.println("No se encontró un colectivo adecuado para " + cantPasajeros + " pasajeros.");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el colectivo adecuado: " + e.getMessage());
        }
        return colectivo;
    }

    public static Socio obtenerSocioPorColectivo(String colectivoPatente) {
        Socio socio = null;
        String query = "SELECT * FROM socio WHERE colectivo_patente = ? LIMIT 1";

        try (Connection connection = Conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, colectivoPatente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int legajo = resultSet.getInt("legajo");
                String nombre = resultSet.getString("nombre");
                Colectivo colectivo = obtenerColectivoPorPatente(colectivoPatente);
                socio = new Socio(legajo, nombre, colectivo);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el socio: " + e.getMessage());
        }
        return socio;
    }

    public static void registrarViaje(int cantKM, int cantPasajeros) {
        try (Connection connection = Conexion.conectar()) {
            Colectivo colectivo = obtenerColectivoAdecuado(cantPasajeros);

            if (colectivo == null) {
                System.err.println("No hay colectivos disponibles para la cantidad de pasajeros especificada.");
                return;
            }

            Socio socio = obtenerSocioPorColectivo(colectivo.getPatente());

            if (socio == null) {
                System.err.println("No hay socios asociados al colectivo seleccionado.");
                return;
            }

            String query = "INSERT INTO viaje (cantKM, cantidadPasajeros, socio_Legajo, patente) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, cantKM);
                statement.setInt(2, cantPasajeros);
                statement.setInt(3, socio.getLegajo());
                statement.setString(4, colectivo.getPatente());
                statement.executeUpdate();
                System.out.println("Viaje registrado exitosamente.");
            }
        } catch (SQLException e) {
            System.err.println("Error al registrar el viaje: " + e.getMessage());
        }
    }

    public void realizarCambio() {
        try (Connection connection = Conexion.conectar()) {
            connection.setAutoCommit(false);

            int[] choferes = obtenerChoferes(connection);
            if (choferes.length == 2) {
                int choferId1 = choferes[0];
                int choferId2 = choferes[1];

                String colectivoId1 = obtenerColectivoPorChofer(connection, choferId1);
                String colectivoId2 = obtenerColectivoPorChofer(connection, choferId2);

                asignarColectivoAChofer(connection, choferId1, colectivoId2);
                asignarColectivoAChofer(connection, choferId2, colectivoId1);

                connection.commit();
                System.out.println("Cambio de colectivos realizado exitosamente.");
            } else {
                connection.rollback();
                throw new SQLException("No se encontraron suficientes choferes para realizar el intercambio.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private int[] obtenerChoferes(Connection connection) throws SQLException {
        String query = "SELECT legajo FROM socio LIMIT 2";
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            int[] choferes = new int[2];
            int index = 0;
            while (rs.next() && index < 2) {
                choferes[index++] = rs.getInt("legajo");
            }
            return choferes;
        }
    }

    private String obtenerColectivoPorChofer(Connection connection, int choferId) throws SQLException {
        String query = "SELECT colectivo_patente FROM socio WHERE legajo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, choferId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("colectivo_patente");
            }
        }
        throw new SQLException("No se encontró el colectivo para el chofer con legajo: " + choferId);
    }

    private void asignarColectivoAChofer(Connection connection, int choferId, String colectivoPatente) throws SQLException {
        String query = "UPDATE socio SET colectivo_patente = ? WHERE legajo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, colectivoPatente);
            stmt.setInt(2, choferId);
            stmt.executeUpdate();
        }
    }

    public List<Integer> traerKm(String patente) throws SQLException {
        List<Integer> kilometrajes = new ArrayList<>();
        String query = "SELECT cantKM FROM viaje WHERE patente = ?";

        try (Connection connection = Conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, patente);
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    kilometrajes.add(rs.getInt("cantKM"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return kilometrajes;
    }

    public int sumarKm(String patente) throws SQLException {
        List<Integer> kilometrajes = traerKm(patente);
        return kilometrajes.stream().mapToInt(Integer::intValue).sum();
    }

    public void actualizarKilometraje(String patente) {
        String query = "UPDATE colectivo SET kilometraje = ? WHERE patente = ?";

        try (Connection connection = Conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            int totalKilometraje = sumarKm(patente);
            statement.setInt(1, totalKilometraje);
            statement.setString(2, patente);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar el kilometraje: " + e.getMessage());
        }
    }

    public String Mayorkm() {
        String mensaje = "No se encontró ningún colectivo.";
        String query = "SELECT * FROM colectivo ORDER BY kilometraje DESC LIMIT 1";

        try (Connection connection = Conexion.conectar();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                String patente = resultSet.getString("patente");
                int cantPasajeros = resultSet.getInt("cantPasajeros");
                String modelo = resultSet.getString("modelo");
                int kilometraje = resultSet.getInt("kilometraje");
                mensaje = "Colectivo con mayor kilometraje encontrado: " + patente + " con " + kilometraje + " km";
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el colectivo con mayor kilometraje: " + e.getMessage());
            mensaje = "Error al obtener el colectivo con mayor kilometraje: " + e.getMessage();
        }
        return mensaje;
    }
}



 










 
    
