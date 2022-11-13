package com.example.dz33;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OchiFragment extends Fragment {

    private EditText editPassword;
    private Button buttonConfig;
    private String isPassword = "admin";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ochi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editPassword = view.findViewById(R.id.ed_password);
        buttonConfig = view.findViewById(R.id.button);
        click();
    }


    public void click () {
        buttonConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = editPassword.getText().toString().trim();
                if (!password.equals(isPassword)){
                    editPassword.setError("Неправильный пароль");
                } else {
                    getParentFragmentManager().beginTransaction()
                            .setCustomAnimations(R.anim.left,R.anim.right)
                            .replace(R.id.fragment_container,new RecyclerFragment())
                            .addToBackStack("FirstFragment")
                            .commit();

                }

            }
        });

    }

}