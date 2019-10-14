package example.di.main

import android.content.Context
import android.content.Intent
import example.di.customer.CustomerActivity
import example.di.paybill.PayBillActivity
import toothpick.InjectConstructor

@InjectConstructor
class NavigationHelper(val context: Context) : INavigationHelper {

    override fun gotoPayABill() {
        context.startActivity(Intent(context, PayBillActivity::class.java))
    }

    override fun gotoCustomerDetails() {
        context.startActivity(Intent(context, CustomerActivity::class.java))
    }
}