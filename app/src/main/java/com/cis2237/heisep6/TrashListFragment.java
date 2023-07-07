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
 * File: TrashListFragment.java
 */

package com.cis2237.heisep6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TrashListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TrashListFragment extends Fragment {

    private RecyclerView recyclerView;
    private TrashAdapter trashAdapter;
    private TrashViewModel trashViewModel;

    /**
     * Required empty public constructor
     */
    public TrashListFragment() { }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TrashListFragment.
     */
    public static TrashListFragment newInstance() {
        TrashListFragment fragment = new TrashListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trash_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        trashViewModel = new ViewModelProvider(requireActivity()).get(TrashViewModel.class);

        setUpRecyclerView(view);
    }

    private void setUpRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.trash_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<TrashItem> trashItems = trashViewModel.getTrashList();
        trashAdapter = new TrashAdapter(trashItems);
        recyclerView.setAdapter(trashAdapter);
        trashAdapter.setTrashList(trashItems);
    }
}