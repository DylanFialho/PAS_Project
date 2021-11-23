package com.example.pas_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    private CustomView customView;

    private final int ID_Home = 1;
    private final int ID_News = 2;
    private final int ID_Cart = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomNav);


        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Home, R.mipmap.game_controller));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_Cart, R.drawable.ic_baseline_shopping_cart_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(ID_News, R.drawable.ic_baseline_news_24));



        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                switch (item.getId()) {
                    case ID_Home:
                        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView, HomeFragment.class, null).commit();
                        break;
                    case ID_News:

                        break;
                    case ID_Cart:

                        break;
                }
            }
        });

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {

            }
        });


        bottomNavigation.setCount(ID_Cart, "2");
        bottomNavigation.show(ID_Home, true);


    }
}