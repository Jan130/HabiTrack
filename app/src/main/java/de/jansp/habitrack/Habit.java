package de.jansp.habitrack;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Habit {
    String name;
    HashMap<Date, Boolean> done;

    private final SimpleDateFormat sdf;

    public Habit(String name){
        this.name = name;
        this.done = new HashMap<>();

        sdf = new SimpleDateFormat("yyy-MM-dd");
    }

    public void setDone(Date day, boolean done){
        try{
            Date dateOnly = sdf.parse(sdf.format(day));
            this.done.put(dateOnly, done);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean getDone(Date day){
        try {
            Date dateOnly = sdf.parse(sdf.format(day));
            return this.done.get(dateOnly);
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
