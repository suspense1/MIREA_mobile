package ru.mirea.ishutin.data.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.time.LocalDate;

import ru.mirea.ishutin.data.data.storage.ProductStorage;

import ru.mirea.ishutin.data.data.storage.models.Product;

public class SharedPrefProductStorage  implements ProductStorage {

    private static final String SHARED_PREFS_NAME = "shared_prefs_name";
    private static final String KEY = "product_name";
    private static final String DATE_KEY = "product_date";
    private static final String ID_KEY = "product_id";
    private static final String PRICE_KEY = "product_price";
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPrefProductStorage(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public Product get(){
        String productName = sharedPreferences.getString(KEY, "unknown");
        String productPrice = sharedPreferences.getString(PRICE_KEY, "0");
        String productDate = sharedPreferences.getString(DATE_KEY, String.valueOf(LocalDate.now()));
        int productId = sharedPreferences.getInt(ID_KEY, -1);
        return new Product(productId, productName, productPrice, productDate);
    }

    @Override
    public Product[] getFavs() {
        return null;
    }

    @Override
    public Product[] getCart() {
        return null;
    }

    @Override
    public Product[] getAll() {
        return null;
    }

    @Override
    public boolean save(Product product) {
        sharedPreferences.edit().putString(KEY, product.getName());
        sharedPreferences.edit().putString(PRICE_KEY, product.getPrice());
        sharedPreferences.edit().putString(DATE_KEY, String.valueOf(LocalDate.now()));
        sharedPreferences.edit().putInt(ID_KEY, 1);
        sharedPreferences.edit().commit();
        return true;
    }

    @Override
    public boolean addToFavs(Product product) {
        return true;
    }

    @Override
    public boolean addToCart(Product product) {
        return true;
    }
}
