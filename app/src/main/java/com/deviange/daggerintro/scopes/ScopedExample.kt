package com.deviange.daggerintro.scopes

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
class ScopedModule {
    var increment = 0

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