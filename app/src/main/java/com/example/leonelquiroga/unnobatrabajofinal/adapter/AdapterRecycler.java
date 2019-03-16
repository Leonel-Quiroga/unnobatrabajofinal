package com.example.leonelquiroga.unnobatrabajofinal.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leonelquiroga.unnobatrabajofinal.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderDatos> {

    private List<Paciente> listaPacientes;

    public AdapterRecycler(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        private TextView nombre;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(Paciente paciente) {
            nombre.setText(paciente.getDescripcion());
        }
    }

    @Override
    public AdapterRecycler.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(AdapterRecycler.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listaPacientes.get(position));
    }

    @Override
    public int getItemCount() {
        return listaPacientes.size();
    }
}
