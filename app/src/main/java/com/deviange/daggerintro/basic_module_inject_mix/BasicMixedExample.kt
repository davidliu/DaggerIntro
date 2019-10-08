package com.deviange.daggerintro.basic_module_inject_mix

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Wheels
class Car @Inject constructor(val wheels: Wheels)

@Module
class WheelsModule {
    @Provides
    fun provideCoolWheels() = Wheels()
}

@Component(modules = [WheelsModule::class])
interface WheeledCarComponent {
    // While Car isn't registered through a Module, it has an inject constructor.
    // It requires a Wheels object, which will be gotten through WheelsModule.
    fun giveMeACar(): Car
}