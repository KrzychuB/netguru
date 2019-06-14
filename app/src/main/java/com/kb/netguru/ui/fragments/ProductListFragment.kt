package com.kb.netguru.ui.fragments

import android.os.Bundle
import com.kb.netguru.R
import com.kb.netguru.base.fragment.BaseFragmentWithVM
import com.kb.netguru.base.viewModel.BaseViewModel
import com.kb.netguru.ui.viewmodels.ProductListViewModel
import javax.inject.Inject

class ProductListFragment: BaseFragmentWithVM()
{
    @Inject
    lateinit var productListViewModel: ProductListViewModel

    companion object {
        fun newInstance() = ProductListFragment()
    }

    override fun provideLayoutResID(): Int {
        return R.layout.fragment_product_list
    }

    override fun provideViewModel(savedInstanceState: Bundle?): BaseViewModel {
        return productListViewModel
    }

    override fun onStop() {
        super.onStop()

        productListViewModel.dispose()
    }
}