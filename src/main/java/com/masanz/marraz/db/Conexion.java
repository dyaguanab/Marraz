package com.masanz.marraz.db;

import com.masanz.marraz.io.Archivo;

import java.sql.*;

import static com.masanz.marraz.consts.Consts.DB_PATH;
import static com.masanz.marraz.consts.Consts.DB_URL_SQLITE;

public class Conexion {
    private Connection conexion;
    private String dbPath = DB_PATH;
    private static Conexion instancia;

    /**
     * Constructor privado
     */
    private Conexion() {
    }

    /**
     *
     * @return la instancia con la conexión
     */
    public static Conexion getConexion(){
    if (instancia== null){
        instancia = new Conexion();
    }
    return instancia;
    }

    /**
     * Se establece el valor del path
     * @param dbPath
     */
    public void setDbPath(String dbPath){
        this.dbPath = dbPath;
    }

    /**
     * Metodo que sirve para verificar si está conectado el path, en caso de que no, se crea la conexión
     * @return
     */
    public boolean conectar(){
        if (!Archivo.existe(dbPath)){
            return false;
        }
        try {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(String.format(DB_URL_SQLITE, dbPath));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return false;
    }

    /**
     * Método para cerrar la conexión
     * @return
     */
    public boolean cerrarConexion(){
        try {
            this.conexion.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión");
        }
        return false;
    }

    /**
     * Se guarda la figura creada en la base de datos
     * @param nombre
     * @param figura
     * @return
     */
    public boolean guardarFigura(String nombre, String figura){
        try {
            PreparedStatement ps =conexion.prepareStatement("INSERT INTO Dibujos (Nombre, Figuras)VALUES (?,?)");
            ps.setString(1, nombre);
            ps.setString(2, figura);
            if (ps.executeUpdate()==1){
                return true;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Se carga la figura creada en la base de datos
     * @param nombre
     * @return
     */
    public String cargarFigura(String nombre){
        try {
            PreparedStatement ps =conexion.prepareStatement("SELECT Figuras FROM Dibujos WHERE Nombre=?");
            ps.setString(1, nombre);
            ResultSet rs =ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
