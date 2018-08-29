package id.liqu.laundry.liquid.ui;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;


import java.util.Calendar;
import id.liqu.laundry.liquid.R;
/**
 * Created by user on 12/04/18.
 */
public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        TextInputEditText tv1= (TextInputEditText) getActivity().findViewById(R.id.date);
        tv1.setText(view.getDayOfMonth()+"/"+view.getMonth()+"/"+view.getYear());

    }
    public void onDateSet_2(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        TextInputEditText tv1= (TextInputEditText) getActivity().findViewById(R.id.date_2);
        tv1.setText(view.getDayOfMonth()+"/"+view.getMonth()+"/"+view.getYear());

    }
}
