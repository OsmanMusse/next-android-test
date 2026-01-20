package co.uk.next.techtest.domain.model.repository

import co.uk.next.techtest.domain.model.Product


interface ProductsRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProduct(id: Int): Product
}