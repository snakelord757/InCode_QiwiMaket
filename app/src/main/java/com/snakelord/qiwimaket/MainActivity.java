package com.snakelord.qiwimaket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationView bottomNavigationView;
    private Unbinder unbinder;
    private FragmentManager fragmentManager;
    private Fragment currentFragment;
    private static final String LAST_FRAGMENT = "Last Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null)
            bottomNavigationView.setSelectedItemId(R.id.main_page_item);
        else
            loadFragment(savedInstanceState);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = (item) -> {
            switch (item.getItemId()) {
                case R.id.main_page_item :
                    currentFragment = new PaymentsToolsFragment();
                    break;
                case R.id.cards_page_item :
                    currentFragment = new CardsFragment();
                    break;
            }
            fragmentManager.beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
            return true;
    };

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState, LAST_FRAGMENT, currentFragment);
    }

    private void loadFragment(Bundle bundle) {
        currentFragment = getSupportFragmentManager().getFragment(bundle, LAST_FRAGMENT);
        fragmentManager.beginTransaction().replace(R.id.fragment_container, currentFragment).commit();
    }

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
