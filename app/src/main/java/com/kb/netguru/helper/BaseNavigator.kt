package com.kb.netguru.helper

import android.support.v4.app.FragmentManager
import android.util.Log
import com.kb.netguru.R
import com.kb.netguru.base.activity.BaseActivity
import com.kb.netguru.base.fragment.BaseFragment
import java.lang.ref.WeakReference

open class BaseNavigator(activity: BaseActivity) {

    private enum class TransactionType {
        Add, Replace
    }

    private val tag = BaseNavigator::class.java.name
    private var foregroundActivity: WeakReference<BaseActivity> = WeakReference(activity)

    @Suppress("IMPLICIT_CAST_TO_ANY")
    fun replaceFragment(fragment: BaseFragment, addToBackstack: Boolean) {
        makeFragmentTransaction(TransactionType.Replace, fragment, addToBackstack)
    }

    fun addFragment(fragment: BaseFragment, addToBackstack: Boolean) {
        makeFragmentTransaction(TransactionType.Add, fragment, addToBackstack)
    }

    @Suppress("UNUSED")
    fun clearBackStack() {
        getFragmentManager()?.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fun goBack() {
        getFragmentManager()?.popBackStack()
    }

    fun getFragmentManager(): FragmentManager? {
        return foregroundActivity.get()?.supportFragmentManager as FragmentManager
    }

    fun getForegroundActivity(): BaseActivity? {
        return foregroundActivity.get()
    }

    fun detachFragmentByTag(tag: String) {
        val fragmentManager = getFragmentManager()
        val fragmentFromTag = fragmentManager?.findFragmentByTag(tag)
        fragmentFromTag?.also {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(it)
            fragmentTransaction.commitAllowingStateLoss()
        }
    }

    private fun makeFragmentTransaction(transactionType: TransactionType, fragment: BaseFragment, addToBackstack: Boolean) {
        getFragmentManager()?.also {
            val transaction = it.beginTransaction()
            val fragmentTag = fragment.tagFragment()

            when (transactionType) {
                TransactionType.Add -> transaction.add(R.id.fragment_container, fragment, fragmentTag)
                TransactionType.Replace -> transaction.replace(R.id.fragment_container, fragment, fragmentTag)
            }

            if (addToBackstack) {
                transaction.addToBackStack(fragmentTag)
                transaction.commitAllowingStateLoss()
                it.executePendingTransactions()
            } else {
                val stateSaved = fragment.isStateSaved
                if (stateSaved) {
                    transaction.commitAllowingStateLoss()
                } else {
                    transaction.commit()
                }
            }
        }

        printBackStack()
    }

    private fun printBackStack() {
        getFragmentManager()?.also {
            val supportFragmentManager = getFragmentManager() ?: return
            val backStackEntryCount = supportFragmentManager.backStackEntryCount
            for (i in 0 until backStackEntryCount) {
                val backStackEntryAt = supportFragmentManager.getBackStackEntryAt(i)
                val name = backStackEntryAt.name
                Log.d(tag, "backStackEntry at: $i. Name: $name, object: $backStackEntryAt")
            }
        }
    }

}