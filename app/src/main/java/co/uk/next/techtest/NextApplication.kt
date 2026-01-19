package co.uk.next.techtest

import android.app.Application
import co.uk.next.techtest.di.appModules
import org.koin.core.context.startKoin

class NextApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}