package com.example.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutine.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        GlobalScope.launch {
//            delay(4000L)
//            Log.d(TAG, "Coroutine! from thread : ${Thread.currentThread().name}")
//        }
//        Log.d(TAG, "Hello! from thread : ${Thread.currentThread().name}")

//////////context switching
//        GlobalScope.launch(Dispatchers.IO){
//            Log.d(TAG, "Coroutine! from thread : ${Thread.currentThread().name}")
//            val answer=doNetworkCall()
//            withContext(Dispatchers.Main) {
//                Log.d(TAG, "Coroutine! from thread : ${Thread.currentThread().name}")
//                binding.textView.text = answer
//            }
//        }
//    }
//    suspend fun doNetworkCall():String{
//        delay(3000L)
//        return "this is the answer"
//    }


        //runBlocking

        Log.d(TAG, "Before runBlocking")
        runBlocking {
            launch (Dispatchers.IO){
                delay(3000L)
                Log.d(TAG, "Finished IO coroutine 1")
            }
            launch (Dispatchers.IO){
                delay(3000L)
                Log.d(TAG, "Finished IO coroutine 2")
            }
            Log.d(TAG, "start of runBlocking")
            delay(5000L)
            Log.d(TAG, "end of runBlocking")

        }
        Log.d(TAG, "After runBlocking")

    }
}