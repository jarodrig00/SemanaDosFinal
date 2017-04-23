package com.softnopal.semanadosfinal;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button objButton;
    private EditText etNombre;
    private TextView tvFechaC;
    private EditText etTelefono;
    private EditText etCorreo;
    private EditText etDescripcion;

    private String nombre;
    private String fecha;
    private String telefono;
    private String correo;
    private String descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objButton = (Button) findViewById(R.id.btnSiguiente);
        etNombre = (EditText) findViewById(R.id.etNombre);
        tvFechaC = (TextView) findViewById(R.id.tvFechaC);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        Bundle parametros = getIntent().getExtras();
        if(parametros != null) {
            nombre = parametros.getString(getResources().getString(R.string.pnombre));
            fecha = parametros.getString(getResources().getString(R.string.pfecha));
            telefono = parametros.getString(getResources().getString(R.string.ptelefono));
            correo = parametros.getString(getResources().getString(R.string.pcorreo));
            descripcion = parametros.getString(getResources().getString(R.string.pdescripcion));

            //Asigna el valor al texto
            etNombre.setText(nombre);
            tvFechaC.setText(fecha);
            etTelefono.setText(telefono);
            etCorreo.setText(correo);
            etDescripcion.setText(descripcion);
        }



        objButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, MostrarContacto.class);
                //Los intent solo pueden mandar datos primitivos
                i.putExtra(getResources().getString(R.string.pnombre), etNombre.getText().toString());
                i.putExtra(getResources().getString(R.string.pfecha), tvFechaC.getText().toString());
                i.putExtra(getResources().getString(R.string.ptelefono),etTelefono.getText().toString() );
                i.putExtra(getResources().getString(R.string.pcorreo), etCorreo.getText().toString());
                i.putExtra(getResources().getString(R.string.pdescripcion), etDescripcion.getText().toString());
                //Se pueden enviar arreglos de datos primitivos
                startActivity(i);
                finish();
            }
        });
    }


    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
