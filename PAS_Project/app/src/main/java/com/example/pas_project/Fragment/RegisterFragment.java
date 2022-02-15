package com.example.pas_project.Fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pas_project.R;
import com.example.pas_project.ViewModel.LoginFragmentViewModel;
import com.example.pas_project.ViewModel.RegisterFragmentViewModel;
import com.example.pas_project.model.User;

public class RegisterFragment extends Fragment {

    private ImageView imageView;
    private LinearLayout linearLayout_EditText;
    private TextView textView_register;
    private EditText editTextEmailRegister , editTextPasswordRegister , editTextTextPasswordRegisterConfirm;
    private Button button_register;
    private String userPassword , userPasswordConfirm;

    private RegisterFragmentViewModel registerFragmentViewModel;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public RegisterFragment() {

    }

    public static RegisterFragment newInstance(String param1, String param2) {
        RegisterFragment fragment = new RegisterFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        registerFragmentViewModel = new ViewModelProvider(this).get(RegisterFragmentViewModel.class);

        this.imageView = view.findViewById(R.id.imageView4);
        this.linearLayout_EditText = view.findViewById(R.id.linearLayout3);
        this.button_register = view.findViewById(R.id.button3);
        this.textView_register = view.findViewById(R.id.textView9);

        this.editTextEmailRegister = view.findViewById(R.id.editTextEmailRegister);
        this.editTextPasswordRegister = view.findViewById(R.id.editTextPasswordRegister);
        this.editTextTextPasswordRegisterConfirm = view.findViewById(R.id.editTextTextPasswordRegisterConfirm);

        fun_animataion(imageView);
        fun_animataion(linearLayout_EditText);
        fun_animataion(button_register);
        fun_animataion(textView_register);


        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Registo concluído", Toast.LENGTH_LONG).show();
                createUser();
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_registerFragment_to_pub1Fragment);
            }
        });
    }

    void fun_animataion(View view) {
        view.animate().alpha(1).setDuration(1500).translationY(0);
    }

    public void createUser() {
        registerFragmentViewModel.getUserByEmail(getContext(), editTextEmailRegister.getText().toString()).observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                if (editTextEmailRegister.getText().toString().isEmpty() ||
                        editTextPasswordRegister.getText().toString().isEmpty() &&
                                editTextPasswordRegister.equals(editTextPasswordRegister)) {
                    Toast.makeText(getContext(), "Passwords não coincidem", Toast.LENGTH_SHORT);
                }else {
                    User newUser = new User(0, editTextEmailRegister.getText().toString(), editTextPasswordRegister.getText().toString());
                    registerFragmentViewModel.createUser(newUser);
                    registerFragmentViewModel.getUserByEmail(getContext(), newUser.getEmail()).observe(RegisterFragment.this, new Observer<User>() {
                        @Override
                        public void onChanged(User user) {
                            registerFragmentViewModel.saveSession(user);
                        }
                    });
                }
            }
        });
    }
}