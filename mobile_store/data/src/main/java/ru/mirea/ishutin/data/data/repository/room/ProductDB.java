package ru.mirea.ishutin.data.data.repository.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.mirea.ishutin.data.data.repository.room.models.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDB extends RoomDatabase {

    public abstract ProductDAO getProductDAO();
}
