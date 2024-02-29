package ru.mirea.ishutin.favoritebook;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Bundle args = getIntent().getExtras();
        if (args != null){
            TextView ageView = findViewById(R.id.textView2);
            String book = args.getString(MainActivity.KEY);
            ageView.setText("Любимая книга разработчика - " + book);
        }

    }

    public void sendData(View view){

        EditText editText = findViewById(R.id.editTextText);
        Intent data = new Intent(this, MainActivity.class);
        data.putExtra(MainActivity.USER_MESSAGE, editText.getText().toString());
        setResult(Activity.RESULT_OK,data);
        finish();
    }
}