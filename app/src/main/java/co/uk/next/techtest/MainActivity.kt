package co.uk.next.techtest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import co.uk.next.techtest.ui.theme.NextTakeHomeTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NextTakeHomeTestTheme {
                NextNavHost()
            }
        }
    }
}
