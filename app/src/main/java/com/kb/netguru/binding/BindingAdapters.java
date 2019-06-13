package com.kb.netguru.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.kb.netguru.base.adapters.MultiViewAdapter;
import com.kb.netguru.base.adapters.ViewProvider;
import com.kb.netguru.base.adapters.ViewProviders;
import com.kb.netguru.base.viewModel.ViewModel;

import java.util.List;

public class BindingAdapters {
    @BindingAdapter("items")
    public static void initRecyclerView(@NonNull RecyclerView recyclerView, @Nullable List<ViewModel> items) {
        ViewProvider viewProvider = ViewProviders.getViewModel();

        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            Context recyclerViewContext = recyclerView.getContext();
            layoutManager = new LinearLayoutManager(recyclerViewContext, RecyclerView.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
        }

        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new MultiViewAdapter(items, viewProvider);
            recyclerView.setAdapter(adapter);
        }

        Parcelable layoutManagerState = layoutManager.onSaveInstanceState();
        ((MultiViewAdapter) adapter).setItems(items);
        layoutManager.onRestoreInstanceState(layoutManagerState);
    }
}
