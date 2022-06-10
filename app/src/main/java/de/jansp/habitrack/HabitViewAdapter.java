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

    public HabitViewAdapter(List<Habit> habits){
        this.habits = habits;
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
        holder.done.setChecked(habits.get(position).getDone(Calendar.getInstance().getTime()));

        holder.done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                habits.get(position).setDone(Calendar.getInstance().getTime(), checked);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
