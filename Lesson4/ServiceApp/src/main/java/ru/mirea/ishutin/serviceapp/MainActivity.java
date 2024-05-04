package ru.mirea.ishutin.serviceapp;

import static android.Manifest.permission.FOREGROUND_SERVICE;
import static android.Manifest.permission.POST_NOTIFICATIONS;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import ru.mirea.ishutin.serviceapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int PermissionCode = 200;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if	(ContextCompat.checkSelfPermission(this,	POST_NOTIFICATIONS)	==	PackageManager.PERMISSION_GRANTED)	{
            Log.d(MainActivity.class.getSimpleName().toString(),	"Разрешения получены");
        }	else	{
            Log.d(MainActivity.class.getSimpleName().toString(),	"Нет разрешений!");
            ActivityCompat.requestPermissions(this,	new	String[]{POST_NOTIFICATIONS,	FOREGROUND_SERVICE},	PermissionCode);
        }

        binding.btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    stopService(new Intent(getApplicationContext(), PlayerService.class));
                }else {
                    Intent service = new Intent(getApplicationContext(), PlayerService.class);
                    ContextCompat.startForegroundService(getApplicationContext(), service);
                }

                isPlaying = !isPlaying;
                binding.btnPlayPause.setImageDrawable(isPlaying ? getResources().getDrawable(R.drawable.pause) : getResources().getDrawable(R.drawable.play));
            }
        });
    }
}