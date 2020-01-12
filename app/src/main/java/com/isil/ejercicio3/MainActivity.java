package com.isil.ejercicio3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /*Una empresa dedicada a la venta de productos paga a sus vendedores un sueldo
básico de S/.2400 y una comisión por el monto vendido durante el mes. Esta
comisión es un porcentaje del monto vendido. Se debe visualizar el sueldo
básico, el monto vendido, la comisión y el sueldo total que recibirá el vendedor a
final del mes.*/
    EditText monto;
    TextView resultado;
    int s_base = 2400;
    double comision, s_total, montoV;
    String mensaje = "";
    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monto = findViewById(R.id.montoventa);
        resultado = findViewById(R.id.txtresultado);

    }

    public void calcular(View view) {

        if (!monto.getText().toString().isEmpty()) {
            montoV = Double.parseDouble(monto.getText().toString());
        }else{
            mensaje="Ingrese la cantidad";
            resultado.setText(mensaje);
        }
        if ((mensaje.isEmpty()))
           if(montoV<=499){
               comision=montoV*0.005;
           }else
               if(montoV>500 && montoV<=1499){
                   comision=montoV*0.075;
               }else
                   if(montoV>=1500 && montoV<=5000){
                       comision=montoV*0.10;
                   }else{
                       comision=montoV*0.125;
                   }
                    s_total=s_base+comision;
                   resultado.setText(df.format(s_total));

        }
        public void eliminar(View view){
        monto.setText("");
        resultado.setText("");
        }

    }
