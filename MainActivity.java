package com.fabiohong.calcolatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView operazione, risultato;
    Button cancella, btn7, btn8, btn9, diviso;
    Button percento, btn4, btn5, btn6, moltiplicazione;
    Button radice, btn1, btn2, btn3, meno;
    Button piumeno, btn0, btn00, punto, piu;
    Button uguale;

    float num1, num2;
    String numero= "";
    boolean ris, n2, op, p, d, mol, pi, men, fifty, rad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcolatrice);
        ris= false; n2= false; op= false; p= false; d= false; mol= false; pi= false; men= false; fifty= false; rad= false;

        ////////////////////////////////////////////////////////////////////////////////////////////
        operazione= findViewById(R.id.operazione);
        risultato= findViewById(R.id.risultato);

        cancella= findViewById(R.id.cancella);
        btn7= findViewById(R.id.btn7);
        btn8= findViewById(R.id.btn8);
        btn9= findViewById(R.id.btn9);
        diviso= findViewById(R.id.diviso);

        percento= findViewById(R.id.percento);
        btn4= findViewById(R.id.btn4);
        btn5= findViewById(R.id.btn5);
        btn6= findViewById(R.id.btn6);
        moltiplicazione= findViewById(R.id.moltiplicazione);

        radice= findViewById(R.id.radice);
        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        meno= findViewById(R.id.meno);

        piumeno= findViewById(R.id.piumeno);
        btn0= findViewById(R.id.btn0);
        btn00= findViewById(R.id.btn00);
        punto= findViewById(R.id.punto);
        piu= findViewById(R.id.piu);

        uguale= findViewById(R.id.uguale);

        ////////////////////////////////////////////////////////////////////////////////////////////
        cancella.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        diviso.setOnClickListener(this);

        percento.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        moltiplicazione.setOnClickListener(this);

        radice.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        meno.setOnClickListener(this);

        piumeno.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn00.setOnClickListener(this);
        punto.setOnClickListener(this);
        piu.setOnClickListener(this);

        uguale.setOnClickListener(this);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancella: reset();
                                break;
            case R.id.btn7: add("7");
                            break;
            case R.id.btn8: add("8");
                            break;
            case R.id.btn9: add("9");
                            break;
            case R.id.diviso:   divide();
                                break;

            case R.id.percento: fiftycent();
                                break;
            case R.id.btn4: add("4");
                            break;
            case R.id.btn5: add("5");
                            break;
            case R.id.btn6: add("6");
                            break;
            case R.id.moltiplicazione:  multiply();
                                        break;

            case R.id.radice:   radix();
                                break;
            case R.id.btn1: add("1");
                            break;
            case R.id.btn2: add("2");
                            break;
            case R.id.btn3: add("3");
                            break;
            case R.id.meno: substract();
                            break;

            case R.id.piumeno:  sign(); //////////// WORK IN PROGRESS ////////////
                                break;
            case R.id.btn0: add("0");
                            break;
            case R.id.btn00:    add("00");
                                break;
            case R.id.punto:    punto();
                                break;
            case R.id.piu:  plus();
                            break;

            case R.id.uguale:   result();
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////// METODI UTILIZZATI
    public void reset() {
        operazione.setText("");
        risultato.setText("");
        numero= "";

        ris= false; //FLAG STATO
        n2= false; p= false; //FLAG NUMERO
        op= false; d= false; mol= false; men= false; pi= false; fifty= false; rad= false; //FLAG OPERAZIONI
    }

    @SuppressLint("SetTextI18n")
    public void add(String car) { //AGGIUNGE UN NUMERO ALLA CALCOLATRICE
        if(ris)
            reset(); //RESETTA LA CALCOLATRICE SE SI INSERISCONO NUMERI DOPO AVER ESEGUITO UN'OPERAZIONE

        operazione.setText(operazione.getText().toString() + car);
        numero+= car;
    }

    public void punto() {
        if(ris)
            reset(); //RESETTA LA CALCOLATRICE SE SI INSERISCONO NUMERI DOPO AVER ESEGUITO UN'OPERAZIONE

        if(!p) {
            if(numero.equals("")) //SE IL NUMERO E' VUOTO AGGIUNGE UNO 0 PRIMA DELLA VIRGOLA
                add("0");

            add(".");

            p= true; //FLAG NUMERO
        }
    }

    @SuppressLint("SetTextI18n")
    public void divide() {
        if(!numero.equals(""))
            if(!op) { //VERIFICO SE E' GIA' ATTIVA UN'OPERAZIONE
                if(!n2) {
                    operazione.setText(operazione.getText().toString() + "/");
                    num1= Float.parseFloat(numero);
                    numero= "";
                }

                n2= true; //FLAG INIZIO INSERIMENTO SECONDO NUMERO
                op= true; d= true; n2= true; //FLAG OPERAZIONI
            }
    }

    @SuppressLint("SetTextI18n")
    public void multiply() {
        if(!numero.equals(""))
            if(!op) { //VERIFICO SE E' GIA' ATTIVA UN'OPERAZIONE
                if(!n2) {
                    operazione.setText(operazione.getText().toString() + "x");
                    num1= Float.parseFloat(numero);
                    numero= "";
                }

                n2= true; //FLAG INIZIO INSERIMENTO SECONDO NUMERO
                op= true; mol= true; //FLAG OPERAZIONI
            }
    }

    @SuppressLint("SetTextI18n")
    public void substract() {
        if(!numero.equals(""))
            if(!op) { //VERIFICO SE E' GIA' ATTIVA UN'OPERAZIONE
                if(!n2) {
                    operazione.setText(operazione.getText().toString() + "-");
                    num1= Float.parseFloat(numero);
                    numero= "";
                }

                n2= true; //FLAG INIZIO INSERIMENTO SECONDO NUMERO
                op= true; men= true; //FLAG OPERAZIONI
            }
    }

    @SuppressLint("SetTextI18n")
    public void plus() {
        if(!numero.equals(""))
            if(!op) { //VERIFICO SE E' GIA' ATTIVA UN'OPERAZIONE
                if(!n2) {
                    operazione.setText(operazione.getText().toString() + "+");
                    num1= Float.parseFloat(numero);
                    numero= "";
                }

                op= true; pi= true; //FLAG OPERAZIONI
                n2= true; //FLAG INIZIO INSERIMENTO SECONDO NUMERO
            }
    }

    @SuppressLint("SetTextI18n")
    public void fiftycent() {
        if(!fifty) {
            if(!numero.equals(""))
                if(!op) { //VERIFICO SE E' GIA' ATTIVA UN'OPERAZIONE
                    operazione.setText(operazione.getText().toString() + "/100");
                    num1= Float.parseFloat(numero);
                    risultato.setText(String.valueOf(num1/100));

                    op= true; ris= true; //FLAG STATO
                    fifty= true; //FLAG OPERAZIONI
                }
        }
        else { //SE ERA GIA' STATA UTILIZZATA VIENE RIPETUTA COL RISULTATO PRECEDENTE
            num1= num1 / 100;
            operazione.setText(num1 + "/100");
            risultato.setText(String.valueOf(num1 / 100));
        }
    }

    @SuppressLint("SetTextI18n")
    public void radix() {
        if(!rad) {
            if(!numero.equals(""))
                if(!op) { //VERIFICO SE E' GIA' ATTIVA UN'OPERAZIONE
                    operazione.setText("RAD " + operazione.getText().toString());
                    num1= Float.parseFloat(numero);
                    risultato.setText(String.valueOf(Math.sqrt(num1)));

                    op= true; ris= true; //FLAG STATO
                    rad= true; //FLAG OPERAZIONI
                }
        }
        else { //SE ERA GIA' STATA UTILIZZATA VIENE RIPETUTA COL RISULTATO PRECEDENTE
            num1= (float) Math.sqrt(num1);
            operazione.setText("RAD " + num1);
            risultato.setText(String.valueOf(Math.sqrt(num1)));
        }
    }

    public void sign() {
        /*if(!numero.equals(""))
            num1= Float.parseFloat(numero);
            num1= -num1;

            numero= "";
            add(String.valueOf(num1));*/
    }

    @SuppressLint("SetTextI18n")
    public void result() {
        if(!ris) {
            if(n2) { //VERIFICO CHE SIA STATO INSERITO IL SECONDO NUMERO
                num2= Float.parseFloat(numero);

                if(d)
                    risultato.setText(String.valueOf(num1/num2));

                if(mol)
                    risultato.setText(String.valueOf(num1*num2));

                if(men)
                    risultato.setText(String.valueOf(num1-num2));

                if(pi)
                    risultato.setText(String.valueOf(num1+num2));

                ris= true; //FLAG STATO
            }
        }
        else { //SE VIENE PREMUTO = PRIMA DI AVER INSERITO UN NUOVO NUMERO VIENE RIPETUTA L'OPERAZIONE USANDO IL RISULTATO PRECEDENTE
            if(d) {
                num1= num1 / num2;
                operazione.setText(num1 + "/" + num2);
                risultato.setText(String.valueOf(num1 / num2));
            }

            if(mol) {
                num1= num1 * num2;
                operazione.setText(num1 + "x" + num2);
                risultato.setText(String.valueOf(num1 * num2));
            }

            if(men) {
                num1= num1 - num2;
                operazione.setText(num1 + "-" + num2);
                risultato.setText(String.valueOf(num1 - num2));
            }

            if(pi) {
                num1= num1 + num2;
                operazione.setText(num1 + "+" + num2);
                risultato.setText(String.valueOf(num1 + num2));
            }

            if(fifty) {
                num1= num1 / 100;
                operazione.setText(num1 + "/100");
                risultato.setText(String.valueOf(num1 / 100));
            }

            if(rad) {
                num1= (float) Math.sqrt(num1);
                operazione.setText("RAD " + num1);
                risultato.setText(String.valueOf(Math.sqrt(num1)));
            }
        }
    }
}