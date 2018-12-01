package com.example.jhams.loginbonito;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Juego extends AppCompatActivity implements View.OnClickListener  {

    Button btnagregar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego);

    btnagregar= findViewById(R.id.btnagregar);
    btnagregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnagregar:
                btagregar();
                break;

        }
    }
    public  void btagregar(){
        Intent intent = new Intent(this,MActivity.class);
        startActivityForResult(intent, 0);

    }
}