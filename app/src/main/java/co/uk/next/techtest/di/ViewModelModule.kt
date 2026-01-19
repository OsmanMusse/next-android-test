package co.uk.next.techtest.di

import co.uk.next.techtest.ui.productdetails.ProductDetailsViewModel
import co.uk.next.techtest.ui.products.ProductsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ProductsViewModel(
            repo = get()
        )
    }

    viewModel {
        ProductDetailsViewModel(
            repo = get()
        )
    }
}