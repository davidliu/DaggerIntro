package com.deviange.daggerintro.basic_module_dependency

import com.deviange.daggerintro.basic_module.Car
import com.deviange.daggerintro.basic_module.CarModule
import dagger.Component
import dagger.Module
import dagger.Provides

class Wheels
class Car(val wheels: Wheels)

@Module
class WheelsModule {
    @Provides
    fun provideCoolWheels() = Wheels()
}

@Module
class CarModule {
    // Note that wheels isn't provided within the CarModule.
    // It's resolved at the the Component level.
    @Provides
    fun providesCar(wheels: Wheels) = Car(wheels)
}

@Component(modules = [CarModule::class, WheelsModule::class])
interface WheeledCarComponent {
    // Since we provided a WheelsModule, it'll query WheelModule.provideCoolWheels()
    // for wheels, and pass it to CarModule.providesCar(wheels).
    fun giveMeACar(): Car
}