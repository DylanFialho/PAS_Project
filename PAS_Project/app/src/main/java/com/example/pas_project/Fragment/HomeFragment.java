package com.example.pas_project.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_project.R;
import com.example.pas_project.ViewModel.HomeViewModel;
import com.example.pas_project.model.Constants;
import com.example.pas_project.model.GameCategoryAdapter;

import java.util.List;

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
        List<String> categoryList = Constants.categoryList;

        RecyclerView recyclerView = view.findViewById(R.id.recyclerHome);
        GameCategoryAdapter categoryAdapter = new GameCategoryAdapter(getContext());
        viewModel.getAllCategorys(categoryList);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }
}