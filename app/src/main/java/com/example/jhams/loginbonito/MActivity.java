package com.example.jhams.loginbonito;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MActivity extends AppCompatActivity {

    Button btnAgregarObjeto;
    ListView lista;
    SQLControl dbconeccion;
    TextView tv_objetID, tv_objetNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);

        dbconeccion = new SQLControl(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarObjeto = (Button) findViewById(R.id.btnAgregarObjeto);
        lista = (ListView) findViewById(R.id.listViewObjetoss);

        //acción del boton agregar objeto
        btnAgregarObjeto.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MActivity.this,AgregarObjeto.class);
                startActivity(iagregar);
            }
        });

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBhelper.OBJETO_ID,
                DBhelper.OBJETO_NOMBRE
        };
        int[] to = new int[] {
                R.id.objeto_id,
                R.id.objeto_nombre
        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MActivity.this, R.layout.lista, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);

        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        lista.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                tv_objetID = (TextView) view.findViewById(R.id.objeto_id);
                tv_objetNombre = (TextView) view.findViewById(R.id.objeto_nombre);

                String aux_objetoId = tv_objetID.getText().toString();
                String aux_objetoNombre = tv_objetNombre.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModificarObjeto.class);
                modify_intent.putExtra("objetoId", aux_objetoId);
                modify_intent.putExtra("objetoNombre", aux_objetoNombre);
                startActivity(modify_intent);
            }
        });
    }  //termina el onCreate
} //termina clase