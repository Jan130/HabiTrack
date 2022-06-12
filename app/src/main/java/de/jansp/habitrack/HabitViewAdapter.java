package de.jansp.habitrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HabitViewAdapter extends RecyclerView.Adapter<HabitViewAdapter.HabitViewHolder> {
    public static class HabitViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        CheckBox done;

        public HabitViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            name = itemView.findViewById(R.id.name);
            done = itemView.findViewById(R.id.done);
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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new HabitViewHolder(v);
    }

    @Override
    public void onBindViewHolder(HabitViewAdapter.HabitViewHolder holder, int position) {
        holder.name.setText(habits.get(position).name);
        holder.done.setChecked(habits.get(position).getDone(currentDate));

        holder.done.setOnClickListener(view -> {
            boolean checked = ((CheckBox) view).isChecked();
            habits.get(position).setDone(currentDate, checked);
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setDate(Date date){
        currentDate = date;
        notifyDataSetChanged();
    }
}
