package com.kb.netguru.base.adapters;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import com.android.databinding.library.baseAdapters.BR;
import com.kb.netguru.base.viewModel.ViewModel;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private final ViewDataBinding binding;

    public BaseViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(ViewModel viewModel) {
        binding.setVariable(BR.vm, viewModel);
        binding.executePendingBindings();
    }

    public ViewDataBinding getBinding() {
        return binding;
    }
}
