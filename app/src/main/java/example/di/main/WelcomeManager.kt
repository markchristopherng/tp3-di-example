package example.di.main

import io.reactivex.Single
import javax.inject.Inject

class WelcomeManager @Inject constructor (val welcomeDao: WelcomeDao) {

    fun greet(): Single<String> {
        return welcomeDao.greet()
    }
}