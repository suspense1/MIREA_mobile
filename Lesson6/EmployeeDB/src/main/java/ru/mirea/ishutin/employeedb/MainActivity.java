package ru.mirea.ishutin.employeedb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase db = App.getInstance().getDatabase();
        SuperheroDao superheroDao = db.superheroDao();
        Superhero superhero = new Superhero();
        superhero.id = 1;
        superhero.name = "Elon Mask";
        superhero.power = 10000;

        superheroDao.insert(superhero);
        Superhero superhero2 = new Superhero();
        superhero2.id = 2;
        superhero2.name = "Iron Man";
        superhero2.power = 9999;

        // запись сотрудников в базу
        superheroDao.insert(superhero2);
        List<Superhero> superheroes = superheroDao.getAll();
        // Получение определенного работника с id = 1
        superhero = superheroDao.getById(1);

        // Обновление полей объекта
        superhero.power = 20000;
        superheroDao.update(superhero);

        Log.d("DATABASE SIGNAL", superhero.name + " " + superhero.power);
    }
}