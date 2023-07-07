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
 * File: MainActivity.java
 */

package com.cis2237.heisep6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        NavHostFragment navHostFragment = (NavHostFragment)getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        NavController navController = NavHostFragment.findNavController(navHostFragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}