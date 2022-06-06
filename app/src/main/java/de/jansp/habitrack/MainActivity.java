package de.jansp.habitrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;

    private List<Habit> habits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize data
        habits = new ArrayList<>();
        habits.add(new Habit("1", "2"));
        habits.add(new Habit("3", "4"));
        habits.add(new Habit("5", "6"));

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(null));
        rv.setAdapter(new HabitViewAdapter(habits));
    }
}