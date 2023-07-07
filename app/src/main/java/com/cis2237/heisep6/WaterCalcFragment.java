/*
 * Programmer: Chris Heise (crheise@icloud.com)
 * School: Central New Mexico Community College
 * Course: CIS 2237 Android Programming I
 * Instructor: Ivonne Nelson
 * Date: 23 November 2021
 *
 * Program: P6 Sustainability App
 * Purpose: Use Java and a VMC pattern to create
 *          an app about sustainability.
 * File: WaterCalcFragment.java
 */

package com.cis2237.heisep6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WaterCalcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WaterCalcFragment extends Fragment {

    private TextView gallonsText;
    private TextView minutesText;
    private RadioGroup rbGroup;
    private RadioButton showerButton;
    private RadioButton bathButton;
    private RadioButton kitchenButton;
    private ImageButton downButton;
    private ImageButton upButton;
    private Button backButton;

    private int minutes;
    private double gallons;
    private double gpm;

    /**
     * Required empty public constructor
     */
    public WaterCalcFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment WaterCalcFragment.
     */
    public static WaterCalcFragment newInstance() {
        WaterCalcFragment fragment = new WaterCalcFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_water_calc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gallonsText = view.findViewById(R.id.gallonsOfWaterTextView);
        minutesText = view.findViewById(R.id.minutesTextView);
        rbGroup = view.findViewById(R.id.rbGroupFaucet);
        showerButton = view.findViewById(R.id.rbShower);
        bathButton = view.findViewById(R.id.rbBath);
        kitchenButton = view.findViewById(R.id.rbKitchen);
        downButton = view.findViewById(R.id.imageButtonDown);
        upButton = view.findViewById(R.id.imageButtonUp);
        backButton = view.findViewById(R.id.backButton);

        resetVariables();

        //Check if faucet type is changed and reset variables if so
        rbGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetVariables();
            }
        });

        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showerButton.isChecked()) {
                    gpm = 2.0;
                }
                else if (bathButton.isChecked()) {
                    gpm = 1.0;
                }
                else {
                    gpm = 1.5;
                }
                decrementWaterUsed(gpm);
            }
        });

        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showerButton.isChecked()) {
                    gpm = 2.0;
                }
                else if (bathButton.isChecked()) {
                    gpm = 1.0;
                }
                else {
                    gpm = 1.5;
                }
                incrementWaterUsed(gpm);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigateUp();
            }
        });
    }

    private void decrementWaterUsed(double gpm) {
        if (gallons > 0.0 && minutes > 0) {
            gallons -= gpm;
            minutes -= 1;
            setDisplayText();
        }
    }

    private void incrementWaterUsed(double gpm) {
        gallons += gpm;
        minutes += 1;
        setDisplayText();
    }

    private void resetVariables() {
        minutes = 0;
        gallons = 0.0;
        setDisplayText();
    }

    private void setDisplayText() {
        minutesText.setText(String.valueOf(minutes));
        gallonsText.setText(String.valueOf(gallons));
    }
}