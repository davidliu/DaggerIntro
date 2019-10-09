package com.deviange.daggerintro.scopes

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Reusable

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
}