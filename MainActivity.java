package com.mychaht.example;

import android.app.*;
import android.os.*;
import android.text.*;
import android.widget.*;
import android.graphics.*;
import android.view.*;

public class MainActivity extends Activity {

    public int My = 1;
    public String ID;
    public String OtherID;

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SelectID();

    }

    public void SelectID(){

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);

        EditText editTextID = new EditText(this);
        editTextID.setLayoutParams(new LinearLayout.LayoutParams(500,-2));
        editTextID.setHint("Crie seu ID");
        editTextID.setHintTextColor(Color.parseColor("#FF616161"));
        editTextID.setTextColor(Color.parseColor("#FF212121"));
        editTextID.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText editTextOtherID = new EditText(this);
        editTextOtherID.setLayoutParams(new LinearLayout.LayoutParams(500,-2));
        editTextOtherID.setHint("Crie outro ID");
        editTextOtherID.setHintTextColor(Color.parseColor("#FF616161"));
        editTextOtherID.setTextColor(Color.parseColor("#FF212121"));
        editTextOtherID.setInputType(InputType.TYPE_CLASS_NUMBER);

        Button buttonAddID = new Button(this);
        buttonAddID.setLayoutParams(new LinearLayout.LayoutParams(500, -2));
        buttonAddID.setPadding(0, 0, 0, 0);
        buttonAddID.setText("Adicionar ID");
        buttonAddID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ID = editTextID.getText().toString();
                OtherID = editTextOtherID.getText().toString();

                Toast.makeText(MainActivity.this, "Seu ID" + " - " + ID, Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Outro ID" + " - " + OtherID, Toast.LENGTH_SHORT).show();


                Chat();
                return;

            }
        });

        setContentView(linearLayout);
        linearLayout.addView(editTextID);
        linearLayout.addView(editTextOtherID);
        linearLayout.addView(buttonAddID);

    }

    public void Chat(){

        linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1,-1));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(Gravity.CENTER);

        TextView textViewID = new TextView(this);
        textViewID.setLayoutParams(new LinearLayout.LayoutParams(-1,-2));
        textViewID.setText("Seu ID" + " - "+ ID);
        textViewID.setTextColor(Color.GREEN);
        textViewID.setGravity(Gravity.CENTER);

        EditText editTextMensagem = new EditText(this);
        editTextMensagem.setLayoutParams(new LinearLayout.LayoutParams(500, -2));
        editTextMensagem.setHint("Escreva uma mensagem...");
        editTextMensagem.setHintTextColor(Color.parseColor("#FF616161"));
        editTextMensagem.setTextColor(Color.parseColor("#FF212121"));

        Button buttonSendMesagem = new Button(this);
        buttonSendMesagem.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        buttonSendMesagem.setText("Enviar Mensagem");
        buttonSendMesagem.setPadding(5, 5, 5, 5);
        buttonSendMesagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mensagem(editTextMensagem.getText().toString());
            }
        });

        CheckBox checkBoxMy = new CheckBox(this);
        checkBoxMy.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        checkBoxMy.setText("Eu");
        checkBoxMy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checkedStatus) {

                if (checkedStatus){
                    checkBoxMy.setText("Outro");
                    My = 0;
                } else {
                    checkBoxMy.setText("Eu");
                    My = 1;
                }

            }
        });

        setContentView(linearLayout);
        linearLayout.addView(textViewID);

        linearLayout.addView(editTextMensagem);
        linearLayout.addView(buttonSendMesagem);
        linearLayout.addView(checkBoxMy);

    }

    public void Mensagem(String mensagem){

        TextView textViewMensagem = new TextView(this);
        textViewMensagem.setLayoutParams(new LinearLayout.LayoutParams(500, -2));

        if (My == 1){
            textViewMensagem.setTextColor(Color.BLACK);
            textViewMensagem.setText("ID: " + ID + " - " + mensagem);
        } else {
            textViewMensagem.setTextColor(Color.RED);
            textViewMensagem.setText("ID: " + OtherID + " - " + mensagem);
        }
        linearLayout.addView(textViewMensagem);

    }

}