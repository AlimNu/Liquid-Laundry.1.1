package id.liqu.laundry.liquid.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import id.liqu.laundry.liquid.R;

public class TimePickerFragment2 extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        // Create a new instance of DatePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hourOfDay, minute,true);


    }



    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextInputEditText tv1= (TextInputEditText) getActivity().findViewById(R.id.time_2);
        if(minute<10){
            String min ="0"+minute;
            tv1.setText(hourOfDay+":"+min);
        }else{
            tv1.setText(hourOfDay+":"+minute);
        }

    }
}
