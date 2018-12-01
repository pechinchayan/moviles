package com.example.jhams.loginbonito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loggeado extends AppCompatActivity implements View.OnClickListener {

    Button btnjugar;
   /* Button btnresult;
    Button btnrmund;
    Button btnconf;
    Button btnusuario;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggeado);

        btnjugar = findViewById(R.id.btnjugar);
       /* btnresult = findViewById(R.id.btnresult);
        btnrmund = findViewById(R.id.btnrmund);
        btnconf = findViewById(R.id.btnconf);
        btnusuario = findViewById(R.id.btnusuario);*/

        btnjugar.setOnClickListener(this);
       /* btnresult.setOnClickListener(this);
        btnrmund.setOnClickListener(this);
        btnconf.setOnClickListener(this);
        btnusuario.setOnClickListener(this);*/


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnjugar:
                btjugar();
                break;
          /*  case R.id.btnresult:
                btresult();
                break;
            case R.id.btnrmund:
                btrmund();
                break;
            case R.id.btnconf:
                btconf();
                break;
            case R.id.btnusuario:
                btusuario();
                break;*/

            default:
                break;
        }

    }
    public  void btjugar(){
        Intent intent = new Intent(this,Juego.class);
        startActivityForResult(intent, 0);
    }
  /*  public  void btresult(){
        Intent intent = new Intent(this,faltanombre.class);
        startActivityForResult(intent, 0);

    }
    public  void btrmund(){
        Intent intent = new Intent(this,faltanomre.class);
        startActivityForResult(intent, 0);

    }
    public  void btconf(){
        Intent intent = new Intent(this,faltanomrer.class);
        startActivityForResult(intent, 0);

    }
    public  void btusuario(){
        Intent intent = new Intent(this,faltanomre.class);
        startActivityForResult(intent, 0);

    }*/



}
