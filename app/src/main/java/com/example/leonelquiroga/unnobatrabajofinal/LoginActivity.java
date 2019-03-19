package com.example.leonelquiroga.unnobatrabajofinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leonelquiroga.unnobatrabajofinal.dao.UsuarioDAOImpl;
import com.example.leonelquiroga.unnobatrabajofinal.dto.UsuarioDTO;

public class LoginActivity extends Activity implements View.OnClickListener {

    public static final int REQUEST_CODE = 10;
    private EditText etUsr;
    private EditText etPass;
    private Button btnIngresar;
    private UsuarioDTO usrDTO;
    private UsuarioDAOImpl usrDAOimpl = new UsuarioDAOImpl();
    private SharedPreferences sharedPreferences;
    public static final String PREFERENCE = "preferencias";
    public static final String PREF_USR = "usr";
    public static final String PREF_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsr = (EditText) findViewById(R.id.idUsr);
        etPass = (EditText) findViewById(R.id.idPass);
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        btnIngresar = (Button) findViewById(R.id.idIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.idIngresar:
                if (sharedPreferences.contains(PREF_USR) && sharedPreferences.contains(PREF_PASS)) {
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    usrDTO = new UsuarioDTO();
                    usrDTO.setUsr(etUsr.getText().toString());
                    usrDTO.setPass(etPass.getText().toString());
                    if (usrDAOimpl.searchUser(usrDTO)) {
                        guardarPreferencias(usrDTO.getUsr(), usrDTO.getPass());
                        intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Usuario Incorrecto!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }

    private void guardarPreferencias(String usr, String pass) {
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_USR, usr);
        editor.putString(PREF_PASS, pass);
        editor.apply();
    }
}
