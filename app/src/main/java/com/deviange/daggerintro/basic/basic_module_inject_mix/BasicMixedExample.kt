package com.deviange.daggerintro.basic.basic_module_inject_mix

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
     
    // This shows @Inject and @Provides work together to fulfill the component's needs.
    //
    // While Car isn't registered through a Module, it has an inject constructor.
    // It requires a Wheels object, which will be gotten through WheelsModule.
    //
    // Note that since Wheels doesn't have an @Inject constructor,
    // it needs to be explicitly provided by a Module.
    
    fun giveMeACar(): Car
}
