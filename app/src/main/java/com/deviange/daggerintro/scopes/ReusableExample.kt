package com.deviange.daggerintro.scopes

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Provider

@Module
class ReusableModule {
    var increment = 0

    @Reusable
    @Provides
    fun provideIncrement() = increment++
}

@Component(modules = [ReusableModule::class])
interface ReusableComponent {
    fun giveMeIncrement(): Int
    fun incrementProvider(): Provider<Int>
    fun incrementLazy(): dagger.Lazy<Int>
}