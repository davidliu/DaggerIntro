package com.deviange.daggerintro.composition.basic_subcomponent

import android.app.Activity
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject

class Api

@Module
class ApiModule {
    @Provides
    fun providesApi() = Api()
}

@Module(subcomponents = [ActivitySubcomponent::class])
class SubcomponentModule

@Component(modules = [ApiModule::class, SubcomponentModule::class])
interface ApplicationComponent {
    fun activitySubComponentFactory(): ActivitySubcomponent.Factory
}


class Activity
class Tracker @Inject constructor(activity: Activity, api: Api)
@Module
class ActivityModule {
    @Provides
    fun providesActivity() = Activity()
}

@Subcomponent(modules = [ActivityModule::class])
interface ActivitySubcomponent {
    fun giveMeATracker(): Tracker

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivitySubcomponent
    }
}