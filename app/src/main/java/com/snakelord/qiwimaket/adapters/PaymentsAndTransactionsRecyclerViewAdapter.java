package com.snakelord.qiwimaket.adapters;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snakelord.qiwimaket.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

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

        @BindView(R.id.payment_item_title)
        TextView PaymentsAndTransactionTitleTitleTextView;
        @BindView(R.id.payment_item_icon)
        CircleImageView PaymentsAndTransactionIconCircleImageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String title)
        {
            PaymentsAndTransactionIconCircleImageView.setColorFilter(itemView.getResources().getColor(R.color.colorPrimary));
            PaymentsAndTransactionTitleTitleTextView.setText(title);
        }
    }
}