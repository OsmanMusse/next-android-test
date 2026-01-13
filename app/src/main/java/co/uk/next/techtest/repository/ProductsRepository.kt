package co.uk.next.techtest.repository

import co.uk.next.techtest.data.Product
import co.uk.next.techtest.remote.FakeStoreApiClient

class ProductsRepository(private val apiClient: FakeStoreApiClient) {

    suspend fun getProducts(): List<Product> {
        return apiClient.getAllProducts().products
    }
}
