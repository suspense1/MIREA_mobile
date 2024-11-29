package ru.mirea.ishutin.retrofitapp;

import android.media.Image;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TodoViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView textViewTitle;
    CheckBox checkBoxCompleted;

    public TodoViewHolder(@NonNull View itemView) {
        super(itemView);

        textViewTitle = itemView.findViewById(R.id.textViewTitle);
        imageView = itemView.findViewById(R.id.imageView);
        checkBoxCompleted = itemView.findViewById(R.id.checkBoxCompleted);
    }
}
