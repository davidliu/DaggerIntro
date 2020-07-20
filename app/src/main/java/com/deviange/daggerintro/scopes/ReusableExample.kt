package com.deviange.daggerintro.scopes

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Provider

@Module
class ReusableModule {
    var increment = 0

    /**
     * @Reusable is like a non-synchronized lazy; once provided, the same value
     * will be provided every time, and the provide method won't be called again.
     */
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
