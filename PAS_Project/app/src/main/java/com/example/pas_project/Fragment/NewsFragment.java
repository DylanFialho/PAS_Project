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
import com.example.pas_project.ViewModel.CartViewModel;
import com.example.pas_project.ViewModel.NewsViewModel;
import com.example.pas_project.model.CartAdapter;
import com.example.pas_project.model.Game;
import com.example.pas_project.model.NewsAdapter;
import com.example.pas_project.repository.IRepoResponse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NewsFragment extends Fragment {

    private NewsViewModel mViewModel;
    private RecyclerView recyclerView;
    private NewsAdapter adapter;


    public static NewsFragment newInstance() {
        return new NewsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NewsViewModel.class);

        recyclerView = view.findViewById(R.id.recyclerNews);

        mViewModel.getAll().observe(getViewLifecycleOwner(), new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> games) {
                Collections.shuffle(games);
                List<Game> temp = new ArrayList<>();

                temp.add(games.get(0));
                temp.add(games.get(1));
                temp.add(games.get(2));

                adapter = new NewsAdapter(getContext(), temp);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            }
        });

    }
}