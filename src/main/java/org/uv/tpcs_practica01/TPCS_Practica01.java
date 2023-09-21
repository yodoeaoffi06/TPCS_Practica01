package org.uv.tpcs_practica01;

public class TPCS_Practica01 {

    public static void main(String[] args) {
//        DAOEmpleado dao = new DAOEmpleado();
//        
//        Empleado emp = new Empleado();
//        emp.setNombre("Ejemplo4");
//        emp.setDireccion("Direccion 4");
//        emp.setTelefono("4444444444");
//        
//        dao.save(emp);
        
        LDAOEmpleado emp = new LDAOEmpleado();
        
        emp.findEmpleadoById(1);
    }
}
