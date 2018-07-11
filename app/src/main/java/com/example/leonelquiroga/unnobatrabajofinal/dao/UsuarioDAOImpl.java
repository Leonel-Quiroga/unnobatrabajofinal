package com.example.leonelquiroga.unnobatrabajofinal.dao;


import com.example.leonelquiroga.unnobatrabajofinal.dto.UsuarioDTO;

public class UsuarioDAOImpl implements IUsuarioDAO {
    @Override
    public boolean searchUser(UsuarioDTO u) {
        if(u.getUsr().equals("admin") && u.getPass().equals("admin")){
            return true;
        }
        return false;
    }
}
