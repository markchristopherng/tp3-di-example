package example.di.paybill

import io.reactivex.Single
import toothpick.InjectConstructor

@InjectConstructor
class PayBillDao : IPayBillDao {

    override fun getAll(): Single<List<SavedBill>> {
        var list = mutableListOf(
            SavedBill(1, "Company A", "ABC", "123"),
            SavedBill(2, "Company B", "DEF", "456"),
            SavedBill(3, "Company C", "GHI", "789")
        )
        return Single.just(list)
    }
}