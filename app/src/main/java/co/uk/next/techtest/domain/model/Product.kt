package co.uk.next.techtest.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val brand: String? = null,
    val thumbnail: String,
    val images: List<String> = emptyList()
)