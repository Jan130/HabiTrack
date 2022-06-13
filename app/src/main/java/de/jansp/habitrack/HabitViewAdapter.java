package de.jansp.habitrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HabitViewAdapter extends RecyclerView.Adapter<HabitViewAdapter.HabitViewHolder> {
    public static class ViewType{
        public static final int checkboxHabit = 0;
        public static final int countHabit = 1;
        public static final int selectHabit = 2;
    }

    public static class HabitViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        int viewType;

        public HabitViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            name = itemView.findViewById(R.id.name);
        }
    }

    public static class CheckboxHabitViewHolder extends HabitViewHolder {
        CheckBox box;

        public CheckboxHabitViewHolder(View itemView) {
            super(itemView);
            viewType = ViewType.checkboxHabit;
            box = itemView.findViewById(R.id.box);
        }
    }

    List<Habit> habits;

    private Date currentDate;

    public HabitViewAdapter(List<Habit> habits){
        this.habits = habits;
        this.currentDate = Calendar.getInstance().getTime();
    }

    @Override
    public int getItemCount() {
        return habits.size();
    }

    @Override
    public HabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch(viewType) {
            case ViewType.checkboxHabit: return new CheckboxHabitViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.habit_checkbox, parent, false));
            default: return null;
        }
    }

    @Override
    public void onBindViewHolder(HabitViewAdapter.HabitViewHolder holder, int position) {
        holder.name.setText(habits.get(position).name);

        switch(holder.getItemViewType()) {
            case ViewType.checkboxHabit:
                CheckboxHabitViewHolder h = (CheckboxHabitViewHolder) holder;
                h.box.setChecked(habits.get(position).getChecked(currentDate));
                h.box.setOnClickListener(view -> {
                    boolean checked = ((CheckBox) view).isChecked();
                    habits.get(position).setChecked(currentDate, checked);
                });
        }


    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemViewType(int position) {
        return habits.get(position).viewType;
    }

    public void setDate(Date date){
        currentDate = date;
        notifyDataSetChanged();
    }
}
