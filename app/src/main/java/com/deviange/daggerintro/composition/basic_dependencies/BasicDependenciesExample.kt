package com.deviange.daggerintro.composition.basic_dependencies

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

class Api
interface Dependencies {
    fun api(): Api
}

@Component(
    modules = [ActivityModule::class],
    dependencies = [Dependencies::class]
)
interface ActivityComponent {
    // Will take the Api object from the Dependencies object to make the Tracker.
    fun giveMeATracker(): Tracker
}


class Activity
class Tracker @Inject constructor(activity: Activity, api: Api)
@Module
class ActivityModule {
    @Provides
    fun providesActivity() = Activity()
}