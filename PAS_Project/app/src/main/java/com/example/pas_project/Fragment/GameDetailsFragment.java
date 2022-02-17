package com.example.pas_project.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pas_project.ViewModel.GameDetailsViewModel;
import com.example.pas_project.R;
import com.example.pas_project.model.Game;
import com.example.pas_project.model.GameDetailsAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class GameDetailsFragment extends Fragment {

    private static final String KEY_GAMEID = "GAMEID";
    private static Fragment exampleFragment ;
    private GameDetailsViewModel gameDetailsViewModel;

    private ImageView gameImage;
    private TextView gameTitle;
    private TextView gamePrice;
    private TextView gameDescription;
    private RecyclerView recyclerReview;
    private FloatingActionButton button;

    public static void startFragment(View v, long id){
        Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_gameDetailsFragment);
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_GAMEID, id);
        exampleFragment =  GameDetailsFragment.newInstance(id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.game_details_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gameDetailsViewModel = new ViewModelProvider(this).get(GameDetailsViewModel.class);

        gameImage = view.findViewById(R.id.imageGameDetails);
        gameTitle = view.findViewById(R.id.textTitleGameDetails);
        gameDescription = view.findViewById(R.id.textDescriptionDetails);
        gamePrice = view.findViewById(R.id.textPriceGameDetails);
        recyclerReview = view.findViewById(R.id.recyclerViewGameDetails);
        button = view.findViewById(R.id.buttonGameDetails);

        Bundle bundle = exampleFragment.getArguments();
        if (bundle != null) {
            long id = bundle.getLong(KEY_GAMEID, -1);
            if (id == -1) {
                Log.e("GameDetailsFragment", "Invalid position found!");
                requireActivity().finish();
                return;
            }

            GameDetailsAdapter adapter = new GameDetailsAdapter(GameDetailsFragment.this.getContext());
            recyclerReview.setLayoutManager(new LinearLayoutManager(GameDetailsFragment.this.getContext()));
            recyclerReview.setAdapter(adapter);

            gameDetailsViewModel.getGamebyId(id).observe(getViewLifecycleOwner(), new Observer<Game>() {
                @Override
                public void onChanged(Game game) {
                    Glide.with(GameDetailsFragment.this).load(game.getImgURL()).into(GameDetailsFragment.this.gameImage);
                    GameDetailsFragment.this.gameTitle.setText(game.getTitle());
                    GameDetailsFragment.this.gamePrice.setText(game.getPrice() + "€");
                    GameDetailsFragment.this.gameDescription.setText(game.getDescription());

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            game.setInCart(true);
                            gameDetailsViewModel.updateGamesToCart(game);
                        }
                    });
                }
            });
        }
    }

    public static GameDetailsFragment newInstance(long id){
        GameDetailsFragment fragment = new GameDetailsFragment();

        Bundle args = new Bundle();
        args.putLong(KEY_GAMEID, id);
        fragment.setArguments(args);

        return fragment;
    }
}