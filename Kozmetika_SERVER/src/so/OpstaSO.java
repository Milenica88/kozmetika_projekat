/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import db.DBBroker;
import domen.OpstiDomenskiObjekat;
import java.sql.SQLException;

/**
 *
 * @author Milena
 */
public abstract class OpstaSO {
    
    protected abstract void validate(OpstiDomenskiObjekat ado) throws Exception;
    protected abstract void execute(OpstiDomenskiObjekat ado) throws Exception;

    public void templateExecute(OpstiDomenskiObjekat ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
