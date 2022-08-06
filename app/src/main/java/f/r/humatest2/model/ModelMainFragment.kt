package f.r.f.hamrahanandroidkotlin.model

import f.r.f.hamrahanandroidkotlin.R
import f.r.f.hamrahanandroidkotlin.Utils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ModelAddCustomerActivity @Inject constructor() {

    private val errorEmptyField = R.string.errorEmptyField

    fun getErrorEmptyField() = errorEmptyField


}
