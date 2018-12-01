package com.example.jhams.loginbonito;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ModificarObjeto extends Activity implements OnClickListener {

    EditText et;
    Button btnActualizar;
    Button btnEliminar;

    long objeto_id;

    SQLControl dbcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar);

        dbcon = new SQLControl(this);
        dbcon.abrirBaseDeDatos();

        et = (EditText) findViewById(R.id.et_objeto_id);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);

        Intent i = getIntent();
        String objetoID = i.getStringExtra("objetoId");
        String objetoName = i.getStringExtra("objetoNombre");

        objeto_id
                = Long.parseLong(objetoID);

        et.setText(objetoName);

        btnActualizar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.btnActualizar:
                String memName_upd = et.getText().toString();
                dbcon.actualizarDatos(objeto_id, memName_upd);
                this.returnHome();
                break;

            case R.id.btnEliminar:
                dbcon.deleteData(objeto_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {

        Intent home_intent = new Intent(getApplicationContext(),
                MActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(home_intent);
    }
}