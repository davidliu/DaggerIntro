package com.deviange.daggerintro.basic_module_inject

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Wheels @Inject constructor()
class Car @Inject constructor(val wheels: Wheels)

@Component
interface InjectedCarComponent {
    // Objects with @Inject constructors can be created without explicit resolution.
    // This will essentially give you a new Car(Wheels())
    fun giveMeACar(): Car
}

@Module
class WheelsModule {
    @Provides
    fun provideCoolWheels() = Wheels()
}
@Component(modules = [WheelsModule::class])
interface ModuleCarComponent{
    // However, if a provision is explicitly stated, that will be used instead.
    fun giveMeACar(): Car
}