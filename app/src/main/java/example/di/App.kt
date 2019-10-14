package example.di

import android.app.Application
import example.di.AppConsants.Companion.APPSCOPE
import example.di.appconfig.AppConfigManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import toothpick.configuration.Configuration
import toothpick.ktp.KTP
import toothpick.ktp.delegate.inject

class App : Application() {

    val appConfigManager: AppConfigManager by inject()

    override fun onCreate() {
        super.onCreate()
        initializeToothpick()

        appConfigManager.getAppConfig().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { appConfig ->
                // set timeout
            }
    }

    private fun initializeToothpick() {

        if (BuildConfig.DEBUG) {
            KTP.setConfiguration(Configuration.forDevelopment())
            KTP.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes())
        }

        KTP.openRootScope()
            .openSubScope(APPSCOPE)
            .installModules(AppModule(this))
            .inject(this)
    }
}