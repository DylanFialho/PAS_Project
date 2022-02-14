package com.example.pas_project.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pas_project.R;

public class Pub2Fragment extends Fragment {

    private ImageView imageViewSetImage;
    private TextView textViewSetText1 , textViewSetText2 , textViewSetText3;

    public Pub2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_pub2, container, false);


        return root;
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
    }

    void fun_animataion(View view) {
        view.animate().alpha(1).setDuration(1500).translationY(0);
    }
}