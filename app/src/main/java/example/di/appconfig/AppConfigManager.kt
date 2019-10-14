package example.di.appconfig

import io.reactivex.Single
import javax.inject.Singleton

@Singleton
class AppConfigManager {

    fun getAppConfig(): Single<AppConfig> {
        return Single.just(AppConfig(15))
    }
}