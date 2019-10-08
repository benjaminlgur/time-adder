package com.example.adder2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addbut.setOnClickListener {
            var first = time1.text.toString()
            var second = time2.text.toString()
            if (first.length == 4)
                first = "0".plus(first)
            if (second.length == 4)
                second = "0".plus(second)
            output.text = timeAdd(first, second)
        }
    }

    private fun timeAdd(time1: String, time2: String): String {
        //error check
        if(!time1.contains(":") || !time2.contains(":"))
            return "error"

        val hour1 = time1.substring(0, 2).toInt()
        val min1 = time1.substring(3, 5).toInt()
        val hour2 = time2.substring(0, 2).toInt()
        val min2 = time2.substring(3, 5).toInt()
        var outHour = hour1 + hour2
        while (outHour > 12)
            outHour = outHour - 12
        var outMin = min1 + min2
        while (outMin >= 60) {
            outMin = outMin - 60
            outHour++
        }
        var outHourStr = outHour.toString()
        if (outHourStr.toInt() < 10)
            outHourStr = "0".plus(outHourStr)
        var outMinStr = outMin.toString()
        if (outMinStr.toInt() < 10)
            outMinStr = "0".plus(outMinStr)
        val outTime = outHourStr.plus(":").plus(outMinStr)
        return  outTime
    }
}
