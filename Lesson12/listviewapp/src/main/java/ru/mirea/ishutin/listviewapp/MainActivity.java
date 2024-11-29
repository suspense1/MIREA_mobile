package ru.mirea.ishutin.listviewapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String[] realTitles = {
                "The Handmaid's Tale", "The Kite Runner", "The Book Thief",
                "The Hunger Games", "The Girl with the Dragon Tattoo", "The Girl on the Train",
                "The Silent Patient", "The Revenant", "The Martian",
                "Educated", "Where the Crawdads Sing", "Little Fires Everywhere",
                "Eleanor Oliphant Is Completely Fine", "The Nightingale", "The Seven Husbands of Evelyn Hugo",
                "Circe", "The Song of Achilles", "Mythos",
                "Sapiens: A Brief History of Humankind", "Homo Deus: A Brief History of Tomorrow", "21 Lessons for the 21st Century",
                "Thinking, Fast and Slow", "The Power of Habit", "Quiet: The Power of Introverts in a World That Can't Stop Talking",
                "Atomic Habits", "Daring Greatly", "The 4-Hour Workweek",
                "The Lean Startup", "Zero to One", "The Hard Thing About Hard Things"
        };
        List<String> bookTitlesList = Arrays.asList(realTitles);

        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text1, bookTitlesList);
        listView.setAdapter(arrayAdapter);
    }
}