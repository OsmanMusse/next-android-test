package co.uk.next.techtest.di

import co.uk.next.techtest.repository.ProductsRepository
import co.uk.next.techtest.repository.ProductsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
  single<ProductsRepository> { ProductsRepositoryImpl(get()) }
}