package com.example.pas_project.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pas_project.R;


public class LoginFragment extends Fragment {

   private ImageView imageView;
   private LinearLayout linearLayout_EditText;
   private Button button_login;
   private TextView textView_login , textView_go_to_register;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.imageView = view.findViewById(R.id.imageView4);
        this.linearLayout_EditText = view.findViewById(R.id.linearLayout3);
        this.button_login = view.findViewById(R.id.button3);
        this.textView_login = view.findViewById(R.id.textView9);
        this.textView_go_to_register = view.findViewById(R.id.textView2);

        fun_animataion(imageView);
        fun_animataion(linearLayout_EditText);
        fun_animataion(button_login);
        fun_animataion(textView_login);
        fun_animataion(textView_go_to_register);

    }

    void fun_animataion(View view) {
        view.animate().alpha(1).setDuration(1500).translationY(0);
    }
}