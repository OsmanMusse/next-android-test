package co.uk.next.techtest.di

import android.app.Application
import org.koin.core.context.startKoin

class NextApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModules)
        }
    }
}