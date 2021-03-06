package de.jansp.habitrack;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class HabitCheckbox extends Habit {
    HashMap<Date, Boolean> done;

    public HabitCheckbox(String name) {
        super(name);

        this.done = new HashMap<>();
        viewType = HabitViewAdapter.ViewType.checkboxHabit;
    }

    public void setChecked(Date day, boolean done){
        try{
            Date dateOnly = timeResetFormatter.parse(timeResetFormatter.format(day));
            this.done.put(dateOnly, done);
        } catch(ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean getChecked(Date day){
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
