package ru.mirea.ishutin.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

import ru.mirea.ishutin.thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Имя текущего потока: " + mainThread.getName());

// Меняем имя и выводим в текстовом поле
        mainThread.setName("МОЙ НОМЕР ГРУППЫ: 10, НОМЕР ПО СПИСКУ: 9, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: Тихоокеанский рубеж");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(),	"Stack:	"	+	Arrays.toString(mainThread.getStackTrace()));

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        if (!binding.daysET.getText().toString().isEmpty() && !binding.lessonsET.getText().toString().isEmpty()){
                            int days = Integer.valueOf(binding.daysET.getText().toString());
                            int lessons = Integer.valueOf(binding.lessonsET.getText().toString());

                            runOnUiThread(() -> {
                                binding.textView.setText("Среднее кол-во пар в неделю: " + ((float) lessons / (float) days));
                            });
                        }
                    }
                }).start();
            }
        });
    }
}