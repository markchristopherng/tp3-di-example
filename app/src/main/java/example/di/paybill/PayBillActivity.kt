package example.di.paybill

import android.os.Bundle
import example.di.BaseActivity
import example.di.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_pay_bill.bills_textview
import kotlinx.android.synthetic.main.activity_pay_bill.closeBtn
import toothpick.Scope
import toothpick.ktp.binding.bind
import toothpick.ktp.binding.module
import toothpick.ktp.delegate.inject

class PayBillActivity() : BaseActivity(R.layout.activity_pay_bill) {

    val payBillManager: IPayBillManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        closeBtn.setOnClickListener { finish() }

        payBillManager.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { bills ->
                displayBills(bills)
            }
    }

    override fun getScope(): Scope {

        return super.getScope().installModules(module {
            bind<IPayBillDao>().toClass<PayBillDao>()
            bind<IPayBillManager>().toClass<PayBillManager>()
        })
    }

    fun displayBills(bills: List<SavedBill>) {
        bills_textview.text = bills.toString()
    }
}
