package com.kb.netguru.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.kb.netguru.models.Converters.DateConverter
import java.util.*

@Entity(tableName = "shoppingList")
@TypeConverters(DateConverter::class)
data class ShoppingList(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("shoppingListsName")
    val shoppingListsName: String,
    @field:SerializedName("createDate")
    val createDate: Date,
    @field:SerializedName("isArchived")
    val isArchived: Boolean
)