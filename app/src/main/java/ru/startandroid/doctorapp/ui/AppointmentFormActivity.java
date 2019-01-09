package ru.startandroid.doctorapp.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import ru.startandroid.doctorapp.R;

public class AppointmentFormActivity extends Activity {

    int DIALOG_DATE = 1;
    int myYear = 2018;
    int myMonth = 05;
    int myDay = 04;
    TextView tvDate;


    int DIALOG_TIME = 2;
    int myHour = 14;
    int myMinute = 35;
    TextView tvTime;

    /** Called when the activity is first created. */

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_form);
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvTime = (TextView) findViewById(R.id.tvTime);
    }

    public void onclick(View view) {

        showDialog(DIALOG_DATE);
        showDialog(DIALOG_TIME);
    }


    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
            return tpd;
        }

        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack1, myHour, myMinute, true);
            return tpd;
        }
       // return super.onCreateDialog(id);
        return super.onCreateDialog(id);

    }

    OnDateSetListener myCallBack = new OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            tvDate.setText("Today is " + myDay + "/" + myMonth + "/" + myYear);
        }
    };

//    protected Dialog onCreateDialog2(int id) {
//        if (id == DIALOG_TIME) {
//            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack1, myHour, myMinute, true);
//            return tpd;
//        }
//        return super.onCreateDialog(id);
//    }

    TimePickerDialog.OnTimeSetListener myCallBack1 = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            tvTime.setText("Time is " + myHour + " hours " + myMinute + " minutes");
        }
    };
}



































//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//
//import ru.startandroid.doctorapp.R;
//
//public class AppointmentFormActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_appointment_form);
//    }
//
//
//}
