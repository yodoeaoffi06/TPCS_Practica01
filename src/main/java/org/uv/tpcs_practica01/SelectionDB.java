package org.uv.tpcs_practica01;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Yadhir Teoba
 */
public abstract class SelectionDB<T> {
    protected T p;
    
    SelectionDB(T p){
        this.p = p;
    }
    
    public abstract List<T> select(Connection con);
}
