package org.uv.tpcs_practica01;

import java.util.List;

/**
 *
 * @author Yadhir Teoba
 * @param <T>
 * @param <I>
 */
public interface IDAOGeneral <T, I>{
    public T save(T pojo);
    public T update(T pojo, I clave);
    public boolean delete(I clave);
    public T findById(I id);
    public List<T> findAll();
}
