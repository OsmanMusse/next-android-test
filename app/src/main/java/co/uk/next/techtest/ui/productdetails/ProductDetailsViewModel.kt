package co.uk.next.techtest.ui.productdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.uk.next.techtest.domain.model.Product
import co.uk.next.techtest.domain.model.repository.ProductsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductDetailsViewModel(
    private val repo: ProductsRepository
): ViewModel() {

    private val _uiState = MutableStateFlow<ProductDetailsUiState>(ProductDetailsUiState.Loading)
    val uiState: StateFlow<ProductDetailsUiState> = _uiState.asStateFlow()

    fun onStart(productId: Int){
        viewModelScope.launch {
            _uiState.value = ProductDetailsUiState.Loading
            runCatching {
                repo.getProduct(productId)
            }.onSuccess { product ->
                _uiState.value = ProductDetailsUiState.Success(product)
            }.onFailure {
                _uiState.value = ProductDetailsUiState.Error(
                    message = "Couldn’t load product. Please try again."
                )
            }
        }
    }
}

sealed interface ProductDetailsUiState {
    data object Loading : ProductDetailsUiState
    data class Success(val product: Product) : ProductDetailsUiState
    data class Error(val message: String) : ProductDetailsUiState
}