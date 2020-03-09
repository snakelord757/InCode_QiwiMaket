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

import butterknife.BindView;
import butterknife.ButterKnife;

public final class FavoritePaymentsRecyclerViewAdapter extends RecyclerView.Adapter<FavoritePaymentsRecyclerViewAdapter.ViewHolder> {

    private int itemCount;
    private ArrayList<String> favoritePaymentsTitles = new ArrayList<>();
    private Context context;

    public FavoritePaymentsRecyclerViewAdapter(Context context, int itemCount) {
        this.itemCount = itemCount;
        this.context = context;
    }

    @NonNull
    @Override
    public FavoritePaymentsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_payments_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        generateFavoritePaymentsTitles();
        holder.bind(favoritePaymentsTitles.get(position));
    }

    private void generateFavoritePaymentsTitles() {
        favoritePaymentsTitles.add(context.getString(R.string.my_mobile_payments));
        favoritePaymentsTitles.add(context.getString(R.string.tea_payments));
        favoritePaymentsTitles.add(context.getString(R.string.strange_payments));
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    final class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.favorite_payment_title)
        TextView favoritePaymentsTitleTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(String title)
        {
            favoritePaymentsTitleTextView.setText(title);
        }
    }
}
