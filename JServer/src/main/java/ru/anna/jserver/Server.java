/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.anna.jserver;

/**
 *
 * @author admin
 */
public class Server {

    public static void main(String[] ar) {
        int port = 5000; // случайный порт (может быть любое число от 1025 до 65535)
        JSocServer js = new JSocServer(port);
        js.start();
    }
}
