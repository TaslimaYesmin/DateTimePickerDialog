package com.example.datetimepickerdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity<v> extends AppCompatActivity implements View.OnClickListener {
    //Button btnDatePicker, btnTimePicker;
    TextView txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = (TextView) findViewById(R.id.btn_date);
        txtTime = (TextView) findViewById(R.id.btn_time);

        txtDate.setOnClickListener(this);
        txtTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == txtDate) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            final String CurrentDate = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                           // String date = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                            txtDate.setText(CurrentDate);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == txtTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog;
           timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hour,
                                              int minute) {
                            String AM_PM ;
                            if(hour < 12) {
                                AM_PM = "AM";
                            } else {
                                AM_PM = "PM";
                            }
                            String time =hour + " : " + minute + " " + AM_PM;
                            txtTime.setText(time);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }
    }
}