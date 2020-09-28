package com.example.id.ac.binus.volutry.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.fragment.HistoryFragment;
import com.example.id.ac.binus.volutry.fragment.HomeFragment;
import com.example.id.ac.binus.volutry.fragment.ProfileFragment;
import com.example.id.ac.binus.volutry.fragment.VolunteerFragment;
import com.example.id.ac.binus.volutry.repository.PenerimaanRepository;
import com.example.id.ac.binus.volutry.sharedPreferences.SharedPref;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView BottomNavigation = findViewById(R.id.bottom_navigation);
        BottomNavigation.setOnNavigationItemSelectedListener(navigationListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment SelectedFragment = new HomeFragment();

            switch(item.getItemId()){
                case R.id.nav_home:
                    SelectedFragment = new HomeFragment();
                    break;
                case R.id.nav_volunteer:
                    SelectedFragment = new VolunteerFragment();
                    break;
                case R.id.nav_history:
                    SelectedFragment = new HistoryFragment();
                    break;
                case R.id.nav_profile:
                    SelectedFragment = new ProfileFragment();
                    break;
            }

            if(item.getItemId() == R.id.nav_history){
                SharedPref SharedPref = new SharedPref(MainActivity.this);
                PenerimaanRepository penerimaanRepository = new PenerimaanRepository(MainActivity.this);
                boolean isRegistered = penerimaanRepository.haveRegistered(SharedPref.load().getVoluntirId());

                if(isRegistered == true){
                    Toast.makeText(MainActivity.this, "You haven't applied an event!", Toast.LENGTH_SHORT);
                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SelectedFragment).commit();
                }
            }else{
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, SelectedFragment).commit();
            }


            return true;
        }
    };
}
