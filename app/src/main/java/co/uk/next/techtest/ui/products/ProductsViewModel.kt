package co.uk.next.techtest.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.uk.next.techtest.domain.model.Product
import co.uk.next.techtest.domain.model.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductsViewModel(
     private val repo: ProductsRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        viewModelScope.launch {
            _products.value = repo.getProducts()
        }
    }
}
