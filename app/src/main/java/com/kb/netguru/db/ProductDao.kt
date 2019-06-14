package com.kb.netguru.db

import android.arch.persistence.room.*
import com.kb.netguru.models.Product
import io.reactivex.Flowable

@Dao
interface ProductDao {
    @Query("SELECT * FROM product WHERE shoppingListId = :shoppingId")
    fun getProducts(shoppingId: Int): Flowable<List<Product>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}