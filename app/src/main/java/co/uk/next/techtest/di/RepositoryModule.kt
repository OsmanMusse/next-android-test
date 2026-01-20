package co.uk.next.techtest.di

import co.uk.next.techtest.data.repository.ProductsRepositoryImpl
import co.uk.next.techtest.domain.model.repository.ProductsRepository
import org.koin.dsl.module

val repositoryModule = module {
  single<ProductsRepository> { ProductsRepositoryImpl(get()) }
}