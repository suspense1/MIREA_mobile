package ru.mirea.ishutin.recyclerviewapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup();
    }

    private void setup() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        List<Event> events = getEvents();
        recyclerView.setAdapter(new EventAdapter(events));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private List<Event> getEvents() {
        List<Event> events = new ArrayList<>();

        events.add(new Event("The Moon Landing",
                "On July 20, 1969, Neil Armstrong and Buzz Aldrin became the first humans to walk on the Moon.",
                "moon_landing"));
        events.add(new Event("The Invention of the Printing Press",
                "Johannes Gutenberg's invention of the printing press around 1440 revolutionized communication and knowledge dissemination.",
                "printing_press"));
        events.add(new Event("The Discovery of Penicillin",
                "Alexander Fleming's accidental discovery of penicillin in 1928 led to the development of antibiotics and saved countless lives.",
                "penicillin"));
        events.add(new Event("The Fall of the Berlin Wall",
                "The fall of the Berlin Wall in 1989 symbolized the end of the Cold War and the reunification of Germany.",
                "berlin_wall"));
        events.add(new Event("The First Transatlantic Flight",
                "Charles Lindbergh's solo flight across the Atlantic Ocean in 1927 was a pioneering feat of aviation.",
                "transatlantic_flight"));

        return events;
    }
}