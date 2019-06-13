package com.kb.netguru.ui.popup

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.view.*
import com.kb.netguru.BR
import com.kb.netguru.base.viewModel.BaseViewModel

open class BaseDialog : DialogFragment() {

    private lateinit var viewModel: BaseViewModel
    private var layoutResID: Int = 0

    var dialogSize: Float = 0.85f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return setAndBindContentView(viewModel, inflater, container, layoutResID)
    }

    override fun onResume() {
        dialog.window?.also {
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val display = it.windowManager.defaultDisplay
            val size = Point()
            display.getSize(size)
            val dialogWidth = (size.x * dialogSize).toInt()
            it.setLayout(dialogWidth, WindowManager.LayoutParams.WRAP_CONTENT)
            it.setGravity(Gravity.CENTER)
        }
        super.onResume()
    }

    fun prepareDialog(viewModel: BaseViewModel, @LayoutRes layoutResID: Int) {
        this.viewModel = viewModel
        this.layoutResID = layoutResID
    }

    private fun setAndBindContentView(
            viewModel: BaseViewModel,
            inflater: LayoutInflater,
            container: ViewGroup?,
            @LayoutRes layoutResID: Int
    ): View
    {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutResID, container, false)
        binding.setVariable(BR.vm, viewModel)
        binding.executePendingBindings()
        return binding.root
    }

}