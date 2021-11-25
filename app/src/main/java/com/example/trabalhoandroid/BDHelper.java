package com.example.trabalhoandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "usuario.db";
    private static final String TABLE_NAME = "usuario";
    private static final String COLUM_ID = "id";
    private static final String COLUM_NOME = "nome";
    private static final String COLUM_SENHA = "senha";

    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table usuario " +
            "(id integer primary key autoincrement, nome text not null, " +
            " senha text not null);";

    public BDHelper(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }

    public void insereUsuario(Usuario u){
        db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUM_NOME, u.getNome());
        values.put(COLUM_SENHA, u.getSenha());
        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public String buscarSenha(String nome){
        db = this.getReadableDatabase();
        String query = "select nome, senha from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;
        b="Usuário ou senha incorretos";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(nome)){
                    b=cursor.getString(1);
                    break;
                }
            }while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        bd.execSQL(query);
        this.onCreate(bd);
    }
}