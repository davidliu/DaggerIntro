package com.deviange.daggerintro.error_cases.component_inheritance

import dagger.Component
import dagger.Module
import dagger.Provides

class Thing

@Module
class ThingModule {
    @Provides
    fun providesThing() = Thing()
}

@Component(modules = [ThingModule::class])
interface ThingComponent {
    fun giveMeAThing(): Thing
}
/*
/**
 * This will error, since Dagger does not process super classes for annotations
 *
 * Only the [ThingComponent.giveMeAThing] method is inherited.
 */

@Component
interface InheritingComponent : ThingComponent {
}

 */