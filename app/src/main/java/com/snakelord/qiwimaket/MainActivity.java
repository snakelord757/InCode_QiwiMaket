package com.snakelord.qiwimaket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.snakelord.qiwimaket.adapters.FavoritePaymentsRecyclerViewAdapter;
import com.snakelord.qiwimaket.adapters.PaymentsAndTransactionsRecyclerViewAdapter;
import com.snakelord.qiwimaket.adapters.PromotionsViewAdapter;
import com.snakelord.qiwimaket.adapters.UsefulServicesAdapter;
import com.snakelord.qiwimaket.adapters.WalletsViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 walletsViewPager2;
    private ViewPager2 promoViewPager2;
    private RecyclerView favoritePaymentsRecyclerView;
    private RecyclerView paymentsAndTransactionsRecyclerView;
    private RecyclerView usefulServicesRecyclerView;
    private DotsIndicator dotsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        walletsViewPager2 = findViewById(R.id.wallets_view_pager2);
        promoViewPager2 = findViewById(R.id.promotions);
        dotsIndicator = findViewById(R.id.dots_indicator);
        favoritePaymentsRecyclerView = findViewById(R.id.favorite_payments);
        paymentsAndTransactionsRecyclerView = findViewById(R.id.payments_and_transactions);
        usefulServicesRecyclerView = findViewById(R.id.useful_services);
        setLayoutManagers();
        setAdapters();
        setViewPagerForIndicator();
    }

    private void setAdapters() {
        promoViewPager2.setAdapter(new PromotionsViewAdapter(15));
        walletsViewPager2.setAdapter(new WalletsViewPagerAdapter(3));
        favoritePaymentsRecyclerView.setAdapter(new FavoritePaymentsRecyclerViewAdapter(this, 3));
        paymentsAndTransactionsRecyclerView.setAdapter(new PaymentsAndTransactionsRecyclerViewAdapter(this, 5));
        usefulServicesRecyclerView.setAdapter(new UsefulServicesAdapter(this, 4));
    }


    private void setLayoutManagers() {
        LinearLayoutManager favoritePaymentsLayoutManager =  new LinearLayoutManager(this);
        favoritePaymentsLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        favoritePaymentsRecyclerView.setLayoutManager(favoritePaymentsLayoutManager);
        LinearLayoutManager paymentsAndTransactionsLayoutManager =  new LinearLayoutManager(this);
        paymentsAndTransactionsLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        paymentsAndTransactionsRecyclerView.setLayoutManager(paymentsAndTransactionsLayoutManager);
        LinearLayoutManager usefulServicesLayoutManager = new LinearLayoutManager(this);
        usefulServicesRecyclerView.setLayoutManager(usefulServicesLayoutManager);
    }

    private void setViewPagerForIndicator() {
        dotsIndicator.setViewPager2(walletsViewPager2);
    }

}
