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
 * File: TrashViewModel.java
 */

package com.cis2237.heisep6;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * ViewModel class for TrashItems.
 */
public class TrashViewModel extends ViewModel {

    private List<TrashItem> trashList;

    public TrashViewModel() {
        trashList = new ArrayList<>();
        fillTrashList();
    }

    /**
     * Accessor for the list of TrashItems.
     * @return full list of TrashItems.
     */
    public List<TrashItem> getTrashList() { return trashList; }

    /**
     * Accessor for a TrashItem at a given position in the list of TrashItems.
     * @param position of the TrashItem to be returned.
     * @return the TrashItem at the given position.
     */
    public TrashItem getTrashItem(int position) { return trashList.get(position); }

    private void fillTrashList() {
        trashList.add(new TrashItem(R.string.aluminum_cans, true, R.drawable.ic_sodacan));
        trashList.add(new TrashItem(R.string.chip_bags, false, R.drawable.chips));
        trashList.add(new TrashItem(R.string.candy_wrappers, false, R.drawable.ic_candy_icon));
        trashList.add(new TrashItem(R.string.cardboard, true, R.drawable.ic_cardboard_box));
        trashList.add(new TrashItem(R.string.cardboard_with_food, false, R.drawable.ic_paperbag));
        trashList.add(new TrashItem(R.string.copy_paper, true, R.drawable.ic_copypaper));
        trashList.add(new TrashItem(R.string.coffee_cups, false, R.drawable.ic_coffeecup));
        trashList.add(new TrashItem(R.string.food_wrappers, false, R.drawable.ic_foodwrapper));
        trashList.add(new TrashItem(R.string.full_bottles, false, R.drawable.ic_fullbottle));
        trashList.add(new TrashItem(R.string.glass_bottles, false, R.drawable.ic_glass_jar));
        trashList.add(new TrashItem(R.string.coffee_lids, true, R.drawable.ic_coffeelid));
        trashList.add(new TrashItem(R.string.milk_jugs, true, R.drawable.ic_milkcarton));
        trashList.add(new TrashItem(R.string.newspapers, true, R.drawable.ic_newspaper));
        trashList.add(new TrashItem(R.string.paper, true, R.drawable.ic_linedpaper));
        trashList.add(new TrashItem(R.string.envelopes, true, R.drawable.ic_envelope));
        trashList.add(new TrashItem(R.string.plastic, true, R.drawable.ic_plasticcup));
        trashList.add(new TrashItem(R.string.plastic_bottles, true, R.drawable.ic_bottle_water_plastic));
        trashList.add(new TrashItem(R.string.shopping_bags, false, R.drawable.ic_shoppingbag));
        trashList.add(new TrashItem(R.string.styrofoam_containers, false, R.drawable.ic_coffee_to_go));
        trashList.add(new TrashItem(R.string.tin_or_steel, true, R.drawable.ic_can));
    }
}
