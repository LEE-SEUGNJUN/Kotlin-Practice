package com.seugnjunlee.mycalculate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.seugnjunlee.mycalculate.databinding.ActivityMainBinding
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sumbutton1.setOnClickListener() {
            var result1 = binding.number1.text.toString()
            var result2 = binding.number2.text.toString()
            if (result1 == "" || result2 == "") {
                binding.sumbutton1.isEnabled = false
                binding.subbutton1.isEnabled = false
                binding.multibutton1.isEnabled = false
                binding.divbutton1.isEnabled = false

                Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG).show()
            } else {
                var null1: Double? = result1.toDoubleOrNull()
                var null2: Double? = result2.toDoubleOrNull()
                if (null1 == null || null2 == null) {
                    binding.sumbutton1.isEnabled = false
                    binding.subbutton1.isEnabled = false
                    binding.multibutton1.isEnabled = false
                    binding.divbutton1.isEnabled = false
                    Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG).show()
                } else {
                    var sum_result1 = result1.toDouble()
                    var sum_result2 = result2.toDouble()
                    var sum_total = sum_result1 + sum_result2
                    binding.sumbutton1.isEnabled = true
                    binding.subbutton1.isEnabled = true
                    binding.multibutton1.isEnabled = true
                    binding.divbutton1.isEnabled = true
                    binding.textView2.text = "$sum_total"
                }
            }
        }


        binding.subbutton1.setOnClickListener {
            var result1 = binding.number1.text.toString()
            var result2 = binding.number2.text.toString()
            if (result1 == "" || result2 == "") {
                binding.sumbutton1.isEnabled = false
                binding.subbutton1.isEnabled = false
                binding.multibutton1.isEnabled = false
                binding.divbutton1.isEnabled = false

                Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG).show()
            } else {
                var null1: Double? = result1.toDoubleOrNull()
                var null2: Double? = result2.toDoubleOrNull()
                if (null1 == null || null2 == null) {
                    binding.sumbutton1.isEnabled = false
                    binding.subbutton1.isEnabled = false
                    binding.multibutton1.isEnabled = false
                    binding.divbutton1.isEnabled = false
                    Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG)
                        .show()
                } else {
                    var sub_result1 = result1.toDouble()
                    var sub_result2 = result2.toDouble()
                    var sub_total = sub_result1 - sub_result2
                    binding.sumbutton1.isEnabled = true
                    binding.subbutton1.isEnabled = true
                    binding.multibutton1.isEnabled = true
                    binding.divbutton1.isEnabled = true
                    binding.textView2.text = "$sub_total"
                }
            }
        }

        binding.multibutton1.setOnClickListener {
            var result1 = binding.number1.text.toString()
            var result2 = binding.number2.text.toString()
            if (result1 == "" || result2 == "") {
                binding.sumbutton1.isEnabled = false
                binding.subbutton1.isEnabled = false
                binding.multibutton1.isEnabled = false
                binding.divbutton1.isEnabled = false

                Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG).show()
            } else {
                var null1: Double? = result1.toDoubleOrNull()
                var null2: Double? = result2.toDoubleOrNull()
                if (null1 == null || null2 == null) {
                    binding.sumbutton1.isEnabled = false
                    binding.subbutton1.isEnabled = false
                    binding.multibutton1.isEnabled = false
                    binding.divbutton1.isEnabled = false
                    Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG)
                        .show()
                } else {
                    var mul_result1 = result1.toDouble()
                    var mul_result2 = result2.toDouble()
                    var mul_total = mul_result1 * mul_result2
                    binding.sumbutton1.isEnabled = true
                    binding.subbutton1.isEnabled = true
                    binding.multibutton1.isEnabled = true
                    binding.divbutton1.isEnabled = true
                    binding.textView2.text = "$mul_total"
                }
            }
        }

        binding.divbutton1.setOnClickListener {
            var result1 = binding.number1.text.toString()
            var result2 = binding.number2.text.toString()
            if (result1 == "" || result2 == "") {
                binding.sumbutton1.isEnabled = false
                binding.subbutton1.isEnabled = false
                binding.multibutton1.isEnabled = false
                binding.divbutton1.isEnabled = false

                Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG).show()
            } else {
                var null1: Double? = result1.toDoubleOrNull()
                var null2: Double? = result2.toDoubleOrNull()
                if (null1 == null || null2 == null) {
                    binding.sumbutton1.isEnabled = false
                    binding.subbutton1.isEnabled = false
                    binding.multibutton1.isEnabled = false
                    binding.divbutton1.isEnabled = false
                    Toast.makeText(applicationContext, "수를 입력하셔야 합니다.", Toast.LENGTH_LONG)
                        .show()
                } else {
                    var div_result1 = result1.toDouble()
                    var div_result2 = result2.toDouble()
                    var div_total = div_result1 / div_result2
                    binding.sumbutton1.isEnabled = true
                    binding.subbutton1.isEnabled = true
                    binding.multibutton1.isEnabled = true
                    binding.divbutton1.isEnabled = true
                    binding.textView2.text = "$div_total"
                }
            }
        }

        binding.clearbutton1.setOnClickListener {

            binding.sumbutton1.isEnabled = true
            binding.subbutton1.isEnabled = true
            binding.multibutton1.isEnabled = true
            binding.divbutton1.isEnabled = true

            binding.textView2.text = "결과값"
            binding.number1.setText("")
            binding.number2.setText("")
            Toast.makeText(applicationContext, "초기화 합니다", Toast.LENGTH_LONG).show()

        }
        binding.exitbutton1.setOnClickListener {
            finish()

        }


    }
}


