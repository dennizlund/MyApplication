package com.dennis.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private TextWatcher watcherLeft = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {

            editTextRight.removeTextChangedListener(watcherRight);
            valuesChanged();
            editTextRight.addTextChangedListener(watcherRight);
        }
    };
    private TextWatcher watcherRight = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {

            editTextLeft.removeTextChangedListener(watcherLeft);
            valuesChanged(false);
            editTextLeft.addTextChangedListener(watcherLeft);
        }
    };

    public HomeFragment() {
        currencyCalculation = new CurrencyCalculation();
    }

    private CurrencyCalculation currencyCalculation;

    private List<CurrencyRate> currencyRateList = RateList.getRates();

    Spinner spinnerLeft;
    Spinner spinnerRight;
    EditText editTextLeft;
    EditText editTextRight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        spinnerLeft = view.findViewById(R.id.spinnerLeft);
        spinnerRight = view.findViewById(R.id.spinnerRight);
        editTextLeft = view.findViewById(R.id.editTextLeft);
        editTextRight = view.findViewById(R.id.editTextRight);

        spinnerLeft.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CurrencyRate currency = (CurrencyRate) spinnerLeft.getSelectedItem();

                currencyCalculation.setFromRate(currency.getRate());
                valuesChanged();
                //editTextLeft.setText(currency.getRate().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerRight.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CurrencyRate currency = (CurrencyRate) spinnerRight.getSelectedItem();

                currencyCalculation.setToRate(currency.getRate());
                valuesChanged();
                //editTextRight.setText(currency.getRate().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        editTextLeft.addTextChangedListener(watcherLeft);

        editTextRight.addTextChangedListener(watcherRight);


        ArrayAdapter<CurrencyRate> dataAdapter = new ArrayAdapter<CurrencyRate>(this.getActivity(), R.layout.spinner_dropdown, currencyRateList);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinnerRight.setAdapter(dataAdapter);
        spinnerLeft.setAdapter(dataAdapter);

        // Inflate the layout for this fragment
        return view;
    }

    private void valuesChanged() {
        //txt2 = calc(txt1.value)
        String txtValue = editTextLeft.getText().toString();
        if (!txtValue.equals("")) {
            double doubleVal = Double.parseDouble(txtValue);
            editTextRight.setText(String.valueOf(currencyCalculation.Calculate(doubleVal, true)));
        } else {
            editTextRight.setText("");
        }
    }

    private void valuesChanged(boolean toToFrom) {
        //txt2 = calc(txt1.value)
        if (toToFrom) {
            valuesChanged();
        } else {
            String txtValue = editTextRight.getText().toString();
            if (!txtValue.equals("")) {
                double doubleVal = Double.parseDouble(txtValue);
                editTextLeft.setText(String.valueOf(currencyCalculation.Calculate(doubleVal, toToFrom)));
            } else {
                editTextLeft.setText("");
            }
        }
    }


    //On txt1 changed
    //On txt2 changed
}
