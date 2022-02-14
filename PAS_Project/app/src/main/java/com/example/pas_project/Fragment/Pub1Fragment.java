package com.example.pas_project.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pas_project.R;

import java.util.Timer;
import java.util.TimerTask;


public class Pub1Fragment extends Fragment {

    Timer timer;
    private ImageView imageViewSetImage;
    private TextView textViewSetText1 , textViewSetText2 , textViewSetText3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pub3, container, false);
    }

    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        this.imageViewSetImage = view.findViewById(R.id.imageViewSetImage);
        this.textViewSetText1 = view.findViewById(R.id.textViewSetText1);
        this.textViewSetText2 = view.findViewById(R.id.textViewSetText2);
        this.textViewSetText3 = view.findViewById(R.id.textViewSetText3);

        fun_animataion(imageViewSetImage);
        fun_animataion(textViewSetText1);
        fun_animataion(textViewSetText2);
        fun_animataion(textViewSetText3);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_pub1Fragment_to_pub2Fragment);
            }
        },3000);


    }

    void fun_animataion(View view) {
        view.animate().alpha(1).setDuration(1500).translationY(0);
    }


}