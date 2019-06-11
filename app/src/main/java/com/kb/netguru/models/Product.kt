package com.kb.netguru.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "product")
data class Product(
    @PrimaryKey(autoGenerate = true)
    @field:SerializedName("id")
    val id: Int,
    @ForeignKey(entity = ShoppingList::class, parentColumns = ["id"], childColumns = ["shoppingListId"], onDelete = ForeignKey.CASCADE)
    @field:SerializedName("shoppingListId")
    val shoppingListId: Int,
    @field:SerializedName("productName")
    val productName: String
)


