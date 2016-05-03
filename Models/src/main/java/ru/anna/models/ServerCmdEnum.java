/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.anna.models;

/**
 *
 * @author admin
 */
public enum ServerCmdEnum {

    getCities("City list"),
    hello("hello"),
    help("help"),
    bye("bye bye");

    private final String cmd;

    ServerCmdEnum(String cmd) {
        this.cmd = cmd;

    }

    public String getCmdDesc() {
        return cmd;
    }

}
