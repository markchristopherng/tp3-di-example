package example.di.main

import io.reactivex.Single
import javax.inject.Inject

class WelcomeDao @Inject constructor() {

    fun greet(): Single<String> {
        return Single.just("Hello there")
    }
}