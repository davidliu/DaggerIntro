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
     * @Binds is just a shortcut for @Provides. Here, the following method
     * is equivalent to:
     * 
     * @Provides
     * fun provideWheels(fire: FireWheels) = fire as Wheels
     * 
     * You can use it whenever you don't have any real executable code and you're
     * just casting the type from one to another. Since Dagger is strict about types,
     * and will not automatically use subclasses, these @Binds are useful for these methods.
     */
    @Binds
    abstract fun castThoseWheels(fire: FireWheels): Wheels
}


@Component(modules = [WheelsModule::class, FireWheelsModule::class])
interface Component {
    fun giveMeSomeWheels(): Wheels
}
