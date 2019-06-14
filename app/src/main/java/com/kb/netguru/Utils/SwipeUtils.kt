package com.kb.netguru.Utils

import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.kb.netguru.NetguruApplication
import com.kb.netguru.R

class SwipeUtils {

    companion object {
        fun rightSwipe(
            canvas: Canvas,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            application: NetguruApplication
        ) {
            val itemView = viewHolder.itemView
            val paintPrimaryColor = Paint()
            paintPrimaryColor.color = ContextCompat.getColor(application, R.color.colorAccent)

            val paintWhite = Paint()
            val textSize = 14f * application.resources.displayMetrics.density
            paintWhite.color = ContextCompat.getColor(application, R.color.white)
            paintWhite.textSize = textSize
            paintWhite.color

            canvas.drawRect(
                itemView.left.toFloat(),
                itemView.top.toFloat(),
                itemView.left + dX,
                itemView.bottom.toFloat(),
                paintPrimaryColor
            )

            val title = "Delete"
            canvas.drawText(
                title,
                itemView.left.toFloat() + ViewUtils.dpToPx(12f, application),
                itemView.top.toFloat() + ((itemView.bottom.toFloat() - itemView.top.toFloat() + (textSize / 2)) / 2),
                paintWhite
            )
        }
    }
}