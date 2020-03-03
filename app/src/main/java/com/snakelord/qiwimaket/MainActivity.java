package com.snakelord.qiwimaket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.snakelord.qiwimaket.adapters.FavoritePaymentsRecyclerViewAdapter;
import com.snakelord.qiwimaket.adapters.PaymentsAndTransactionsRecyclerViewAdapter;
import com.snakelord.qiwimaket.adapters.WalletsViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 walletsViewPager2 = findViewById(R.id.wallets_view_pager2);
        walletsViewPager2.setAdapter(new WalletsViewPagerAdapter(3));
        DotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager2(walletsViewPager2);
        RecyclerView favoritePaymentsRecyclerView = findViewById(R.id.favorite_payments);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        favoritePaymentsRecyclerView.setLayoutManager(linearLayoutManager);
        favoritePaymentsRecyclerView.setAdapter(new FavoritePaymentsRecyclerViewAdapter(this, 3));
        RecyclerView paymentsAndTransactionRecyclerView = findViewById(R.id.payments_and_transactions);
        LinearLayoutManager paymentsLinearLayoutManager = new LinearLayoutManager(this);
        paymentsLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        paymentsAndTransactionRecyclerView.setLayoutManager(paymentsLinearLayoutManager);
        paymentsAndTransactionRecyclerView.setAdapter(new PaymentsAndTransactionsRecyclerViewAdapter(this, 5));
    }
}
