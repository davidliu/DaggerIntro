package com.deviange.daggerintro.scopes

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class ScopedModule {
    var increment = 0

    /**
     * Scopes are like a synchronized lazy; once provided, the same value
     * will be provided every time, and the provide method won't be called again.
     */
    @Singleton
    @Provides
    fun provideIncrement(): Int = increment++
}

@Singleton
@Component(modules = [ScopedModule::class])
interface ScopedComponent {
    fun giveMeIncrement(): Int
    fun incrementProvider(): Provider<Int>
    fun incrementLazy(): dagger.Lazy<Int>
}
