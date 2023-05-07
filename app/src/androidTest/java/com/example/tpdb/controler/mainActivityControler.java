package com.example.tpdb.controler;

import android.content.Context;

import com.example.tpdb.modele.DbAccesslLocal;
import com.example.tpdb.modele.Profil;

import java.util.Date;

public class mainActivityControler {

    private static mainActivityControler instance=null;
    private static DbAccesslLocal accesLocal;
    private static Profil profil;

    public mainActivityControler() {
        super();
    }

    public static final mainActivityControler getInstance(Context context){
        if(mainActivityControler.instance==null){
            mainActivityControler.instance= new mainActivityControler();
            accesLocal= new DbAccesslLocal(context);
            profil = accesLocal.recupDernier();
        }
        return mainActivityControler.instance;
    }

    public void createProfil(Date Date, Integer poids , Integer taille, Integer age,
                             Integer sexe, Integer calorieConsumed){
        profil = new Profil(Date, poids , taille , age , sexe, calorieConsumed );
        accesLocal.ajout(profil);
    }

    public float getcalories(){
        return profil.getCaloriesCalculated();
    }

    public Integer getPoid(){
        if(profil == null){
            return null;
        } else {
            return profil.getPoid();
        }
    }

    public Integer getTaille(){
        if(profil == null){
            return null;
        } else {
            return profil.getTaille();
        }
    }

    public Integer getAge(){
        if(profil == null){
            return null;
        } else {
            return profil.getAge();
        }
    }

    public Integer getSexe(){
        if(profil == null){
            return null;
        } else {
            return profil.getSexe();
        }
    }

    public Integer getCalorieConsumed(){
        if(profil == null){
            return null;
        } else {
            return profil.getCaloriesConsumed();
        }
    }
}
