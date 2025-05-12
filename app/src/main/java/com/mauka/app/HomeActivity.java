package com.mauka.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    TextView textProfile;
    TextView notificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textProfile = findViewById(R.id.textProfile);
        notificationButton = findViewById(R.id.notification_button);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            textProfile.setText(user.getDisplayName() != null ? user.getDisplayName() : "Perfil");
        }

        notificationButton.setOnClickListener(v -> {
            startActivity(new Intent(HomeActivity.this, NotificationsActivity.class));
        });

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
        navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_inicio:
                    return true;
                case R.id.nav_perfil:
                    return true;
                case R.id.nav_mauka:
                    return true;
            }
            return false;
        });
    }
}
