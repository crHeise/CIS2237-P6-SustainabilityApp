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
 * File: RecyclableFragment.java
 */

package com.cis2237.heisep6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecyclableFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecyclableFragment extends Fragment {

    private TrashItem trashItem;
    private TrashViewModel viewModel;
    private int position;
    private TextView yesNoText;
    private TextView descriptionText;
    private TextView answerText;
    private ImageView yesNoImage;
    private ImageView itemImage;
    private Button backButton;

    /**
     * Required empty constructor.
     */
    public RecyclableFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment IsRecyclableFragment.
     */
    public static RecyclableFragment newInstance() {
        RecyclableFragment fragment = new RecyclableFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        trashItem = new TrashItem();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recyclable, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        yesNoText = view.findViewById(R.id.textYesNo);
        descriptionText = view.findViewById(R.id.textItemDescription);
        answerText = view.findViewById(R.id.textAnswer);
        yesNoImage = view.findViewById(R.id.imageViewYesNo);
        itemImage = view.findViewById(R.id.imageViewTrash);
        backButton = view.findViewById(R.id.btnBack);
        viewModel = new ViewModelProvider(requireActivity()).get(TrashViewModel.class);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigateUp();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        RecyclableFragmentArgs args = RecyclableFragmentArgs.fromBundle(getArguments());
        position = args.getPosition();
        trashItem = viewModel.getTrashItem(position);

        if(trashItem.isRecyclable()) {
            yesNoText.setText(R.string.yes);
            descriptionText.setText(trashItem.getDescription());
            answerText.setText(R.string.can_go);
            yesNoImage.setImageResource(R.drawable.ic_baseline_check_24);
        } else {
            yesNoText.setText(R.string.no);
            descriptionText.setText(trashItem.getDescription());
            answerText.setText(R.string.cannot_go);
            yesNoImage.setImageResource(R.drawable.ic_baseline_not_interested_24);
        }

        itemImage.setImageResource(trashItem.getImageFile());
    }
}