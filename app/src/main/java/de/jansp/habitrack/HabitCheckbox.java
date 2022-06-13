package de.jansp.habitrack;

import java.text.ParseException;
import java.util.Date;

public class HabitCheckbox extends Habit {

    public HabitCheckbox(String name) {
        super(name);

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
