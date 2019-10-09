package com.deviange.daggerintro.error_cases.component_types

import dagger.Component
import dagger.Module

open class Wheels
class FireWheels : Wheels()

//@Module
class WheelsModule {
    fun provideWheels(): FireWheels {
        return FireWheels()
    }
}

//@Component(modules = [WheelsModule::class])
interface Component {
    // Will error, since it doesn't know FireWheels are Wheels.
    fun giveMeSomeWheels(): Wheels
}