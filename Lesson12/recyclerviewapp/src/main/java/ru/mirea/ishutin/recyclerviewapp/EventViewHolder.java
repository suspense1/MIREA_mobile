package ru.mirea.ishutin.recyclerviewapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;
    private TextView descTextView;
    private ImageView imageView;

    public EventViewHolder(@NonNull View itemView) {
        super(itemView);

        titleTextView = itemView.findViewById(R.id.event_title_text_view);
        descTextView = itemView.findViewById(R.id.event_desc_text_view);
        imageView = itemView.findViewById(R.id.event_image_view);
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getDescTextView() {
        return descTextView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
