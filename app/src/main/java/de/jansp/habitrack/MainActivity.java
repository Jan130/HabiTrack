package de.jansp.habitrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;
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
        Habit habit1 = new Habit("Liegestütze");
        habit1.setDone(Calendar.getInstance().getTime(), true);
        habits.add(habit1);

        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(null));
        rv.setAdapter(new HabitViewAdapter(habits));
    }
}