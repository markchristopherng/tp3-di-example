package example.di.customer

import example.di.ActivityScope
import io.reactivex.Single
import toothpick.InjectConstructor
import javax.inject.Singleton

@Singleton
@ActivityScope
@InjectConstructor
class CustomerManager(val customerDao: CustomerDao) {

    fun getCustomerDetails(): Single<Customer> {
        return customerDao.getCustomerDetails()
    }
}