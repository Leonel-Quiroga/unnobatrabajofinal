package com.example.leonelquiroga.unnobatrabajofinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leonelquiroga.unnobatrabajofinal.dao.UsuarioDAOImpl;
import com.example.leonelquiroga.unnobatrabajofinal.dto.UsuarioDTO;

public class LoginActivity extends Activity implements View.OnClickListener {
    public static final int REQUEST_CODE = 10;
    private EditText etUsr;
    private EditText etPass;
    private TextView tvFail;
    private Button btnIngresar;
    private UsuarioDTO usrDTO;
    private UsuarioDAOImpl usrDAOimpl = new UsuarioDAOImpl();
    private static String si = "Sesion iniciada";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsr = (EditText) findViewById(R.id.idUsr);
        etPass = (EditText) findViewById(R.id.idPass);
        tvFail = (TextView) findViewById(R.id.idFail);
        btnIngresar = (Button) findViewById(R.id.idIngresar);
        btnIngresar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        usrDTO = new UsuarioDTO();
        usrDTO.setUsr(etUsr.getText().toString());
        usrDTO.setPass(etPass.getText().toString());
        if(usrDAOimpl.searchUser(usrDTO)) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class );
            i.putExtra("TEXTO MAINACTIVITY", si);
            startActivityForResult(i,REQUEST_CODE);
        } else {
            tvFail.setVisibility(View.VISIBLE);
        }

    }
}
