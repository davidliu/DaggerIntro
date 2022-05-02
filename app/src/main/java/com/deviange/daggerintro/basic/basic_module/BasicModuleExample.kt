package com.deviange.daggerintro.basic.basic_module

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Provider;

class Car

@Module
class CarModule {
    @Provides
    fun providesCar() = Car()
}

@Component(modules = [CarModule::class])
interface CarComponent {
    fun giveMeACar(): Car // Will query CarModule.providesCar() for the answer.
    fun giveMeACarProvider(): Provider<Car> // Gives a Provider<Car> object that can do the same thing as CarComponent.giveMeACar()
}
