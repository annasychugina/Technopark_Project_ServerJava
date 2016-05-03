/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.anna.jserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class JSocServer {

    private final int port;

    public JSocServer(final int port) {

        this.port = port;

    }

    public void start()  {

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(port); // создаем сокет сервера и привязываем его к вышеуказанному порту
        } catch (IOException ex) {
            Logger.getLogger(JSocServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Waiting for a client...");

        while (true) {

            Socket socket = null;
            try {
                socket = ss.accept(); // заставляем сервер ждать подключений и выводим сообщение когда кто-то связался с сервером
            } catch (IOException ex) {
                Logger.getLogger(JSocServer.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.err.println("Client accepted:" + socket.getInetAddress().getHostAddress());
            try {

                new Thread(new UserProcessor(socket)).start();
            } catch (Throwable ex) {
                Logger.getLogger(JSocServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
