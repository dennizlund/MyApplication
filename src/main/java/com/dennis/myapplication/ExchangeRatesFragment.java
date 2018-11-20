package com.dennis.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExchangeRatesFragment extends Fragment {

    private static final String TAG = "ExchangeRatesFragment";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private List<CurrencyRate> currencyRateList = RateList.getRates();
    private RecyclerView recyclerView;
    private CurrencyRateAdapter mAdapter;

    private Context mContext = getActivity();

    public ExchangeRatesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.my_recycler_view, container, false);
        mAdapter = new CurrencyRateAdapter(currencyRateList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        DividerItemDecoration decoration = new DividerItemDecoration(recyclerView.getContext(), ((LinearLayoutManager) mLayoutManager).getOrientation());
        recyclerView.addItemDecoration(decoration);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        mAdapter.notifyDataSetChanged();

        return recyclerView;
    }


}
