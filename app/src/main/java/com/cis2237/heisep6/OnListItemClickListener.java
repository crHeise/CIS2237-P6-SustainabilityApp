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
 * File: OnListItemClickListener.java
 */

package com.cis2237.heisep6;

import android.view.View;

/**
 * Interface for implementing an listener for a list item click.
 */
public interface OnListItemClickListener {
    void onListItemClick(View view, int position);
}
