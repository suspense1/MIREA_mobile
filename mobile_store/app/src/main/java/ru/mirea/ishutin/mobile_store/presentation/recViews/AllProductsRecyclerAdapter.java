package ru.mirea.ishutin.mobile_store.presentation.recViews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ru.mirea.ishutin.domain.domain.models.Product;
import ru.mirea.ishutin.mobile_store.R;

public class AllProductsRecyclerAdapter extends RecyclerView.Adapter<ProductItemViewHolder> {

    private List<Product> products;
    private Context context;

    public AllProductsRecyclerAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);

        return new ProductItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductItemViewHolder holder, int position) {
        Product product = products.get(position);

        Glide.with(context)
                .load("https://free-e-store-api.onrender.com/images/products/" + product.getImage())
                .into(holder.getImageView());

        holder.getTitleTextView().setText(product.getName());
        int price = product.getPrice();
        holder.getPriceTextView().setText("" + price);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
