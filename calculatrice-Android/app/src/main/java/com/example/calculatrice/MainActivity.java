package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double nbr1 = 0.0 ;
    double nbr2 = 0.0 ;
    double result = 0.0 ;
    char oper = ' ';
    int flag = 0 ;

    TextView ecran;
    static String ZERO = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecran = findViewById(R.id.ecran);
        ecran.setText(ZERO);

    }

    public void afficherChiffre(View view) {

        Button btn = (Button) view;
        String ecranText = ecran.getText().toString();
        String chiffre = btn.getText().toString();
        if(flag == 0)
             ecran.setText(ZERO.equals(ecranText) ?chiffre: ecranText+chiffre);
        else {
            ecran.setText(chiffre);
        }
        flag  = 0 ;
    }

    public void ce(View view) {

        ecran.setText(ZERO);
        oper = ' ';
        nbr1 = 0.0 ;
        nbr2 = 0.0 ;
        result = 0.0;
        flag  = 0 ;
    }


    public void produit(View view) {

        nbr1 = Double.parseDouble(ecran.getText().toString());
        oper = 'x';
        flag  = 1 ;
    }

    public void division(View view) {

        nbr1 = Double.parseDouble(ecran.getText().toString());
        oper = '/';
        flag  = 1 ;
    }

    public void getResult(View view) {

    nbr2  = Double.parseDouble(ecran.getText().toString());
    switch (oper){
        case '+':
            result = nbr1 + nbr2 ;
            ecran.setText(String.valueOf(result));
            break;
        case '-' :
            result = nbr1 - nbr2 ;
            ecran.setText(String.valueOf(result));
            break;
        case '/':
            result = nbr1 / nbr2 ;
            ecran.setText(String.valueOf(result));
            break;
        case 'x':
            result = nbr1 * nbr2 ;
            ecran.setText(String.valueOf(result));
            break;
        default:
            break;
    }
    }

    public void somme(View view) {

        nbr1 = Double.parseDouble(ecran.getText().toString());
        oper = '+';
        flag  = 1 ;
    }

    public void soustraction(View view) {

        nbr1 = Double.parseDouble(ecran.getText().toString());
        oper = '-';
        flag  = 1 ;
    }

    public void Inverse(View view) {

        nbr1 = Double.parseDouble(ecran.getText().toString());
        if (nbr1 == 0){
            ecran.setText("Math Error");

        }
        else{
            result = 1/nbr1;
            ecran.setText(String.valueOf(result));
        }
    }

    public void cosinus(View view) {

        double degre = Double.parseDouble(ecran.getText().toString());
        double radian = Math.toRadians(degre);
        result = Math.cos(radian);
        ecran.setText(String.valueOf(result));

    }

    public void sinus(View view) {

        double degre = Double.parseDouble(ecran.getText().toString());
        double radian = Math.toRadians(degre);
        result = Math.sin(radian);
        ecran.setText(String.valueOf(result));

    }

    public void tangente(View view) {
        double degre = Double.parseDouble(ecran.getText().toString());
        double radian = Math.toRadians(degre);
        result = Math.tan(radian);
        ecran.setText(String.valueOf(result));
    }



    public void updateCalcu(View view) {

        // recuperer  CheckBox
        CheckBox checkEXtended = (CheckBox) findViewById(R.id.extended);
        Boolean checkBoxState = checkEXtended.isChecked();

        // recuperer  Layoutextend
        LinearLayout lny = (LinearLayout) findViewById(R.id.extende_layout);

        if(checkBoxState)
            lny.setVisibility(View.VISIBLE);
        else
            lny.setVisibility(View.INVISIBLE);
    }
}