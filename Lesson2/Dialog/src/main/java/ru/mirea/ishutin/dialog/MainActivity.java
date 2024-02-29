package ru.mirea.ishutin.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDialog(View view) {
        MyDialogActivity dialogFragment = new MyDialogActivity();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }

    public void showDateDialog(View view){
        MyDateDialogFragment datePicker = new MyDateDialogFragment(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //действия когда пользовательвыбрал дату
            }
        },2024, 1, 28);
        datePicker.show();//вызов
    }

    public void showTimeDialog(View view){
        MyTimeDialogFragment timePicker = new MyTimeDialogFragment(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //дейстия, когда пользователь выбрал время
            }
        },16,30, true);
        timePicker.show(); //вызов
    }

    public void showProgressDialog(View view){
        MyProgressDialogFragment progressDialog = new MyProgressDialogFragment(this);
        progressDialog.show();//вызов
    }

}