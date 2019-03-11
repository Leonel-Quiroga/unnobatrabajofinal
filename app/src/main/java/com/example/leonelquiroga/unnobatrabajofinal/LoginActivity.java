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

public class LoginActivity extends Activity {

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
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        if(sharedPreferences.contains(PREF_USR) && sharedPreferences.contains(PREF_PASS)){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            etUsr = (EditText) findViewById(R.id.idUsr);
            etPass = (EditText) findViewById(R.id.idPass);
            btnIngresar = (Button) findViewById(R.id.idIngresar);

            btnIngresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    usrDTO = new UsuarioDTO();
                    usrDTO.setUsr(etUsr.getText().toString());
                    usrDTO.setPass(etPass.getText().toString());
                    if(usrDAOimpl.searchUser(usrDTO)) {

                        sharedPreferences = getSharedPreferences
                                (PREFERENCE, Context.MODE_PRIVATE);

                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(PREF_USR, usrDTO.getUsr());
                        editor.putString(PREF_PASS, usrDTO.getPass());

                        editor.apply();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    }else {
                        Toast.makeText(LoginActivity.this, "Usuario Incorrecto!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
