package co.uk.next.techtest.data.mapper

import co.uk.next.techtest.domain.model.Product
import co.uk.next.techtest.data.remote.dto.ProductDto

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        brand = brand,
        thumbnail = thumbnail,
        images = images
    )
}