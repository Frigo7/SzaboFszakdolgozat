package com.example.szf_szakdolgozat.ui.checkin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.szf_szakdolgozat.R;


import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import com.google.firebase.auth.FirebaseAuth;

public class CheckinFragment extends Fragment {

    private EditText emailField, passwordField;
    private Button loginButton;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_checkin, container, false);

        // Inicializálás a nézet hierarchián belül
        mAuth = FirebaseAuth.getInstance();
        emailField = view.findViewById(R.id.email);
        passwordField = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.loginButton);

        // Bejelentkezési eseménykezelő
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        return view;
    }

    private void setContentView(int fragmentCheckin) {

    }

    private void loginUser() {
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        // Firebase Auth használata a bejelentkezéshez
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(getActivity(), task -> {
            if (task.isSuccessful()) {
                NavHostFragment.findNavController(CheckinFragment.this)
                        .navigate(R.id.action_nav_checkin_to_nav_home);
                // Sikeres bejelentkezés
                // Itt navigálhatsz egy másik activity-re vagy frissítheted a UI-t
            } else {
                // Hiba kezelése
                // Megmutathatod a hibát egy Toast vagy AlertDialog segítségével
            }
        });

    }
}
