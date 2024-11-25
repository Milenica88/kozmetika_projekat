/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import domen.Administrator;
import domen.Kupac;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import kontroler.ServerKontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.Operacije;
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
                case Operacije.ADD_KUPAC:
                    ServerKontroler.getInstance().addKupac((Kupac) zahtev.getParametar());
                    break;
               /* case Operation.ADD_PORUDZBINA:
                    ServerController.getInstance().addPorudzbina((Porudzbina) request.getData());
                    break;*/
                case Operacije.DELETE_KUPAC:
                    ServerKontroler.getInstance().deleteKupac((Kupac) zahtev.getParametar());
                    break;
                /*case Operation.DELETE_PORUDZBINA:
                    ServerController.getInstance().deletePorudzbina((Porudzbina) request.getData());
                    break;*/
                case Operacije.UPDATE_KUPAC:
                    ServerKontroler.getInstance().updateKupac((Kupac) zahtev.getParametar());
                    break;
               /* case Operation.UPDATE_PORUDZBINA:
                    ServerController.getInstance().updatePorudzbina((Porudzbina) request.getData());
                    break;*/
                /*case Operation.GET_ALL_ADMINISTRATOR:
                    response.setData(ServerController.getInstance().getAllAdministrator());
                    break;*/
                case Operacije.GET_ALL_KUPAC:
                    odgovor.setOdgovor(ServerKontroler.getInstance().getAllKupac());
                    break;
               /* case Operation.GET_ALL_PORUDZBINA:
                    response.setData(ServerController.getInstance().getAllPorudzbina());
                    break;*/
               /* case Operation.GET_ALL_PROIZVOD:
                    response.setData(ServerController.getInstance().getAllProizvod());
                    break;*/
               /* case Operation.GET_ALL_STAVKA_PORUDZBINE:
                    response.setData(ServerController.getInstance().getAllStavkaPorudzbine((Porudzbina) request.getData()));
                    break;*/
                /*case Operation.GET_ALL_TIP_PROIZVODA:
                    response.setData(ServerController.getInstance().getAllTipProizvoda());
                    break;*/
                case Operacije.LOGIN:
                    Administrator administrator = (Administrator) zahtev.getParametar();
                    Administrator ulogovani = ServerKontroler.getInstance().login(administrator);
                    odgovor.setOdgovor(ulogovani);
                    break;
                 default:
                    return null;
            }
        } catch (Exception e) {
             odgovor.setStatusOdgovora(StatusOdgovora.Error);
             odgovor.setException(e);
        }
        return  odgovor;
    }
}
