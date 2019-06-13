package com.kb.netguru.base.adapters;

import android.support.annotation.LayoutRes;
import com.kb.netguru.base.viewModel.ViewModel;

public interface ViewProvider {

    @LayoutRes
    int getView(ViewModel viewModel);
}

