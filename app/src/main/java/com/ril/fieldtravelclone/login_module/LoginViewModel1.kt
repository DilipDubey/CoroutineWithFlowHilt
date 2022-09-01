package com.ril.fieldtravelclone.login_module

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel1 @Inject constructor(private val loginRepository: LoginRepository):ViewModel() {

    //Using Livedata
//    private val _loginRes=MutableLiveData<NetworkResult1<String>>()
//    var loginRes:LiveData<NetworkResult1<String>> =_loginRes

  //Using Livedata
//    fun login(){
//        viewModelScope.launch {
//            val res=loginRepository.login().collect{
//                it->
//                _loginRes.postValue(it)
//            }
//
//        }
//    }


    //Using flow
    val loginRes= MutableStateFlow<NetworkResult1<String>>(NetworkResult1.Loading(true))
    //Using flow
    fun login(){
        viewModelScope.launch {
            Log.e("dkd"," launch login")
            val res=loginRepository.login().collect{
                it->{loginRes.value=it}
            }

        }
    }

}