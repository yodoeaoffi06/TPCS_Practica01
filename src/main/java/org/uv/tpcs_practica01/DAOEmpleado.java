package org.uv.tpcs_practica01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
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
    public Empleado update (Empleado pojo, Integer clave){
        TransanctionDB t = new TransanctionDB<Empleado>(pojo){
            @Override
            public boolean execute (Connection con){
                try {
                    String sql = "UPDATE empleados SET nombre = ?, direccion = ?, telefono = ? WHERE clave = ?";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setString(1, p.getNombre());
                    pstm.setString(2, p.getDireccion());
                    pstm.setString(3, p.getTelefono());
                    pstm.setInt(4, clave);
                    pstm.execute();
                    
                    return true;
                } catch (SQLException ex){
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }
        };
        Conexion con = Conexion.getInstance();
        boolean res = con.execute(t);
        return pojo;
    }

    @Override
     public boolean delete (Integer clave){
        TransanctionDB t = new TransanctionDB<Integer>(clave){
            @Override
            public boolean execute (Connection con){
                try{
                    String sql = "DELETE FROM empleados WHERE clave =?";
                    PreparedStatement pstm = con.prepareStatement(sql);
                    pstm.setInt(1, p);
                    pstm.execute();
                    return true;
                }catch (SQLException ex){
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return true;
                }
            }
        };
        Conexion con = Conexion.getInstance();
        boolean res = con.execute(t);
        return true;
    }

    @Override
    public Empleado findById(Integer id) {
        SelectionDB sel = new SelectionDB(null){
            @Override
            public List<Empleado> select(Connection con) {
                try {
                    List<Empleado> listEmpleados = new ArrayList<>();
                    String sql = "SELECT * FROM empleados WHERE clave = ?";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setInt(1, id);
                    ResultSet reg = pstmt.executeQuery();
                    
                    while (reg.next()) {
                        Empleado emp = new Empleado();
                        emp.setClave(reg.getInt(1));
                        emp.setNombre(reg.getString(2));
                        emp.setDireccion(reg.getString(3));
                        emp.setTelefono(reg.getString(4));
                        listEmpleados.add(emp);
                    }
                    return listEmpleados;
                } catch (SQLException ex) {
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
        };
        Conexion con = Conexion.getInstance();
        List<Empleado> empleadosEncontrados = con.select(sel);
        
        if (empleadosEncontrados != null && !empleadosEncontrados.isEmpty()) {
            return empleadosEncontrados.get(0);
        } else {
             return null;
        }
    }

    @Override
    public List<Empleado> findAll(){
        SelectionDB sel = new SelectionDB(null) {
            @Override
            public List select (Connection con) {
                try {
                    List<Empleado> listEmpleados = new ArrayList<>();
                    String sql = "SELECT * FROM empleados";
                    Statement st = null;
                    ResultSet reg = null;
                    st = con.createStatement();
                    reg = st.executeQuery(sql);
                
                    while (reg.next()){
                        Empleado emp = new Empleado();
                        emp.setClave(reg.getInt(1));
                        emp.setNombre(reg.getString(2));
                        emp.setDireccion(reg.getString(3));
                        emp.setTelefono(reg.getString(4));
                        listEmpleados.add(emp);
                    }
                    return listEmpleados;
                }catch (SQLException ex){
                    Logger.getLogger(DAOEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
        };
        Conexion con = Conexion.getInstance();
        return con.select(sel);
    }
    
}
