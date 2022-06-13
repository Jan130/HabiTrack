package de.jansp.habitrack;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class HabitCount extends Habit {
    HashMap<Date, Integer> count;

    public HabitCount(String name) {
        super(name);

        this.count = new HashMap<>();
        viewType = HabitViewAdapter.ViewType.countHabit;
    }

    public void setCount(Date day, int count){
        try{
            Date dateOnly = timeResetFormatter.parse(timeResetFormatter.format(day));
            this.count.put(dateOnly, count);
        } catch(ParseException e){
            System.out.println(e.getMessage());
        }
    }

    public int getCount(Date day){
        try {
            Date dateOnly = timeResetFormatter.parse(timeResetFormatter.format(day));
            if(this.count.containsKey(dateOnly)){
                return this.count.get(dateOnly);
            } else {
                return 0;
            }
        } catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
