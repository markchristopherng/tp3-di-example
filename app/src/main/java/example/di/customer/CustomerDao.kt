package example.di.customer

import example.di.ActivityScope
import io.reactivex.Single
import javax.inject.Singleton

@Singleton
@ActivityScope
class CustomerDao {

    fun getCustomerDetails(): Single<Customer> {
        return Single.just(Customer("Mark", "Ng"))
    }
}