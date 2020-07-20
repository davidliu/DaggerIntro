package com.deviange.daggerintro.scopes

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class UnscopedModule {
    var increment = 0

    /**
     * Since this is unscoped, every time an Int is requested, the provides method will be called.
     */
    @Provides
    fun provideIncrement() = increment++
}

@Component(modules = [UnscopedModule::class])
interface UnscopedComponent {
    fun giveMeIncrement(): Int
    fun incrementProvider(): Provider<Int>
    fun incrementLazy(): dagger.Lazy<Int>
}
