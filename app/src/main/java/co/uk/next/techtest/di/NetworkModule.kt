package co.uk.next.techtest.di

import co.uk.next.techtest.data.remote.FakeStoreApiClient
import org.koin.dsl.module

val networkModule = module {
    single { FakeStoreApiClient() }
}