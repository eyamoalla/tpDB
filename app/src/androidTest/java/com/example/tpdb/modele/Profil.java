package com.example.tpdb.modele;

import java.util.Date;

public class Profil {
    private Date datamesure ;
    private Integer poid;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private Integer caloriesConsumed;
    private float caloriesCalculated;
    private String msg;

    public Profil(Date datamesure, Integer poid, Integer taille, Integer age, Integer sexe, Integer caloriesConsumed) {
        this.datamesure = datamesure;
        this.poid = poid;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.caloriesConsumed = caloriesConsumed;
       caloriesCalculation();

    }
    private void caloriesCalculation(){
        float tailleMetre = ((float)taille)/100;
        if(sexe==0)
            this.caloriesCalculated = (float)(10*poid+ (6.25 * tailleMetre)-(5 * (age + 5)));
        else
            this.caloriesCalculated = (float)(10*poid+ (6.25 * tailleMetre)-(5 * (age + 161)));
    }


    public Date getDatamesure() {
        return datamesure;
    }

    public Integer getPoid() {
        return poid;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public Integer getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public float getCaloriesCalculated() {
        return caloriesCalculated;
    }

    public String getMsg() {
        return msg;
    }
}
