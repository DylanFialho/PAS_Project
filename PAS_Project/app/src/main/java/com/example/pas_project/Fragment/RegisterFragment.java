package com.example.pas_project.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.pas_project.R;
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

    public RegisterFragment() {

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
                User user = new User(0, editTextEmailRegister.getText().toString(), editTextPasswordRegister.getText().toString());
                createUser(view, user);
            }
        });
    }

    void fun_animataion(View view) {
        view.animate().alpha(1).setDuration(1500).translationY(0);
    }

    public void createUser(View view, User user) {
        if(user.getPassword().equals(editTextTextPasswordRegisterConfirm.getText().toString())){
            this.registerFragmentViewModel.createUser(view, user);
        }else{
            Toast.makeText(getContext(), "Passwords nao coincidem", Toast.LENGTH_SHORT).show();
            if (editTextEmailRegister.getText().toString().isEmpty() || editTextPasswordRegister.getText().
                    toString().isEmpty() || editTextTextPasswordRegisterConfirm.getText().toString().isEmpty()){
                Toast.makeText(getContext(), "Campos nao preenchidos", Toast.LENGTH_SHORT).show();
            }
        }

    }
}