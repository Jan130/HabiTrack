package de.jansp.habitrack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Habit {
    String name;
    HashMap<Date, Boolean> done;

    final SimpleDateFormat timeResetFormatter;

    public int viewType;

    public Habit(String name){
        this.name = name;
        this.done = new HashMap<>();

        timeResetFormatter = new SimpleDateFormat("yyy-MM-dd");
    }
}
