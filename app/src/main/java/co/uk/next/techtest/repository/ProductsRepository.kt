package co.uk.next.techtest.repository

import co.uk.next.techtest.data.Product
import co.uk.next.techtest.remote.FakeStoreApiClient



interface ProductsRepository {
    suspend fun getProducts(): List<Product>
    suspend fun getProduct(id: Int): Product
}
class ProductsRepositoryImpl(
    private val apiClient: FakeStoreApiClient
): ProductsRepository {

    override suspend fun getProducts(): List<Product> {
        return apiClient.getAllProducts().products
    }

    override suspend fun getProduct(id: Int): Product {
        return apiClient.getProduct(id)
    }
}
