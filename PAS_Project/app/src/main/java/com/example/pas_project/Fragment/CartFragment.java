package com.example.pas_project.Fragment;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pas_project.ViewModel.CartViewModel;
import com.example.pas_project.R;
import com.example.pas_project.model.database.AppDatabase;

public class CartFragment extends Fragment {

    private CartViewModel mViewModel;

    public static CartFragment newInstance() {
        return new CartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cart_fragment, container, false);
    }

    RecyclerView recyclerView;
    Button button;
    CartAdapter cartAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.buttonPay);
        recyclerView = view.findViewById(R.id.recyclerViewCart);

        Toolbar toolbar = view.findViewById(R.id.toolbar2);

        toolbar.setTitle("Carrinho");

        cartAdapter = AppDatabase.getInstance(this).getGameDao().getAllInCart();

        recyclerView.setAdapter(cartAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        cartAdapter.updateList(AppDatabase.getInstance(this).getGameDao().getAllInCart());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, PaymentActivity.class));
            }
        });
    }
}