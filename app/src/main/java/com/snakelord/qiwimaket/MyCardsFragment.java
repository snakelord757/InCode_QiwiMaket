package com.snakelord.qiwimaket;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.snakelord.qiwimaket.adapters.OrderCardsRecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyCardsFragment extends Fragment {

    @BindView(R.id.cards_list)
    RecyclerView orderCardsListRecyclerView;
    private static final int ORDER_CARDS_ITEM_COUNTER = 7;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_cards,container,false);
        ButterKnife.bind(this, view);
        setOrderCardsListRecyclerViewLayoutManager();
        setOrderCardsListRecyclerViewAdapter();
        return view;
    }

    private void setOrderCardsListRecyclerViewAdapter() {
        orderCardsListRecyclerView.setAdapter(new OrderCardsRecyclerViewAdapter(ORDER_CARDS_ITEM_COUNTER));
    }

    private void setOrderCardsListRecyclerViewLayoutManager() {
        orderCardsListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
