package com.dam.juanma.practica2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //intento 1
    public TextView datos = null;



    //intento 2
    //TextView datos = (TextView)findViewById(R.id.tvinfo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //intento 1
        TextView datos = (TextView)findViewById(R.id.tvinfo);

        //intento 2
        //datos.setText("PATATA caliente");

        final Button btinfo = (Button)findViewById(R.id.btinfo);
        btinfo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                getInformacion(arg0);
                // lblMensaje.setText("He pulsado el botón");
                 } } );

    }


    public void getInformacion(View v){

        EditText nombre = (EditText) findViewById(R.id.etNombre);
        EditText apellidos = (EditText) findViewById(R.id.etApellidos);
        EditText edad = (EditText) findViewById(R.id.etEdad);
        RadioGroup sexo = (RadioGroup) findViewById(R.id.rgGenero);
        Spinner civil = (Spinner) findViewById(R.id.spcivil);
        Switch hijos = (Switch)findViewById(R.id.switch1);

        String informacion;

        informacion = nombre.getText().toString() + ", ";
        informacion += apellidos.getText().toString() + ", ";

        Integer mayor18 = Integer.parseInt(edad.getText().toString());
        if (mayor18 >= 18){
            informacion += "mayor de edad, ";
        }else{
            informacion += "menor de edad, ";
        }

        RadioButton btnsexoM = (RadioButton)findViewById(R.id.rbMujer);
        RadioButton btnsexoH = (RadioButton)findViewById(R.id.rbHombre);

        if(btnsexoH.isChecked()){
            informacion += "Hombre ";
            informacion += civil.getSelectedItem().toString();
        }else {
            String femenino = civil.getSelectedItem().toString();
            if (femenino.equals("Otro")) {
                informacion += "Mujer " + femenino;
            } else {
                String recortado = femenino.substring(0, femenino.length() - 1);
                informacion += "Mujer ";
                informacion += recortado + "a";
            }
        }


        if(hijos.isChecked()){
            informacion += " y con hijos";
        }else{
            informacion += " y sin hijos";
        }


        EditText datos = (EditText) findViewById(R.id.tvinfo);

     datos.setText(informacion);
     datos.invalidate();


    }

    public void reseteaInformacion(View v){
        EditText nombre = (EditText) findViewById(R.id.etNombre);
        EditText apellidos = (EditText) findViewById(R.id.etApellidos);
        EditText edad = (EditText) findViewById(R.id.etEdad);
        RadioGroup sexo = (RadioGroup) findViewById(R.id.rgGenero);
        RadioButton btnsexoM = (RadioButton)findViewById(R.id.rbMujer);
        RadioButton btnsexoH = (RadioButton)findViewById(R.id.rbHombre);
        Spinner civil = (Spinner) findViewById(R.id.spcivil);
        Switch hijos = (Switch)findViewById(R.id.switch1);
        TextView datos = (TextView)findViewById(R.id.tvinfo);
        

        nombre.setText("");
        apellidos.setText("");
        edad.setText("");
        btnsexoH.setChecked(false);
        btnsexoM.setChecked(false);
        civil.setSelection(((ArrayAdapter<String>)civil.getAdapter()).getPosition("Casado"));
        hijos.setChecked(false);



        datos.setText("Reservado para la información personal");
        datos.invalidate();

    }


}
