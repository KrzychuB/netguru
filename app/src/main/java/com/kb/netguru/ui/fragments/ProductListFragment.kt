package com.kb.netguru.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onStop() {
        super.onStop()

        productListViewModel.dispose()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.producy_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            R.id.archiveList -> {
                productListViewModel.archiveShoppingList()
                true
            }
            else -> {
                true
            }
        }
    }


}