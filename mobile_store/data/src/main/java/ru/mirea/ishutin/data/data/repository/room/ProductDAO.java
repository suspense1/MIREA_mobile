package ru.mirea.ishutin.data.data.repository.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import ru.mirea.ishutin.data.data.repository.room.models.Product;

@Dao
public interface ProductDAO {

    @Query("select * from product")
    public List<Product> getAllProducts();

    @Query("select * from product where name==:name")
    public List<Product> getProductByName(String name);

    @Insert
    public  void addProduct(Product product);

    @Update
    public void changeProduct(Product product);

    @Query("delete from product where name==:name")
    public void deleteProduct(String name);

    @Query("delete from product")
    public void clear();
}
