package com.snakelord.qiwimaket.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snakelord.qiwimaket.R;

public final class PromotionsViewAdapter extends RecyclerView.Adapter<PromotionsViewAdapter.ViewHolder>
{
    private int itemCounter;

    public PromotionsViewAdapter(int itemCounter)
    {
        this.itemCounter = itemCounter;
    }

    @NonNull
    @Override
    public PromotionsViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.promotions_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionsViewAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return itemCounter;
    }

    final class ViewHolder extends RecyclerView.ViewHolder
    {

        private TextView promoTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            promoTitle = itemView.findViewById(R.id.promo_title);
        }

        void bind(int position) {
            promoTitle.setText("Промо #" + position);
        }
    }
}
