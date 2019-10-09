package com.deviange.daggerintro.basic.basic_module

import dagger.Component
import dagger.Module
import dagger.Provides

class Car

@Module
class CarModule {
    @Provides
    fun providesCar() = Car()
}

@Component(modules = [CarModule::class])
interface CarComponent {
    fun giveMeACar(): Car // Will query CarModule.providesCar() for the answer.
}