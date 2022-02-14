package com.example.pas_project.repository;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.pas_project.R;
import com.example.pas_project.model.User;
import com.example.pas_project.model.remote.DataSource;
import com.example.pas_project.model.remote.GameService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public Repository(Context context) {

    }

    public void login(Context context,  View view, String email, String password){

        GameService gameService = DataSource.getGameService();

        Call<List<User>> callLogin = gameService.login(email,password);

        callLogin.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>>call, Response<List<User>> response) {

                List<User> res = response.body();

                if(res.size()==1)
                {

                    Toast.makeText(context, "Login Efectuado", Toast.LENGTH_LONG).show();
                    NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_loginFragment_to_nav_graph);


                }
                else
                {
                    Toast.makeText(context, "Email ou Password inseridos incorretamente", Toast.LENGTH_LONG).show();
                }

            }


            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                t.printStackTrace();

                Toast.makeText(context, "Erro do servidor", Toast.LENGTH_LONG).show();

            }
        });
    }


}
