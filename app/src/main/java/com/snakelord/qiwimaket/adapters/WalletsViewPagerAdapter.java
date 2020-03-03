package com.snakelord.qiwimaket.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snakelord.qiwimaket.R;

public final class WalletsViewPagerAdapter extends RecyclerView.Adapter<WalletsViewPagerAdapter.ViewHolder> {

    private int itemCount;

    public WalletsViewPagerAdapter(int itemCount) {
        this.itemCount = itemCount;
    }

    @NonNull
    @Override
    public WalletsViewPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.wallet_card_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WalletsViewPagerAdapter.ViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }


    final class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
