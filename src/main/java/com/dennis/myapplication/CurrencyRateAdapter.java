package com.dennis.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CurrencyRateAdapter extends RecyclerView.Adapter<CurrencyRateAdapter.CurrencyRateViewHolder> {

    private List<CurrencyRate> currencyRateList;

    public CurrencyRateAdapter(List<CurrencyRate> currencyRateList) {
        this.currencyRateList = currencyRateList;
    }

    @Override
    public CurrencyRateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.currency_rate_list_row, parent, false);

        return new CurrencyRateViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CurrencyRateViewHolder holder, int position) {
        holder.name.setText(currencyRateList.get(position).getFullname() + " (" + currencyRateList.get(position).getName() + ")");
        holder.rate.setText(currencyRateList.get(position).getRate().toString());
        holder.imageUrl.setImageResource(currencyRateList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return currencyRateList.size();
    }

    public class CurrencyRateViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView rate;
        public ImageView imageUrl;

        public CurrencyRateViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
            rate = (TextView) view.findViewById(R.id.rate);
            imageUrl = (ImageView) view.findViewById(R.id.imageUrl);
        }
    }
}