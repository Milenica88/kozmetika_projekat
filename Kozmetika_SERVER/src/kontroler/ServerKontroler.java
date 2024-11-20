/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroler;

import domen.Administrator;
import java.util.ArrayList;
import java.util.List;
import so.login.SOLogin;

/**
 *
 * @author Milena
 */
public class ServerKontroler {
     private static ServerKontroler instance;
    private List<Administrator> ulogovaniAdministratori=new ArrayList<>();

    private ServerKontroler() {
    }

    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    public Administrator login(Administrator administrator) throws Exception  {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getUlogovani();
    }

    public List<Administrator> getUlogovaniAdministratori() {
        return ulogovaniAdministratori;
    }
    
    
}
