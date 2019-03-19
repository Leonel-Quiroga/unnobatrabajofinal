package com.example.leonelquiroga.unnobatrabajofinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leonelquiroga.unnobatrabajofinal.dao.UsuarioDAOImpl;
import com.example.leonelquiroga.unnobatrabajofinal.dto.UsuarioDTO;

public class LoginActivity extends Activity implements View.OnClickListener {

    /*Constantes*/
    public static final String PREFERENCE = "preferencias";
    public static final String PREF_USR = "usr";
    public static final String PREF_PASS = "pass";

    /*Activities*/
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private EditText etUsr;
    private EditText etPass;
    private Button btnIngresar;

    /*Imports*/
    private UsuarioDTO usrDTO;
    private UsuarioDAOImpl usrDAOimpl = new UsuarioDAOImpl();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsr = (EditText) findViewById(R.id.idUsr);
        etPass = (EditText) findViewById(R.id.idPass);
        btnIngresar = (Button) findViewById(R.id.idIngresar);
        btnIngresar.setOnClickListener(this);
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(PREF_USR) && sharedPreferences.contains(PREF_PASS)) {
            setIntentWithFinish(LoginActivity.this, MainActivity.class);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.idIngresar:
                usrDTO = new UsuarioDTO(etUsr.getText().toString(), etPass.getText().toString());
                if (usrDAOimpl.searchUser(usrDTO)) {
                    guardarPreferencias(usrDTO.getUsr(), usrDTO.getPass());
                    setIntentWithFinish(LoginActivity.this, MainActivity.class);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Usuario Incorrecto!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void guardarPreferencias(String usr, String pass) {
        editor = sharedPreferences.edit();
        editor.putString(PREF_USR, usr);
        editor.putString(PREF_PASS, pass);
        editor.apply();
    }

    public void setIntentWithFinish(Context c1, Class c2) {
        Intent intent = new Intent(c1, c2);
        startActivity(intent);
        finish();
    }
}
