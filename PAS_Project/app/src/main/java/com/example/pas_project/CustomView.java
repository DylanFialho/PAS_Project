package com.example.pas_project;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class CustomView extends ConstraintLayout {

    private TypedArray attributes;

    enum SpinnerType{
        CATEGORY, CONSOLE, USER
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.custom_view, this, true);

        attributes = context.obtainStyledAttributes(attrs, R.styleable.CustomView,0,0);
        attributes.recycle();
    }

    public void setSpinner(SpinnerType spinner, List<String> list){
        switch (spinner){
            case CATEGORY:
                break;
            case USER:
                break;
            case CONSOLE:
                break;
        }

    }
}
