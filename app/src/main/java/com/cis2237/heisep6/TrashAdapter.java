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
 * File: TrashAdapter.java
 */

package com.cis2237.heisep6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Class for adapting a list of TrashItems to a Recycler View.
 */
public class TrashAdapter extends RecyclerView.Adapter<TrashAdapter.TrashHolder> {

    private List<TrashItem> trashList;

    /**
     * Constructor for the TrashAdapter class.
     * @param trashList list of TrashItems to be assigned into class variable.
     */
    public TrashAdapter(List<TrashItem> trashList) { this.trashList = trashList; }

    @NonNull
    @Override
    public TrashHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new TrashHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TrashHolder holder, int position) {
        TrashItem trashItem = trashList.get(position);
        holder.bind(trashItem);
    }

    @Override
    public int getItemCount() {
        return trashList == null ? 0 : trashList.size();
    }

    /**
     * Mutator for the list of TrashItems.
     * @param trashList
     */
    public void setTrashList(List<TrashItem> trashList) { this.trashList = trashList; }

    /**
     * Holder class for TrashItems.
     */
    public static class TrashHolder extends RecyclerView.ViewHolder implements OnListItemClickListener {

        private TrashItem trashItem;
        private TextView txtDescription;
        private ImageView imageView;

        /**
         * Constructor for the TrashHolder class.
         * @param inflater the LayoutInflater.
         * @param parent the ViewGroup.
         */
        public TrashHolder(LayoutInflater inflater, @NonNull ViewGroup parent) {
            super(inflater.inflate(R.layout.card_list_item, parent, false));

            trashItem = new TrashItem();
            txtDescription = itemView.findViewById(R.id.itemDescription);
            imageView = itemView.findViewById(R.id.itemImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    onListItemClick(v, position);
                }
            });

        }

        /**
         * Method for binding the data of a TrashItem to its card view.
         * @param trashItem the TrashItem whose data the card will display.
         */
        public void bind(TrashItem trashItem) {
            this.trashItem = trashItem;
            txtDescription.setText(trashItem.getDescription());
            imageView.setImageResource(trashItem.getImageFile());
        }

        @Override
        public void onListItemClick(View view, int position) {
            TrashListFragmentDirections.NavigateToRecyclableFragment action =
                    TrashListFragmentDirections.navigateToRecyclableFragment();
            action.setPosition(position);
            Navigation.findNavController(view).navigate(action);
        }
    }
}
