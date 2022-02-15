package com.example.pas_project.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pas_project.R;

import java.util.Timer;


public class Pub3Fragment extends Fragment {

    private ImageView imageViewSetImage;
    private TextView textViewSetText1 , textViewSetText2 , textViewSetText3;


    public Pub3Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pub1, container, false);
        return root;
    }

    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        this.imageViewSetImage = view.findViewById(R.id.imageViewSetImage);
        this.textViewSetText1 = view.findViewById(R.id.textViewSetText1);
        this.textViewSetText2 = view.findViewById(R.id.textViewSetText2);
        this.textViewSetText3 = view.findViewById(R.id.textViewSetText3);

        funAnimataion(imageViewSetImage);
        funAnimataion(textViewSetText1);
        funAnimataion(textViewSetText2);
        funAnimataion(textViewSetText3);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_pub3Fragment_to_nav_graph);
            }
        }, 3000);
    }

    void funAnimataion(View view) {
        view.animate().alpha(1).setDuration(1500).translationY(0);
    }
}