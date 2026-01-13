package co.uk.next.techtest.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.uk.next.techtest.data.Product
import co.uk.next.techtest.remote.FakeStoreApiClient
import co.uk.next.techtest.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    private val repository = ProductsRepository(FakeStoreApiClient())

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        viewModelScope.launch {
            _products.value = repository.getProducts()
        }
    }
}
