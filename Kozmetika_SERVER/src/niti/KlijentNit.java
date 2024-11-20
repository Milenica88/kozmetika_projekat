/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.StatusOdgovora;

/**
 *
 * @author Milena
 */
public class KlijentNit extends Thread {
    private Socket socket;

    KlijentNit(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev zahtev= (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor odgovor = handleRequest(zahtev);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(odgovor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerskiOdgovor handleRequest(KlijentskiZahtev zahtev) {
        ServerskiOdgovor odgovor = new ServerskiOdgovor(null, null, StatusOdgovora.Success);
        try {
              switch (zahtev.getOperacija()) {
               
            }
        } catch (Exception e) {
             odgovor.setStatusOdgovora(StatusOdgovora.Error);
             odgovor.setException(e);
        }
        return  odgovor;
    }
}
