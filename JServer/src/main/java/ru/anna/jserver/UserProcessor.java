/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.anna.jserver;

import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.List;
import ru.anna.models.City;

/**
 *
 * @author admin
 */
public class UserProcessor implements Runnable {

    private Socket s;

    private final DataInputStream is;
    private final DataOutputStream os;

    public UserProcessor(Socket s) throws Throwable {
        this.s = s;

        is = new DataInputStream(s.getInputStream());
        os = new DataOutputStream(s.getOutputStream());

    }

    @Override
    public void run() {
        try {
            readInputQuery();

//writeResponse(s);
        } catch (Throwable t) {
            /*do nothing*/

            System.out.println(t.getMessage());
            t.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (Throwable t) {
                /*do nothing*/
                System.out.println(t.getMessage());
                t.printStackTrace();
            }
        }
        System.out.println("Client processing finished");
    }

    private void writeResponse(String s) throws Throwable {
        os.writeUTF(s);
        os.flush();
    }

    private void readInputQuery() throws Throwable {

        while (true) {

            String cmd = is.readUTF();
            System.out.println("Command:" + cmd);

            switch (cmd) {

                case "getCities":

                    List<City> cities = new ru.anna.jserver.CityDao().getCities();
                    String ss = new Gson().toJson(cities);
                    writeResponse(ss);

                    return;

                case "hello":
                    break;
                case "help":
                    break;
                case "bye":
                    return;
                default:
                    throw new AssertionError("bad command");
            }

        }
    }

}
