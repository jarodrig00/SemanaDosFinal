package com.softnopal.semanadosfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MostrarContacto extends AppCompatActivity {

    private Button btnEditar;
    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvCorreo;
    private TextView tvDescripcion;

    private  String nombre;
    private String fecha;
    private  String telefono;
    private  String correo;
    private  String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_contacto);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvCorreo = (TextView) findViewById(R.id.tvCorreo);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            nombre = parametros.getString(getResources().getString(R.string.pnombre));
            fecha = parametros.getString(getResources().getString(R.string.pfecha));
            telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            correo = parametros.getString(getResources().getString(R.string.pcorreo));
            descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            tvNombre.setText(nombre);
            tvFecha.setText(getResources().getString(R.string.abreFecha) + " " + fecha);
            tvTelefono.setText(getResources().getString(R.string.abreTel) + " " + telefono);
            tvCorreo.setText(getResources().getString(R.string.abreCorreo) + " " + correo);
            tvDescripcion.setText(getResources().getString(R.string.abreDes) + " " + descripcion);
        }

        btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MostrarContacto.this, MainActivity.class);
                //Los intent solo pueden mandar datos primitivos
                i.putExtra(getResources().getString(R.string.pnombre), nombre);
                i.putExtra(getResources().getString(R.string.pfecha), fecha);
                i.putExtra(getResources().getString(R.string.ptelefono), telefono);
                i.putExtra(getResources().getString(R.string.pcorreo), correo);
                i.putExtra(getResources().getString(R.string.pdescripcion), descripcion);
                //Se pueden enviar arreglos de datos primitivos
                startActivity(i);
                finish();
            }
        });
    }
}
