package com.kb.netguru.Utils

import android.util.TypedValue
import com.kb.netguru.NetguruApplication

object ViewUtils {
    fun dpToPx(dp: Float, application: NetguruApplication): Int {
        val resources = application.resources
        val displayMetrics = resources.displayMetrics
        val px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
        return px.toInt()
    }
}