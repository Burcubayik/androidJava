package com.example.hesapmakinesi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.hesapmakinesi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        tasarim.button1.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+ "1");
        });

        tasarim.button2.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+ "2");
        });
        tasarim.button3.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+ "3");
        });
        tasarim.button4.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+ "4");
        });
        tasarim.button5.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"5");
        });
        tasarim.button6.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"6");
        });
        tasarim.button7.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"7");
        });
        tasarim.button8.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"8");
        });
        tasarim.button9.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"9");
        });
        tasarim.button0.setOnClickListener(view -> {
            if(tasarim.textViewIslem.getText().equals("")){

                tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"0.");
            }else
            {
                tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"0");
            }
        });
        tasarim.button00.setOnClickListener(view -> {
            if(tasarim.textViewIslem.getText().equals("")){

            }else
            {
                tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+"00");
            }

        });
        tasarim.buttonNokta.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+".");
        });
        tasarim.buttonTopla.setOnClickListener(view -> {
            tasarim.textViewIslem.setText(tasarim.textViewIslem.getText().toString()+" + ");
        });
        tasarim.buttonSil.setOnClickListener(view -> {
            tasarim.textViewIslem.setText("");
            tasarim.textViewSonuc.setText("0");
        });
        tasarim.buttonEsit.setOnClickListener(view -> {
            tasarim.textViewIslem.toString();
            double sonuc =0;
            String[] ayrilmis;
            ayrilmis = String.valueOf(tasarim.textViewIslem.getText()).split(" " );
            double[] a=new double[ayrilmis.length];
            for(int i = 0;i < ayrilmis.length;i+=2){
               a[i] = Double.parseDouble(ayrilmis[i]) ;
               sonuc+=a[i];
            }
            tasarim.textViewSonuc.setText(String.valueOf(sonuc));

        });

        setContentView(tasarim.getRoot());
    }
}