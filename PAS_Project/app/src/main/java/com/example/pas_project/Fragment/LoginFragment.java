package com.example.pas_project.Fragment;

import android.content.Intent;
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
import com.example.pas_project.ViewModel.LoginFragmentViewModel;
import com.example.pas_project.model.LoginActivity;
import com.example.pas_project.model.MainActivity;
import com.example.pas_project.model.User;
import com.example.pas_project.model.UserResponse;
import com.example.pas_project.repository.IRepoResponse;

import java.util.List;


public class LoginFragment extends Fragment implements IRepoResponse<List<User>> {

    private ImageView imageView;
    private LinearLayout linearLayout_EditText;
    private Button button_login;
    private TextView textView_login , textView_go_to_register;

    private EditText editTextEmailAdress;
    private EditText editTextTextPassword;

    private LoginFragmentViewModel loginFragmentModelViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginFragmentModelViewModel = new ViewModelProvider(this).get(LoginFragmentViewModel.class);

        this.imageView = view.findViewById(R.id.imageView4);
        this.linearLayout_EditText = view.findViewById(R.id.linearLayout3);
        this.button_login = view.findViewById(R.id.button3);
        this.textView_login = view.findViewById(R.id.textView9);
        this.textView_go_to_register = view.findViewById(R.id.textViewGoToRegister);

        this.editTextEmailAdress = view.findViewById(R.id.editTextEmailAddrees);
        this.editTextTextPassword = view.findViewById(R.id.editTextTextPasswordRegisterConfirm);

        funAnimation(imageView);
        funAnimation(linearLayout_EditText);
        funAnimation(button_login);
        funAnimation(textView_login);
        funAnimation(textView_go_to_register);

        this.button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });

        this.textView_go_to_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });
    }

    void funAnimation(View view) {
        view.animate().alpha(1).setDuration(1000).translationY(0);
    }

    public void login(View view) {
        loginFragmentModelViewModel.getUserLogin(editTextEmailAdress.getText().toString(), editTextTextPassword.getText().toString(), this);
    }

    @Override
    public void onSuccess(List<User> obj) {
        if(obj.isEmpty()){
            Toast.makeText(getContext(), "Login Errado", Toast.LENGTH_SHORT).show();
        }else{
            requireActivity().startActivity(new Intent(requireActivity(), MainActivity.class));
            requireActivity().finish();
        }
    }
}