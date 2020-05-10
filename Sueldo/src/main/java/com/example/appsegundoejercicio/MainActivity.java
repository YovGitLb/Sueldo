package com.example.appsegundoejercicio;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{

    EditText cApe,cDia,cSue,cCargo;
    TextView cImp;
    Button btn1,btn2;
    TextView apellido,cargo,dias, sueldo,bonificacion1,bonificacion2, sobretiempo,totalsueldo;

public void initComponentPantalla2(){
    apellido=(TextView)findViewById(R.id.ape);
    cargo=(TextView)findViewById(R.id.cargo);
    dias=(TextView)findViewById(R.id.dias);
    sueldo=(TextView)findViewById(R.id.sueldo);
    cImp=(TextView)findViewById(R.id.importe);


    bonificacion1=(TextView)findViewById(R.id.bonifi1);
    bonificacion2=(TextView)findViewById(R.id.bonifi2);
    sobretiempo=(TextView)findViewById(R.id.sobretiempo);
    totalsueldo=(TextView)findViewById(R.id.sueldototal);





}

public void initComponentPantalla1(){
    cApe=(EditText)findViewById(R.id.txtApe);
    cDia=(EditText)findViewById(R.id.txtDias);
    cSue=(EditText)findViewById(R.id.txtSue);
    cCargo=(EditText)findViewById(R.id.txtCargo);
    btn1=(Button)findViewById(R.id.btnCalc);
    btn1.setOnClickListener(this);


}






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initComponentPantalla1();

    }



    @Override
    public void onClick(View view) {


    double sueldos=0, importe=0, boni1=0, boni2=0, sobretiem=0, total=0;
    int dia=0;
    String nombre="", cargos="";


    nombre=cApe.getText().toString();
    dia=Integer.parseInt((cDia.getText().toString()));
    sueldos=Double.parseDouble(cSue.getText().toString());
    cargos=cCargo.getText().toString();
        importe=Math.round(sueldos/30);
        boni1=sueldos*0.10;
        boni2=sueldos*0.15;
        sobretiem=Math.round(sueldos/30/8);
        total=Math.round(sueldos+boni1+boni2+sobretiem);

    setContentView(R.layout.activity_main_sueldo);
    initComponentPantalla2();

    apellido.setText("Nombre del trabajador: "+nombre);
    dias.setText("Total de dias trabajados: "+String.valueOf(dia));
    sueldo.setText("Su sueldo es: "+String.valueOf(sueldos));
    cargo.setText("Tiene el cargo de: "+cargos);

    cImp.setText("El importe por dia es: "+String.valueOf(importe));
    bonificacion1.setText("La Primera bonificacion: "+String.valueOf(boni1));
    bonificacion2.setText("La Segunda bonificacion: "+String.valueOf(boni2));
    sobretiempo.setText("Su sobretiempo es: "+String.valueOf(sobretiem));
    totalsueldo.setText("El sueldo total de "+nombre+ "es "+String.valueOf(total));





    }
}
