package com.deviange.daggerintro.factory

import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module

open class Wheels
class FireWheels : Wheels()

@Module
abstract class WheelsModule {
    @Binds
    abstract fun castThoseWheels(fire: FireWheels): Wheels
}


@Component(modules = [WheelsModule::class])
interface Component {
    fun giveMeSomeWheels(): Wheels

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance fire: FireWheels = FireWheels()): com.deviange.daggerintro.factory.Component
    }
}
