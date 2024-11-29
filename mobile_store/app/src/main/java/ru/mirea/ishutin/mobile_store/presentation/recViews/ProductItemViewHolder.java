package ru.mirea.ishutin.mobile_store.presentation.recViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.mirea.ishutin.mobile_store.R;

public class ProductItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView titleTextView;
    private TextView priceTextView;

    public ProductItemViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.product_image);
        titleTextView = itemView.findViewById(R.id.product_title);
        priceTextView = itemView.findViewById(R.id.product_price);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getTitleTextView() {
        return titleTextView;
    }

    public TextView getPriceTextView() {
        return priceTextView;
    }
}
