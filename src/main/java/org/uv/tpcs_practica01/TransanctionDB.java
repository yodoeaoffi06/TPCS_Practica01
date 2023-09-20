package org.uv.tpcs_practica01;

import java.sql.Connection;

/**
 *
 * @author Yadhir Teoba
 */
public abstract class TransanctionDB <T>{
    protected T p;
            
    TransanctionDB(T p) {
        this.p = p;
    }

    public TransanctionDB() {
        
    }
    
    
    public abstract boolean execute(Connection con);
}
