package kz.kd.hw_116

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val code_key = "COUNTER"

class MainActivity : AppCompatActivity() {
    private val numbers: MutableList<Int> = mutableListOf()
    lateinit var code: TextView

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("MainActivity", "onSaveInstanceState() is called")
        outState.putString(code_key, numbers.joinToString(separator = ""))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("MainActivity", "onRestoreInstanceState() is called")
        code.text = savedInstanceState.getString(code_key)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy() is called")
    }

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        code = findViewById(kz.kd.hw_116.R.id.code)
        Log.d("MainActivity", "onCreate() is called")

        val one1: Button = findViewById(R.id.button_one)
        one1.setOnClickListener {
            codeNum(1, numbers, code)
        }
        val two: Button = findViewById(R.id.button_two)
        two.setOnClickListener {
            codeNum(2, numbers, code)
        }
        val three: Button = findViewById(R.id.button_three)
        three.setOnClickListener {
            codeNum(3, numbers, code)
        }
        val four: Button = findViewById(R.id.button_four)
        four.setOnClickListener {
            codeNum(4, numbers, code)
        }
        val five: Button = findViewById(R.id.button_five)
        five.setOnClickListener {
            codeNum(5, numbers, code)
        }
        val six: Button = findViewById(R.id.button_six)
        six.setOnClickListener {
            codeNum(6, numbers, code)
        }
        val seven: Button = findViewById(R.id.button_seven)
        seven.setOnClickListener {
            codeNum(7, numbers, code)
        }
        val eight: Button = findViewById(R.id.button_eight)
        eight.setOnClickListener {
            codeNum(8, numbers, code)
        }
        val nine: Button = findViewById(R.id.button_nine)
        nine.setOnClickListener {
            codeNum(9, numbers, code)
        }
        val zero: Button = findViewById(R.id.button_zero)
        zero.setOnClickListener {
            codeNum(0, numbers, code)
        }
        val del: Button = findViewById(R.id.button_del)
        del.setOnClickListener {
            if (numbers.size != 0) {
                numbers.removeLast()
                code.text = numbers.joinToString(separator = "")
            }
            else if (code.text != "") {
                code.text = ""
            }
            color(code)
        }
        val ok: Button = findViewById(R.id.button_ok)
        ok.setOnClickListener {
            if (numbers.size == 4 && code.text.equals("1567")) {
                code.setTextColor(Color.parseColor("#17DB5A"))
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,SecondActivity::class.java)
                startActivity(intent)
            } else {
                code.setTextColor(Color.parseColor("#F91717"))
                Toast.makeText(this, "Wrong PIN!", Toast.LENGTH_SHORT).show()
            }
            numbers.clear()
        }

    }

    private fun codeNum (digit: Int, numbers_copy: MutableList<Int>, code_text: TextView) {
        removeLast(numbers_copy)
        numbers_copy.add(digit)
        code_text.text = numbers_copy.joinToString(separator = "")
        color(code_text)
    }

    private fun color(code_text: TextView) {
        code_text.setTextColor(Color.parseColor("#1789DB"))
    }

    private fun removeLast(numbers_copy: MutableList<Int>) {
        while (numbers_copy.size > 3) {
            numbers_copy.removeLast()
        }
    }
}