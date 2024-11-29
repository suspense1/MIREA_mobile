package ru.mirea.ishutin.recyclerviewapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private List<Event> events;
    private Context context;

    public EventAdapter(List<Event> events) {
        this.events = events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context).inflate(R.layout.view_item, parent, false);

        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = this.events.get(position);

        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(event.getImageId(), "drawable", pkgName);

        holder.getTitleTextView().setText(event.getTitle());
        holder.getDescTextView().setText(event.getDesc());
        holder.getImageView().setImageResource(resID);
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
