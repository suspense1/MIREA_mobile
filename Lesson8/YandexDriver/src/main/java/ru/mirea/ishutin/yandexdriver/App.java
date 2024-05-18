package ru.mirea.ishutin.yandexdriver;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class App extends Application {
    private final String MAPKIT_API_KEY = "ea6d8017-ee75-4331-b5f7-deced6b138a8";

    @Override
    public void onCreate() {
        super.onCreate();
        MapKitFactory.setApiKey(MAPKIT_API_KEY);
    }
}
