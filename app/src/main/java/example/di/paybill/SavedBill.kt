package example.di.paybill

/**
 * Created by markng on 9/3/18.
 */

data class SavedBill(
    var id: Int = 0,
    var billerName: String? = null,
    var billpayCode: String?,
    var referenceNumber: String?
)