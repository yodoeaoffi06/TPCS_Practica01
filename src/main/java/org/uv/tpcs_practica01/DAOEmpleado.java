package org.uv.tpcs_practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yadhir Teoba
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Integer>{

    @Override
    public Empleado save(Empleado pojo) {
        TransanctionDB t = new TransanctionDB<Empleado>(pojo) {
            @Override
            public boolean execute(Connection con) {
                try {
                    String sql = "INSERT INTO empleado (clave, nombre, direccion, telefono) VALUES (?, ?, ?, ?)";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setInt(1, p.getClave());
                    pstm.setString(2, p.getNombre());
                    pstm.setString(3, p.getDireccion());
                    pstm.setString(4, p.getTelefono());
                    pstm.execute();
                    
                    return true;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    
                    return false;
                }
            }
        };
        
        Conexion con = Conexion.getInstance();
        con.execute(t);
        
        return pojo;
    }
            
    @Override
    public Empleado update(Empleado pojo, Integer clave) {
        return null;
    }

    @Override
    public boolean delete(Integer clave) {
        return true;
    }

    @Override
    public Empleado findById(Integer id) {
        
        return null;
    }

    @Override
    public List<Empleado> findAll() {
        return null;
    }
    
}
