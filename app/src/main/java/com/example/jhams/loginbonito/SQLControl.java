package com.example.jhams.loginbonito;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControl {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControl(Context c) {
        ourcontext = c;
    }

    public SQLControl abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.OBJETO_NOMBRE, name);
        database.insert(DBhelper.TABLE_OBJETO, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.OBJETO_ID,
                DBhelper.OBJETO_NOMBRE
        };
        Cursor c = database.query(DBhelper.TABLE_OBJETO, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long objetoID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.OBJETO_NOMBRE, memberName);
        int i = database.update(DBhelper.TABLE_OBJETO, cvActualizar,
                DBhelper.OBJETO_NOMBRE + " = " + objetoID, null);
        return i;
    }

    public void deleteData(long objetoID) {
        database.delete(DBhelper.TABLE_OBJETO, DBhelper.OBJETO_NOMBRE+ "="
                + objetoID, null);
    }
}