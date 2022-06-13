package de.jansp.habitrack;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Habit {
    String name;

    final SimpleDateFormat timeResetFormatter;

    public int viewType;

    public Habit(String name){
        this.name = name;

        timeResetFormatter = new SimpleDateFormat("yyy-MM-dd");
    }
}
