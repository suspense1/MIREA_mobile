package ru.mirea.IshutinIS.buttonclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnWhoAmI = (Button) findViewById(R.id.btnWhoAmI);
        Button btnItIsNotMe = (Button) findViewById(R.id.btnItIsNotMe);
        //TextView tvOut = (TextView) findViewById(R.id.tvOut);
        CheckBox checkBox = findViewById(R.id.checkBox);
        btnWhoAmI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tvOut.setText("Мой номер по списку № 9");
                checkBox.setChecked(true);
            }
        });
    }

    public void ItIsNotMeClick(View view){
        //TextView tvOut = (TextView) findViewById(R.id.tvOut);
       // tvOut.setText("Это не я сделал");
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setChecked(false);
    }
}