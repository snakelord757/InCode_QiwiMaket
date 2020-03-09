package com.snakelord.qiwimaket.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snakelord.qiwimaket.R;

import java.util.ArrayList;

public final class UsefulServicesAdapter extends RecyclerView.Adapter<UsefulServicesAdapter.ViewHolder> {

    private int itemCounter;
    private Context context;
    private ArrayList<String> usefulServicesTitles = new ArrayList<>();

    public UsefulServicesAdapter (Context context, int itemCounter) {
        this.itemCounter = itemCounter;
        this.context = context;
    }

    @NonNull
    @Override
    public UsefulServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.useful_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UsefulServicesAdapter.ViewHolder holder, int position) {
        generatePaymentsTitles();
        holder.bind(usefulServicesTitles.get(position));
    }

    @Override
    public int getItemCount() {
        return itemCounter;
    }

    private void generatePaymentsTitles() {
        usefulServicesTitles.add(context.getString(R.string.split_check));
        usefulServicesTitles.add(context.getString(R.string.accounts_payable));
        usefulServicesTitles.add(context.getString(R.string.map_of_terminal));
        usefulServicesTitles.add(context.getString(R.string.currency_rates));
    }

    final class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.useful_item_title);
        }

        void bind(String title) {
            itemTitle.setText(title);
        }
    }
}
