package org.uv.tpcs_practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yadhir Teoba
 */
public class Conexion {
    private final String bd = "practica01"; 
    private final String url = "jdbc:mysql://localhost:3306/";
    private final String user = "root";
    private final String password = System.getProperty("database.password");
    private final String driver = "com.mysql.cj.jdbc.Driver";
    
    private Connection con = null;
    private static Conexion ins = null;
    
    private Conexion() {
        try {
            Class.forName(driver);
            
            con = DriverManager.getConnection(url + bd, user, password);
            
            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, "SE HA ESTABLECIOD CONEXIÓN CON LA BASE DE DATOS {0}.", bd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "NO SE PUDO ESTABLECER LA CONEXIÓN CON LA BASE DE DATOS.", ex);
        }
    }
    
    public static synchronized Conexion getInstance() {
        if (ins == null) {
            ins = new Conexion();
        }
        return ins;
    }
    
    public boolean execute(TransanctionDB t) {
        return t.execute(con);
    }
    
    public List select(SelectionDB sel) {
        return sel.select(con);
    }
    
    public void close() {
        try {
            con.close();
            
            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, "CONEXIÓN CERRADA!");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
