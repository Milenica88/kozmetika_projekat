/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Milena
 */
public class ServerNit extends Thread {
    private ServerSocket serverSocket;

    public ServerNit() {
        try {
            serverSocket = new ServerSocket(9000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                System.out.println("Cekanje klijenta...");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                KlijentNit th = new KlijentNit(socket);
                th.start();
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
}
