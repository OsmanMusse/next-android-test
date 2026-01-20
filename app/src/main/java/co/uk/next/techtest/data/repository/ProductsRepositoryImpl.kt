package co.uk.next.techtest.data.repository

import co.uk.next.techtest.data.mapper.toProduct
import co.uk.next.techtest.domain.model.Product
import co.uk.next.techtest.data.remote.FakeStoreApiClient
import co.uk.next.techtest.domain.model.repository.ProductsRepository

class ProductsRepositoryImpl(
    private val apiClient: FakeStoreApiClient
): ProductsRepository {

    override suspend fun getProducts(): List<Product> {
        return apiClient.getAllProducts().products.map { it.toProduct() }
    }

    override suspend fun getProduct(id: Int): Product {
        return apiClient.getProduct(id).toProduct()
    }
}
