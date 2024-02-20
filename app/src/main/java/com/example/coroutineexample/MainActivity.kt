package com.example.coroutineexample

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity : AppCompatActivity() {
    private val TAG = "PRABHAT"
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var buttonexecuteTask: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.counter)
        button = findViewById(R.id.button)
        buttonexecuteTask = findViewById(R.id.btn_execute_task)
        Log.d(TAG, "onCreate: ${Thread.currentThread().name}")
      /*  button.setOnClickListener {
            Log.d(TAG, "onCreate: BUTTON CLICK ${Thread.currentThread().name}")
            updateCounter()
        }
        buttonexecuteTask.setOnClickListener {
            *//* thread(start = true) {

                 executeLongRunningTask()
             }*//*
            //coroutine
            CoroutineScope(Dispatchers.IO).launch {
                Log.d(TAG, "onCreate: CoroutineScope(Dispatchers.IO)-> ${Thread.currentThread().name}")
            }
            GlobalScope.launch(Dispatchers.Main) {

                Log.d(TAG, "onCreate: GlobalScope.launch(Dispatchers.Main)->  ${Thread.currentThread().name}")

            }
            MainScope().launch(Dispatchers.Default) {
                Log.d(TAG, "onCreate: MainScope().launch(Dispatchers.Default)-> ${Thread.currentThread().name}")


            }

        }*/


        //suspend function and modifier
        CoroutineScope(Dispatchers.Main).launch {
            task1()

        }
        CoroutineScope(Dispatchers.Main).launch {

            task2()
        }



    }

/*    fun updateCounter() {
        textView.text = "${textView.text.toString().toInt() + 1}"

    }
    private fun executeLongRunningTask() {
        for (i in 1..1000000000L) {

        }
    }*/

    suspend fun task1(){
        Log.d(TAG, "START task1: ")
//        yield()
        delay(1000)
        Log.d(TAG, "END task1: ")
    }

    suspend fun task2(){
        Log.d(TAG, "START task2: ")
//        yield()
        delay(2000)
        Log.d(TAG, "END task2: ")
    }
}