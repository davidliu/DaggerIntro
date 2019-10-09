package com.deviange.daggerintro.basic.binds

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides

open class Wheels
class FireWheels : Wheels()

@Module
class FireWheelsModule {
    @Provides
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
    @Binds
    abstract fun castThoseWheels(fire: FireWheels): Wheels
}


@Component(modules = [WheelsModule::class, FireWheelsModule::class])
interface Component {
    fun giveMeSomeWheels(): Wheels
}