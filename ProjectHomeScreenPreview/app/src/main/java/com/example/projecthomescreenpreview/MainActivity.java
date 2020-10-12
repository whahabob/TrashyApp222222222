package com.example.projecthomescreenpreview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       /*
            AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
            .build();
        */
        Button btn_TL = findViewById(R.id.imageButton_topLeft);
        ImageButton btn_DL = findViewById(R.id.imageButton_downLeft);
        ImageButton btn_TR = findViewById(R.id.imageButton_topRight);
        ImageButton btn_MR = findViewById(R.id.imageButton_middleRight);
        ImageButton btn_BR = findViewById(R.id.imageButton_bottomRight);

        BottomNavigationView topNavView = findViewById(R.id.nav_viewTop);

        final Intent intent = new Intent(this, TreeActivity.class);
        topNavView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.navigation_profile:
                                item.setChecked(!item.isChecked());
                                startActivity(intent);
                                item.setCheckable(false);
                            case R.id.navigation_appname:
                                System.out.println("kom hier gewoon");
                            case R.id.navigation_tree:
                                item.setChecked(!item.isChecked());
                                item.setCheckable(false);
                                break;
                            default:
                                throw new IllegalStateException("Unexpected value: " + item.getItemId());
                        }
                        return true;
                    }
                });

        btn_TL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topLeft_OnClick(v);
            }
        });

        btn_DL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downLeft_OnClick(v);
            }
        });

        btn_TR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topRight_OnClick(v);
            }
        });

        btn_MR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                middleRight_OnClick(v);
            }
        });

        btn_BR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomRight_OnClick(v);
            }
        });


    }

    private void topRight_OnClick(View v) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);

    }

    private void middleRight_OnClick(View v) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    private void downLeft_OnClick(View v) {
        Intent intent = new Intent(this, ShopActivity.class);
        startActivity(intent);
    }

    private void bottomRight_OnClick(View v) {
        Intent intent = new Intent(this, PickupActivity.class);
        startActivity(intent);
    }

    public void topLeft_OnClick(View v) {
        Intent intent = new Intent(this, CalanderActivity.class);
        startActivity(intent);

    }

}
