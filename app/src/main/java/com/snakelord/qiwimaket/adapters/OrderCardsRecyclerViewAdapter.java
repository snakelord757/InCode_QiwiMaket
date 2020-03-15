package com.snakelord.qiwimaket.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snakelord.qiwimaket.R;

public final class OrderCardsRecyclerViewAdapter extends RecyclerView.Adapter<OrderCardsRecyclerViewAdapter.ViewHolder> {

    private int itemCount;

    public OrderCardsRecyclerViewAdapter(int itemCount) {
        this.itemCount = itemCount;
    }

    @NonNull
    @Override
    public OrderCardsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_information_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
