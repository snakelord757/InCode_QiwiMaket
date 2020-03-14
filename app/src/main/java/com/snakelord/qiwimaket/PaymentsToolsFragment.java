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
import androidx.viewpager2.widget.ViewPager2;

import com.snakelord.qiwimaket.adapters.FavoritePaymentsRecyclerViewAdapter;
import com.snakelord.qiwimaket.adapters.PaymentsAndTransactionsRecyclerViewAdapter;
import com.snakelord.qiwimaket.adapters.PromotionsViewAdapter;
import com.snakelord.qiwimaket.adapters.UsefulServicesAdapter;
import com.snakelord.qiwimaket.adapters.WalletsViewPagerAdapter;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PaymentsToolsFragment extends Fragment {

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
    private static final int PROMO_ITEMS_COUNT = 15;
    private static final int WALLETS_ITEMS_COUNT = 3;
    private static final int FAVORITE_PAYMENTS_COUNT = 3;
    private static final int PAYMENTS_AND_TRANSACTIONS_ITEMS_COUNT = 5;
    private static final int USEFUL_SERVICES_ITEMS_COUNTER = 4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payments_tools, container, false);
        unbinder = ButterKnife.bind(this,view);
        setLayoutManagers();
        setAdapters();
        setViewPagerForIndicator();
        return view;
    }

    private void setAdapters() {
        promoViewPager2.setAdapter(new PromotionsViewAdapter(PROMO_ITEMS_COUNT));
        walletsViewPager2.setAdapter(new WalletsViewPagerAdapter(WALLETS_ITEMS_COUNT));
        favoritePaymentsRecyclerView.setAdapter(new FavoritePaymentsRecyclerViewAdapter(getActivity(), FAVORITE_PAYMENTS_COUNT));
        paymentsAndTransactionsRecyclerView.setAdapter(new PaymentsAndTransactionsRecyclerViewAdapter(getActivity(), PAYMENTS_AND_TRANSACTIONS_ITEMS_COUNT));
        usefulServicesRecyclerView.setAdapter(new UsefulServicesAdapter(getActivity(), USEFUL_SERVICES_ITEMS_COUNTER));
    }

    private void setLayoutManagers() {
        LinearLayoutManager favoritePaymentsLayoutManager =  new LinearLayoutManager(getActivity());
        favoritePaymentsLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        favoritePaymentsRecyclerView.setLayoutManager(favoritePaymentsLayoutManager);
        LinearLayoutManager paymentsAndTransactionsLayoutManager =  new LinearLayoutManager(getActivity());
        paymentsAndTransactionsLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        paymentsAndTransactionsRecyclerView.setLayoutManager(paymentsAndTransactionsLayoutManager);
        LinearLayoutManager usefulServicesLayoutManager = new LinearLayoutManager(getActivity());
        usefulServicesRecyclerView.setLayoutManager(usefulServicesLayoutManager);
    }

    private void setViewPagerForIndicator() {
        dotsIndicator.setViewPager2(walletsViewPager2);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
