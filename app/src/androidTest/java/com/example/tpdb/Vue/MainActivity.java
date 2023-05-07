package com.example.tpdb.Vue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tpdb.R;
import com.example.tpdb.controler.mainActivityControler;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        this.controler = mainActivityControler.getInstance(MainActivity.this);
    }
    private EditText txtPoid;
    private EditText txtTaille;
    private EditText txtAge;
    private EditText txtCalorie;
    private RadioButton sexeh;
    private RadioButton sexef;

     private  TextView rsltMsg;
    private mainActivityControler controler;
    private void init(){
        txtPoid = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        txtCalorie = (EditText) findViewById(R.id.txtCalorie);
        sexeh = (RadioButton) findViewById(R.id.sexeh);
        sexef = (RadioButton) findViewById(R.id.sexef);
        rsltMsg = (TextView) findViewById(R.id.rsltMsg);

        this.controler = controler.getInstance(this);
        recupProfil();
    }
    private void recupProfil() {
        if(controler.getPoid()!=null){
            txtPoid.setText(controler.getPoid().toString());
            txtTaille.setText(controler.getTaille().toString());
            txtAge.setText(controler.getAge().toString());
            txtCalorie.setText(controler.getCalorieConsumed().toString());
            sexeh.setChecked(true);
            if(controler.getSexe()==1)
                sexef.setChecked(true);
            BtnClick( null);
        }
    }
    public void BtnClick(View v){
        Integer poids=0;
        Integer taille=0;
        Integer age=0;
        Integer sexe=1;
        Integer calorieConsumed=0;
        try {
            poids = Integer.parseInt(txtPoid.getText().toString());
            taille = Integer.parseInt(txtTaille.getText().toString());
            age = Integer.parseInt(txtAge.getText().toString());
            calorieConsumed = Integer.parseInt(txtCalorie.getText().toString());
        }catch (Exception e){};
        if(sexeh.isChecked())
            sexe=0;
        if(poids==0 || taille ==0 || age==0){
            Toast.makeText(MainActivity.this, "Erreur de saisie", Toast.LENGTH_LONG).show();
        }else {
            afficheResult(poids,taille,age,sexe,calorieConsumed);
        }
    }
    private void afficheResult(Integer poids, Integer taille, Integer age , Integer sexe,
                               Integer calorieConsumed){
        this.controler.createProfil(new Date(),poids,taille,age,sexe,calorieConsumed);
        float calorieCalculated = this.controler.getcalories();
        if(calorieCalculated > calorieConsumed)
            rsltMsg.setText(" bravo "+calorieCalculated);
        else

        rsltMsg.setText(" vous ne devez pas manger plus de "+calorieCalculated);
    }

}