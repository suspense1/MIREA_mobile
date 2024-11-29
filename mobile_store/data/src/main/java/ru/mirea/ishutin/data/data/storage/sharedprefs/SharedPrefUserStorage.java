package ru.mirea.ishutin.data.data.storage.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;

import ru.mirea.ishutin.data.data.storage.UserStorage;
import ru.mirea.ishutin.data.data.storage.models.User;


public class SharedPrefUserStorage implements UserStorage {

    private static final String SHARED_PREFS_NAME = "users_data";
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_PASSWORD = "user_password";
    private final SharedPreferences sharedPreferences;
    public SharedPrefUserStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public User get() {
        String id = sharedPreferences.getString(KEY_USER_ID, "0");
        String name = sharedPreferences.getString(KEY_USER_NAME, "");
        String email = sharedPreferences.getString(KEY_USER_EMAIL, "");
        String password = sharedPreferences.getString(KEY_USER_PASSWORD, "");

        return new User(id, name, email, password, new Date());
    }

    @Override
    public boolean save(User user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_USER_ID, user.getId());
        editor.putString(SHARED_PREFS_NAME, user.getName());
        editor.putString(KEY_USER_EMAIL, user.getEmail());
        editor.putString(KEY_USER_PASSWORD, user.getPassword());
        editor.apply();

        return true;
    }
}
