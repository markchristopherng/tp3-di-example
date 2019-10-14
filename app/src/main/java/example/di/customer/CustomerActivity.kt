package example.di.customer

import android.os.Bundle
import example.di.BaseActivity
import example.di.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_customer.closeBtn
import kotlinx.android.synthetic.main.activity_customer.customer_textview
import javax.inject.Inject

class CustomerActivity : BaseActivity(R.layout.activity_customer) {

    @Inject
    lateinit var customerManager: CustomerManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        closeBtn.setOnClickListener { finish() }

        customerManager.getCustomerDetails()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { customer ->
                displayCustomer(customer)
            }
    }

    fun displayCustomer(customer: Customer) {
        customer_textview.setText(customer.toString())
    }
}
