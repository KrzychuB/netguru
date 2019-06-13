package com.kb.netguru.base.adapters;

import com.kb.netguru.base.viewModel.ViewModel;

import java.util.List;

public class MultiViewAdapter extends BaseViewAdapter {

    private final ViewProvider viewProvider;
    private List<ViewModel> items;

    public MultiViewAdapter(List<ViewModel> viewModels, ViewProvider viewProvider) {
        this.viewProvider = viewProvider;
        this.items = viewModels;
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }

        int size = items.size();
        return size;
    }

    public List<ViewModel> getItems() {
        return items;
    }

    public void setItems(List<ViewModel> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    protected ViewModel getViewModelForPosition(int position) {
        ViewModel viewModel = items.get(position);
        return viewModel;
    }

    @Override
    protected int getLayoutIdForPosition(int position) {
        ViewModel viewModel = items.get(position);
        return viewProvider.getView(viewModel);
    }

}
