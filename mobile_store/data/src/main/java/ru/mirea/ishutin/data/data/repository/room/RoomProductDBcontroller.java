package ru.mirea.ishutin.data.data.repository.room;

import android.content.Context;

import androidx.room.Room;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.mirea.ishutin.data.data.repository.room.models.Product;

public class RoomProductDBcontroller implements ProductDBcontroller {

    private ProductDB productDB;
    private Context context;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public RoomProductDBcontroller(Context context){
        this.context = context;

        productDB = Room.databaseBuilder(context, ProductDB.class, "ProductDB").build();
    }

    @Override
    public void getProduct() {
        executorService.execute(() -> productDB.getProductDAO().getAllProducts());
    }

    @Override
    public void addProduct(Product product) {
        executorService.execute(() -> productDB.getProductDAO().addProduct(product));
    }

    @Override
    public void deleteProduct(String name) {
        executorService.execute(() -> productDB.getProductDAO().deleteProduct(name));
    }
}
