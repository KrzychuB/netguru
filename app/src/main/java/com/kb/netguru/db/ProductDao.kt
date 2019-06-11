package com.kb.netguru.db

import android.arch.persistence.room.*
import com.kb.netguru.models.Product

@Dao
interface ProductDao {
//    @Query("SELECT * FROM product")
//    fun getProducts()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}