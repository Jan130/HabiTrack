package de.jansp.habitrack;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
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

    public static class CountHabitViewHolder extends HabitViewHolder {
        EditText count;

        public CountHabitViewHolder(View itemView){
            super(itemView);
            viewType = ViewType.countHabit;
            count = itemView.findViewById(R.id.count);
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
            case ViewType.countHabit: return new CountHabitViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.habit_count, parent, false));
            default: return null;
        }
    }

    @Override
    public void onBindViewHolder(HabitViewAdapter.HabitViewHolder holder, int position) {
        holder.name.setText(habits.get(position).name);

        switch(holder.getItemViewType()) {
            case ViewType.checkboxHabit:
                ((CheckboxHabitViewHolder) holder).box.setChecked(((HabitCheckbox) habits.get(position)).getChecked(currentDate));
                ((CheckboxHabitViewHolder) holder).box.setOnClickListener(view -> {
                    boolean checked = ((CheckBox) view).isChecked();
                    ((HabitCheckbox) habits.get(position)).setChecked(currentDate, checked);
                });
                break;
            case ViewType.countHabit:
                ((CountHabitViewHolder) holder).count.setText(Integer.toString(((HabitCount) habits.get(position)).getCount(currentDate)));
                ((CountHabitViewHolder) holder).count.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        int count = 0;
                        try {
                            count = Integer.parseInt(charSequence.toString());
                        } catch(NumberFormatException e) {}
                        ((HabitCount) habits.get(position)).setCount(currentDate, count);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });
                break;
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
