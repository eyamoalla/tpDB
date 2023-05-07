package com.example.tpdb.modele;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tpdb.outils.MySQLiteOpenHelper;

import java.util.Date;

public class DbAccesslLocal {
    private String nomBase ="dbCalories.sqlite";
    private Integer versionBase=1;
    private MySQLiteOpenHelper accessDB;
    private SQLiteDatabase db;
    public DbAccesslLocal(Context context){
        accessDB = new MySQLiteOpenHelper(context, nomBase , null , versionBase);
    }
    public void ajout(Profil profil){
        db = accessDB.getWritableDatabase();
        String req = "insert into profil (datemesure,poid,taille,age,sexe, calories)values";
        req += "(\""+profil.getDatamesure()+"\","+profil.getPoid()
                +","+profil.getTaille()+","+profil.getAge()+","+profil.getSexe()+","+profil.getCaloriesConsumed()
        +")";
        db.execSQL(req);
    }
    public Profil recupDernier()
    {
        db = accessDB.getReadableDatabase();
        Profil profil=null;
        String req = "select * from profil";
        Cursor curseur = db.rawQuery(req,null);
        curseur.moveToLast();
        if(!curseur.isAfterLast())
        {
            Date date = new Date();
            Integer poids = curseur.getInt(1);
            Integer taille = curseur.getInt(2);
            Integer age = curseur.getInt(3);
            Integer sexe = curseur.getInt(4);
            Integer calories = curseur.getInt(5);
            profil = new Profil(date,poids, taille, age, sexe, calories);
        }
        curseur.close();
        return profil;
    }
}



