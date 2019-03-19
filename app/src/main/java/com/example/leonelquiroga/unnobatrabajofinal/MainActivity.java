package com.example.leonelquiroga.unnobatrabajofinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button btnListaPaciente, btnCerrarSesion;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCerrarSesion = (Button) findViewById(R.id.btnCerrarSesion);
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(LoginActivity.PREFERENCE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit().clear();
                editor.commit();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        btnListaPaciente = (Button) findViewById(R.id.btnListaPaciente);
        btnListaPaciente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListaPacienteActivity.class);
                startActivity(intent);
            }
        });
    }
}
