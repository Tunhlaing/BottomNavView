 package com.example.bottomnavview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

 public class MainActivity extends AppCompatActivity {

     BottomNavigationView blMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blMain = findViewById(R.id.blMain);

        //transaction = getSupportFragmentManager().beginTransaction();
        DrinkFragment drinkFragment = new DrinkFragment();
        //transaction.replace(R.id.blMain,foodFragment);
        //transaction.commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fcMain,drinkFragment).commit();
        handleClick();


    }

     private void handleClick() {
         blMain.setOnItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) item -> {
             Fragment selectedFragment = null;
             switch (item.getItemId()) {
                 case R.id.foods:
                     selectedFragment = new FoodFragment();
                     break;
                 case R.id.drinks:
                     selectedFragment = new DrinkFragment();
                     break;
                 case R.id.orders:
                     selectedFragment = new OrderFragment();
                     break;
             }
             getSupportFragmentManager()
                     .beginTransaction()
                     .replace(R.id.fcMain, selectedFragment)
                     .commit();

             return true;
         });
     }

 }