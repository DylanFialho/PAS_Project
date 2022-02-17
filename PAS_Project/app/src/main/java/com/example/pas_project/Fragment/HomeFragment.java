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
import com.example.pas_project.model.Game;
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
        recyclerView = view.findViewById(R.id.recyclerHome);
        categoryAdapter = new GameCategoryAdapter(getContext(), gameListCategories);
        recyclerView.setAdapter(categoryAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        viewModel.getAllGames().observe(getViewLifecycleOwner(), new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> gameList) {
                for (int i = 0; i < gameList.size(); i++) {
                    Game game = gameList.get(i);
                    int temp = -1;

                    for (int j = 0; j < gameListCategories.size(); j++) {
                        if(gameListCategories.get(j).getCategory().equals(game.getCategory())){
                            temp = j;
                            break;
                        }
                    }
                    if(temp == -1){
                        List<Game> list = new ArrayList<>();
                        list.add(game);
                        gameListCategories.add(new GameListCategory(game.getCategory(), list));
                    }else{
                        if(!gameListCategories.get(temp).getGameList().contains(game)){
                            gameListCategories.get(temp).getGameList().add(game);
                        }
                    }
                }
                HomeFragment.this.categoryAdapter.update(gameListCategories);
            }
        });
    }
}