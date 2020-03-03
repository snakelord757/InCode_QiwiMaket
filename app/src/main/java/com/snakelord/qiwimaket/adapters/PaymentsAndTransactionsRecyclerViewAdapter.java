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

public final class PaymentsAndTransactionsRecyclerViewAdapter extends RecyclerView.Adapter<PaymentsAndTransactionsRecyclerViewAdapter.ViewHolder> {

    private int itemCount;
    private ArrayList<String> paymentsTitles = new ArrayList<>();
    private Context context;

    public PaymentsAndTransactionsRecyclerViewAdapter(Context context, int itemCount) {
        this.itemCount = itemCount;
        this.context = context;
    }

    @NonNull
    @Override
    public PaymentsAndTransactionsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.payments_and_transactions_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        generatePaymentsTitles();
        holder.bind(paymentsTitles.get(position));
    }

    private void generatePaymentsTitles() {
        paymentsTitles.add(context.getString(R.string.transaction_to_Qiwi_user));
        paymentsTitles.add(context.getString(R.string.transaction_to_card));
        paymentsTitles.add(context.getString(R.string.payment_mobile));
        paymentsTitles.add(context.getString(R.string.payment_another));
        paymentsTitles.add(context.getString(R.string.payment_entertainment));
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    final class ViewHolder extends RecyclerView.ViewHolder {

        private TextView PaymentsAndTransactionTitleTitleTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            PaymentsAndTransactionTitleTitleTextView = itemView.findViewById(R.id.payment_item_title);
        }

        void bind(String title)
        {
            PaymentsAndTransactionTitleTitleTextView.setText(title);
        }
    }
}