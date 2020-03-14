package com.snakelord.qiwimaket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationView bottomNavigationView;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container, new PaymentsToolsFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.main_page_item :
                    new PaymentsToolsFragment();
                    break;
                case R.id.cards_page_item :
                    //TODO
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
