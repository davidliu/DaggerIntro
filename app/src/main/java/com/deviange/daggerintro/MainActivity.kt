package com.deviange.daggerintro

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.deviange.daggerintro.scopes.DaggerReusableComponent
import com.deviange.daggerintro.scopes.DaggerScopedComponent
import com.deviange.daggerintro.scopes.DaggerUnscopedComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scopedComponent = DaggerScopedComponent.create()
        val unscopedComponent = DaggerUnscopedComponent.create()
        val reusableComponent = DaggerReusableComponent.create()
        for (i in 1..10) {
            Log.e("Scoped", scopedComponent.giveMeIncrement().toString())
        }
        for (i in 1..10) {
            Log.e("Unscoped", unscopedComponent.giveMeIncrement().toString())
        }
        for (i in 1..10) {
            Log.e("Reusable", reusableComponent.giveMeIncrement().toString())
        }

        val unscopedProvider = unscopedComponent.incrementProvider()
        val unscopedLazy = unscopedComponent.incrementLazy()

        for (i in 1..10) {
            Log.e("Unscoped Provider", unscopedProvider.get().toString())
        }
        for (i in 1..10) {
            Log.e("Unscoped Lazy", unscopedLazy.get().toString())
        }

    }
}
