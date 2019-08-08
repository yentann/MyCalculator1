package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tv1.setOnClickListener { appendOnExpression("1", true) }
        tv2.setOnClickListener { appendOnExpression("2", true) }
        tv3.setOnClickListener { appendOnExpression("3", true) }
        tv4.setOnClickListener { appendOnExpression("4", true) }
        tv5.setOnClickListener { appendOnExpression("5", true) }
        tv6.setOnClickListener { appendOnExpression("6", true) }
        tv7.setOnClickListener { appendOnExpression("7", true) }
        tv8.setOnClickListener { appendOnExpression("8", true) }
        tv9.setOnClickListener { appendOnExpression("9", true) }


        //Operators
        tvplus.setOnClickListener { appendOnExpression("+", false) }
        tvminus.setOnClickListener { appendOnExpression("-", false) }
        tvequal.setOnClickListener { appendOnExpression("=", false) }
        tvstar.setOnClickListener { appendOnExpression("*", false) }
        tvslash.setOnClickListener { appendOnExpression("/", false) }


        //AC button
        tvAC.setOnClickListener {
            tvEx.text = ""
            tvResult.text = ""
        }

        //Equal button
        tvequal.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvEx.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            } catch (e:Exception) {
                Log.d("Exception", "message: " + e.message)
            }
        }

    }


        //Clear
        fun appendOnExpression(string: String, canClear: Boolean) {
            if(tvResult.text.isNotEmpty()) {
                tvEx.text = ""
            }
            if(canClear) {
                tvResult.text = ""
                tvEx.append(string)
            } else {
                tvEx.append(tvResult.text)
                tvEx.append(string)
                tvResult.text = ""


            }
    }
}
