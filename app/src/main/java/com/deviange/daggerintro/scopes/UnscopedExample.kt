package com.deviange.daggerintro.scopes

import dagger.Component
import dagger.Module
import dagger.Provides

@Module
class UnscopedModule {
    var increment = 0

    @Provides
    fun provideIncrement() = increment++
}

@Component(modules = [UnscopedModule::class])
interface UnscopedComponent {
    fun giveMeIncrement(): Int
}