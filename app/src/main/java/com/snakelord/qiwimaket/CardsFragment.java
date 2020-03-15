package com.snakelord.qiwimaket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.snakelord.qiwimaket.adapters.FragmentsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CardsFragment extends Fragment {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.cards_fragment_container)
    ViewPager2 viewPager2;
    private FragmentsAdapter fragmentsAdapter;
    private ArrayList<String> tabsTitle = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cards, container, false);
        ButterKnife.bind(this, view);
        addFragments();
        viewPager2.setAdapter(fragmentsAdapter);
        addTitles();
        setTabMediator();
        return view;
    }

    private void addFragments() {
        fragmentsAdapter = new FragmentsAdapter(this);
        fragmentsAdapter.addFragment(new MyCardsFragment());
        fragmentsAdapter.addFragment(new LinkCardFragment());
    }

    private void addTitles() {
        tabsTitle.add(getResources().getString(R.string.my_cards));
        tabsTitle.add(getResources().getString(R.string.cards_from_other_banks));
    }

    private void setTabMediator() {
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(tabsTitle.get(position))).attach();
    }

}
