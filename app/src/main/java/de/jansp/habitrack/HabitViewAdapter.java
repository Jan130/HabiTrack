package de.jansp.habitrack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HabitViewAdapter extends RecyclerView.Adapter<HabitViewAdapter.HabitViewHolder> {
    public static class HabitViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text1;
        TextView text2;

        public HabitViewHolder(View itemView){
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            text1 = itemView.findViewById(R.id.text1);
            text2 = itemView.findViewById(R.id.text2);
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
        holder.text1.setText(habits.get(position).text1);
        holder.text2.setText(habits.get(position).text2);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
