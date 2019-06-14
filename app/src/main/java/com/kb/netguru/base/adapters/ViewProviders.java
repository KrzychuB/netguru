package com.kb.netguru.base.adapters;

import android.support.annotation.NonNull;
import com.kb.netguru.R;
import com.kb.netguru.base.viewModel.ViewModel;
import com.kb.netguru.ui.viewmodels.ItemProductViewModel;
import com.kb.netguru.ui.viewmodels.ItemShoppingListViewModel;

public class ViewProviders {
    @NonNull
    public static ViewProvider getViewModel() {
        return new ViewProvider() {
            @Override
            public int getView(ViewModel viewModel) {
                if (viewModel instanceof ItemShoppingListViewModel) {
                    return R.layout.item_shopping_list;
                }

                if (viewModel instanceof ItemProductViewModel) {
                    return R.layout.item_product;
                }

                throw new RuntimeException("layout not found for ViewModel: " + viewModel.getClass().getSimpleName());
            }
        };
    }
}
