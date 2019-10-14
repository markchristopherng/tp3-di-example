package example.di.paybill

import io.reactivex.Single

interface IPayBillDao {

    fun getAll(): Single<List<SavedBill>>
}