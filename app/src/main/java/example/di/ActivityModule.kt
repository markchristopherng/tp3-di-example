package example.di

import android.app.Activity
import android.content.Context
import example.di.main.INavigationHelper
import example.di.main.NavigationHelper
import toothpick.config.Module

class ActivityModule(activity: Activity) : Module() {

    init {
        bind(Context::class.java).toInstance(activity)
        bind(INavigationHelper::class.java).toInstance(NavigationHelper(activity))
    }
}