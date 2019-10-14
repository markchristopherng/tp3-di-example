package example.di

import android.app.Application
import android.content.Context
import toothpick.config.Module

class AppModule(val application: Application) : Module() {

    init {
        val context = application.applicationContext
        bind(Application::class.java).toInstance(application)
        bind(Context::class.java).toInstance(context)
    }
}