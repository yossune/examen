package com.neosmart.punkapl.Conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * Created by Yossune Arvez on 14,mayo,2022
 * <p>
 * Brentec
 */
public class ConexionSqlHelper extends SQLiteOpenHelper {

    public ConexionSqlHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL(Utilidades.CreateTableUsuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("DROP TABLE IF EXISTS Usuarios");
        onCreate(db);
    }
}
