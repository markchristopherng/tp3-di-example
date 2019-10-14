package example.di.paybill

import io.reactivex.Single

interface IPayBillManager {

    fun getAll(): Single<List<SavedBill>>
}