package org.uv.tpcs_practica01;

/**
 *
 * @author Yadhir Teoba
 */
public class Empleado {
    
    //Attributes
   private int clave;
   private String nombre;
   private String direccion;
   private String telefono;
   
    //Getters and Setters
   public int getClave() {
        return clave;
    }
   
    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
