package example.di.paybill

import io.reactivex.Single
import toothpick.InjectConstructor

/**
 * Created by markng on 13/3/18.
 */

@InjectConstructor
class PayBillManager(val payBillDao: PayBillDao) : IPayBillManager {

    /**
     * Get all saved billers in the db
     *
     * @return
     */
    override fun getAll(): Single<List<SavedBill>> {

        return payBillDao.getAll()
    }
}