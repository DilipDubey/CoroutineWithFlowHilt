package com.ril.fieldtravelclone

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ril.fieldtravelclone.login_module.LoginViewModel1
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel1 by viewModels()
   // private val loginObserver=Observer<NetworkResult1<String>>{ response->consumeResLogin(response)}
    lateinit var tv_click:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_click = findViewById(R.id.tv_click)

        tv_click.setOnClickListener {
            Log.e("dkd", "dkd clicked")
            loginViewModel.login()
        }

        println("test")
        //Using livedata
//        loginViewModel.loginRes.observe(this){
//            Log.e("dkd","dkd res1-"+it)
//
//            when(it){
//                is NetworkResult1.Success-> {
//                    Log.e("dkd","dkd res-"+it)
//
//                }
//            }
//        }

          //Using flow
        lifecycleScope.launch {
            loginViewModel.loginRes.collect{
                Log.e("dkd",it.toString())
            }

        }
    }

}