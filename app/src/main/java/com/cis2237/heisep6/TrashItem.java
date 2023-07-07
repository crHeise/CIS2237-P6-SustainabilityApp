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
 * File: TrashItem.java
 */

package com.cis2237.heisep6;

/**
 * Class representing a piece of trash.
 */
public class TrashItem {

    private int description;
    private boolean recyclable;
    private int imageFile;

    /**
     * Default constructor for TrashItem.
     */
    public TrashItem() {
        this(R.string.no_name, false, R.drawable.ic_baseline_insert_photo_24);
    }

    /**
     * Constructor for TrashItem.
     * @param description short description of the TrashItem
     * @param recyclable whether or not the item is recyclable.
     * @param imageFile the image to be displayed that represents the TrashItem.
     */
    public TrashItem(int description, boolean recyclable, int imageFile) {
        this.description = description;
        this.recyclable = recyclable;
        this.imageFile = imageFile;
    }

    /**
     * Accessor for the description of a TrashItem.
     * @return the description of the TrashItem.
     */
    public int getDescription() {
        return description;
    }

    /**
     * Accessor for recyclable variable of a TrashItem.
     * @return boolean of whether or not the item is recyclable.
     */
    public boolean isRecyclable() {
        return recyclable;
    }

    /**
     * Accessor for the imageFile of a TrashItem.
     * @return the imageFile for a TrashItem.
     */
    public int getImageFile() {
        return imageFile;
    }
}
