package com.example.pas_project.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pas_project.ViewModel.HomeViewModel;
import com.example.pas_project.R;
import com.example.pas_project.model.GameCategoryAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerHome);
        GameCategoryAdapter categoryAdapter = new GameCategoryAdapter(getContext());
    }
}