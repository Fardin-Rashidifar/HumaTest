package f.r.f.hamrahanandroidkotlin.viewModel

import android.content.Context
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import f.r.f.hamrahanandroidkotlin.model.ModelAddCustomerActivity
import javax.inject.Inject

@HiltViewModel
class ViewModelAddCustomerActivity @Inject constructor(
    @ApplicationContext
    private val context: Context,
    private val model: ModelAddCustomerActivity
) : ViewModel() ,
    Observable {

    @Bindable
    val textFirstName = MutableLiveData<String>()

    @Bindable
    val textLastName = MutableLiveData<String>()

    fun getErrorEmptyField() = model.getErrorEmptyField()


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}