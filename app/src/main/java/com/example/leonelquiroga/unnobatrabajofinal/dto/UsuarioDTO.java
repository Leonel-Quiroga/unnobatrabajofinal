package com.example.leonelquiroga.unnobatrabajofinal.dto;

public class UsuarioDTO {

    private String usr;
    private String pass;

    public UsuarioDTO(String usr, String pass) {
        this.usr = usr;
        this.pass = pass;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
