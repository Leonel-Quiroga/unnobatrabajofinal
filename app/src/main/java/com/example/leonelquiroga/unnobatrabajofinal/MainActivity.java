package com.example.leonelquiroga.unnobatrabajofinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnListaPaciente;
    private Button btnCerrarSesion;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListaPaciente = (Button) findViewById(R.id.btnListaPaciente);
        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);
        preferences = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        btnListaPaciente.setOnClickListener(this);
        btnCerrarSesion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnListaPaciente:
                intent = new Intent(MainActivity.this, ListaPacienteActivity.class);
                startActivity(intent);
                break;
            case R.id.btnCerrarSesion:
                editor = preferences.edit();
                editor.clear();
                editor.commit();
                setIntentWithFinish(MainActivity.this, LoginActivity.class);
                break;
        }

    }

    public void setIntentWithFinish(Context c1, Class c2) {
        Intent intent = new Intent(c1, c2);
        startActivity(intent);
        finish();
    }
}
