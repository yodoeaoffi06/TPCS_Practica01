package org.uv.tpcs_practica01;

import java.util.List;

/**
 *
 * @author Asus
 */
public class LDAOEmpleado {

    private final DAOEmpleado daoEmpleado;

    public LDAOEmpleado() {
        daoEmpleado = new DAOEmpleado();
    }

    public Empleado saveEmpleado(Empleado empleado) {
        return daoEmpleado.save(empleado);
    }

    public Empleado updateEmpleado(Empleado empleado, Integer clave) {
        return daoEmpleado.update(empleado, clave);
    }

    public boolean deleteEmpleado(Integer clave) {
        return daoEmpleado.delete(clave);
    }

    public Empleado findEmpleadoById(Integer id) {
        return daoEmpleado.findById(id);
    }

    public List<Empleado> findAllEmpleados() {
        return daoEmpleado.findAll();
    }
}
