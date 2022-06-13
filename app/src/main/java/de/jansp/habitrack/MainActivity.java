package de.jansp.habitrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private TextView dateView;

    private List<Habit> habits;

    private SimpleDateFormat dateFormat;
    private Date currentDate;
    private final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

    private Button prevButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize data
        habits = new ArrayList<>();
        Habit habit1 = new Habit("Liegestütze");
        habit1.setChecked(Calendar.getInstance().getTime(), false);
        habits.add(habit1);

        // Initialize RecyclerView
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(null));
        rv.setAdapter(new HabitViewAdapter(habits));

        // Initialize TextView for date
        dateView = findViewById(R.id.dateView);
        dateFormat = new SimpleDateFormat("dd.MM.yy");
        setDate(Calendar.getInstance().getTime());

        // Create onclick actions for previous and next buttons
        prevButton = findViewById(R.id.prevDay);
        nextButton = findViewById(R.id.nextDay);
        prevButton.setOnClickListener(view -> {
            setDate(new Date(currentDate.getTime() - MILLIS_IN_A_DAY));
        });
        nextButton.setOnClickListener(view -> {
            setDate(new Date(currentDate.getTime() + MILLIS_IN_A_DAY));
        });
    }

    private void setDate(Date date){
        currentDate = date;
        dateView.setText(dateFormat.format(currentDate));
        HabitViewAdapter adap = (HabitViewAdapter) rv.getAdapter();
        adap.setDate(currentDate);
    }
}