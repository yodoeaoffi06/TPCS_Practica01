package org.uv.tpcs_practica01;

public class TPCS_Practica01 {

    public static void main(String[] args) {
        DAOEmpleado dao = new DAOEmpleado();
        
        Empleado em = new Empleado();
        em.setNombre("Ejemplo9");
        em.setDireccion("Direccion 9");
        em.setTelefono("9999");
        
//        dao.save(emp);
        
        LDAOEmpleado emp = new LDAOEmpleado();
        
        emp.saveEmpleado(em);
    }
}
