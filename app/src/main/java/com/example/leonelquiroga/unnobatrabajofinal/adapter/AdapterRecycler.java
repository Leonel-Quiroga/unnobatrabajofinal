package com.example.leonelquiroga.unnobatrabajofinal.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.leonelquiroga.unnobatrabajofinal.R;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderDatos> {

    private List<Paciente> listaPacientes;

    public AdapterRecycler(List<Paciente> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        private TextView nombreDistancia, detalle, latLon, domicilio, telefono;
        private ImageView imagen;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            nombreDistancia = (TextView) itemView.findViewById(R.id.itemNombreDistancia);
            detalle = (TextView) itemView.findViewById(R.id.itemDetalle);
            latLon = (TextView) itemView.findViewById(R.id.itemLatLon);
            domicilio = (TextView) itemView.findViewById(R.id.itemDomicilio);
            telefono = (TextView) itemView.findViewById(R.id.itemTelefono);
            imagen = (ImageView) itemView.findViewById(R.id.itemImagen);
        }

        public void asignarDatos(Paciente paciente) {
            nombreDistancia.setText(paciente.getDescripcion() + " - Distancia: " + String.format("%.2f", paciente.getDistancia()));
            detalle.setText("Detalle: " + paciente.getDetalle());
            latLon.setText("Latitud: " + String.format("%.4f", paciente.getLatitud()) + " Longitud: " + String.format("%.5f", paciente.getLongitud()));
            domicilio.setText("Domicilio: " + paciente.getDomicilio());
            telefono.setText("Teléfono: " + paciente.getTelefono());
            if(paciente.getDescripcion().equals("Caballo Wilfredo")) {
                imagen.setImageResource(R.drawable.caballero_final);
            } else if(paciente.getDescripcion().equals("Demaría Angel")) {
                imagen.setImageResource(R.drawable.fideo_final);
            } else if (paciente.getDescripcion().equals("Iguazú Gonzalo")) {
                imagen.setImageResource(R.drawable.pipa_final);
            }
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
