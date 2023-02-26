package ug.kalemba.whatsappnumbergenerator.presentation

//import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ug.kalemba.whatsappnumbergenerator.util.getMyno
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() :ViewModel(){
    private val _number :MutableLiveData<String> =MutableLiveData<String>()



     private val number:String
     get()= countryCode+ (_number.value?:setNumber())

     private val _countryCode=MutableLiveData<String>()

     private val countryCode:String
     = _countryCode.value ?: setCountryCode()

    private fun setCountryCode(countryCode :String = "+256"): String {
       _countryCode.value = countryCode
        return countryCode
    }


   val phoneNumber :  MutableLiveData<String> by lazy {
       MutableLiveData<String>()
   }

    fun setPhoneNumber(){
        phoneNumber.value = number
    }

    fun setNumber() :String{
    _number.value= getMyno()
        setPhoneNumber()
    return  _number.value!!
}
/*
    fun setCountryCode(code : String="+256"): String{
        if (_countryCode==null){
            _countryCode = MutableLiveData<String>()
        }
        _countryCode.value = code
        return code
    }*/

}