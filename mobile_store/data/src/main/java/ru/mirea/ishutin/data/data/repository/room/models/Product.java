package ru.mirea.ishutin.data.data.repository.room.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Product {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private String id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "price")
    private String price;

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPrice(){
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}