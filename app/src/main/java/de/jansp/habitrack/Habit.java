package de.jansp.habitrack;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Habit {
    String name;
    HashMap<Date, Boolean> done;

    private final SimpleDateFormat timeResetFormatter;

    public Habit(String name){
        this.name = name;
        this.done = new HashMap<>();

        timeResetFormatter = new SimpleDateFormat("yyy-MM-dd");
    }

    public void setDone(Date day, boolean done){
        try{
            Date dateOnly = timeResetFormatter.parse(timeResetFormatter.format(day));
            this.done.put(dateOnly, done);
        } catch(ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean getDone(Date day){
        try {
            Date dateOnly = timeResetFormatter.parse(timeResetFormatter.format(day));
            if(this.done.containsKey(dateOnly)){
                return this.done.get(dateOnly);
            } else {
                return false;
            }
        } catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
