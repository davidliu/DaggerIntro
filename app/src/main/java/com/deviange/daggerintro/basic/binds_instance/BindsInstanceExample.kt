package com.deviange.daggerintro.basic.binds_instance

import dagger.BindsInstance
import dagger.Component
import dagger.Module

open class Wheels
class FireWheels : Wheels()

@Module
class FireWheelsModule {
    fun provideFireWheels(): FireWheels {
        return FireWheels()
    }
}

@Module
abstract class WheelsModule {
    /**
     * Equivalent to
     * @Provides
     * fun provideWheels(fire: FireWheels) = fire as Wheels
     */
    @BindsInstance
    abstract fun provideWheels(fire: FireWheels): Wheels
}


@Component(modules = [WheelsModule::class])
interface Component {
    // Will error, since it doesn't know FireWheels are Wheels.
    fun giveMeSomeWheels(): Wheels
}