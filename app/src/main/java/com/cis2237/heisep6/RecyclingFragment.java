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
 * File: RecyclingFragment.java
 */

package com.cis2237.heisep6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclingFragment extends Fragment {

    private Button button;

    /**
     * Required empty public constructor.
     */
    public RecyclingFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RecycleFragment.
     */
    public static RecyclingFragment newInstance() {
        RecyclingFragment fragment = new RecyclingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycling, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.btnCheckWaterUse);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.navigateToTrashListFragment);
            }
        });
    }
}