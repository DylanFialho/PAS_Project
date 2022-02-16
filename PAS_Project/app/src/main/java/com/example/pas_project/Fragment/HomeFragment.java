package com.example.pas_project.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_project.R;
import com.example.pas_project.ViewModel.HomeViewModel;
import com.example.pas_project.model.Constants;
import com.example.pas_project.model.GameCategoryAdapter;
import com.example.pas_project.model.GameListCategory;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel viewModel;
    private List<GameListCategory> gameListCategories = new ArrayList<>();
    GameCategoryAdapter categoryAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        List<String> categoryList = Constants.categoryList;

        viewModel.getAllCategorys(categoryList).observe(getViewLifecycleOwner(), new Observer<List<GameListCategory>>() {
            @Override
            public void onChanged(List<GameListCategory> gameListCategories) {
                HomeFragment.this.categoryAdapter.update(gameListCategories);
                HomeFragment.this.gameListCategories = gameListCategories;
            }
        });

        recyclerView = view.findViewById(R.id.recyclerHome);
        categoryAdapter = new GameCategoryAdapter(getContext(), gameListCategories);
        viewModel.getAllCategorys(categoryList);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}