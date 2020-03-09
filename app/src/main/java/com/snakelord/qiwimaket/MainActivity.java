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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.wallets_view_pager2)
    ViewPager2 walletsViewPager2;
    @BindView(R.id.promotions)
    ViewPager2 promoViewPager2;
    @BindView(R.id.favorite_payments)
    RecyclerView favoritePaymentsRecyclerView;
    @BindView(R.id.payments_and_transactions)
    RecyclerView paymentsAndTransactionsRecyclerView;
    @BindView(R.id.useful_services)
    RecyclerView usefulServicesRecyclerView;
    @BindView(R.id.dots_indicator)
    DotsIndicator dotsIndicator;
    private Unbinder unbinder;
    static final int PROMO_ITEMS_COUNT = 15;
    static final int WALLETS_ITEMS_COUNT = 3;
    static final int FAVORITE_PAYMENTS_COUNT = 3;
    static final int PAYMENTS_AND_TRANSACTIONS_ITEMS_COUNT = 5;
    static final int USEFUL_SERVICES_ITEMS_COUNTER = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setLayoutManagers();
        setAdapters();
        setViewPagerForIndicator();
    }

    private void setAdapters() {
        promoViewPager2.setAdapter(new PromotionsViewAdapter(PROMO_ITEMS_COUNT));
        walletsViewPager2.setAdapter(new WalletsViewPagerAdapter(WALLETS_ITEMS_COUNT));
        favoritePaymentsRecyclerView.setAdapter(new FavoritePaymentsRecyclerViewAdapter(this, FAVORITE_PAYMENTS_COUNT));
        paymentsAndTransactionsRecyclerView.setAdapter(new PaymentsAndTransactionsRecyclerViewAdapter(this, PAYMENTS_AND_TRANSACTIONS_ITEMS_COUNT));
        usefulServicesRecyclerView.setAdapter(new UsefulServicesAdapter(this, USEFUL_SERVICES_ITEMS_COUNTER));
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

    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
