package com.kb.netguru.base.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.kb.netguru.base.viewModel.ViewModel;

public abstract class BaseViewAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        return new BaseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        ViewModel viewModel = getViewModelForPosition(position);
        onBindViewHolder(holder, viewModel);
        holder.bind(viewModel);
    }

    @Override
    public int getItemViewType(int position) {
        int layoutIdForPosition = getLayoutIdForPosition(position);
        return layoutIdForPosition;
    }

    protected abstract int getLayoutIdForPosition(int position);

    protected abstract ViewModel getViewModelForPosition(int position);

    protected void onBindViewHolder(BaseViewHolder holder, ViewModel viewModel) {
    }
}