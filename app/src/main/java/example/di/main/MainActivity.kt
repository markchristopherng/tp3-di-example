package example.di.main

import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import example.di.BaseActivity
import example.di.R
import example.di.paybill.IPayBillDao
import example.di.paybill.IPayBillManager
import example.di.paybill.PayBillDao
import example.di.paybill.PayBillManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.customerBtn
import kotlinx.android.synthetic.main.activity_main.payBillBtn
import toothpick.Scope
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module
import toothpick.ktp.delegate.inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    val navigationHelper: INavigationHelper by inject()

    val welcomeManager: WelcomeManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        payBillBtn.setOnClickListener { navigationHelper.gotoPayABill() }
        customerBtn.setOnClickListener { navigationHelper.gotoCustomerDetails() }

        welcomeManager.greet()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe { s ->
                Toast.makeText(this, s, Toast.LENGTH_LONG).show()
            }
    }

    override fun getScope(): Scope {

        return super.getScope().installModules(module {
            bind<WelcomeDao>()
            bind<WelcomeManager>()
        })
    }
}
