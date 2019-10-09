package com.deviange.daggerintro.composition.basic_dependencies

import dagger.Component

class Gson

class DependenciesImpl : Dependencies {
    override fun api() = Api()

    // This won't be consumed since it's not declared by Depdendencies
    fun gson() = Gson()
}

@Component(dependencies = [Dependencies::class])
interface Component {
    // OK
    fun giveMeAnApi(): Api

    // Will error, can't find gson.
    // fun giveMeAGson(): Gson
}