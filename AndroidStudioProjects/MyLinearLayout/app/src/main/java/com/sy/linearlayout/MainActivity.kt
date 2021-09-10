package com.sy.linearlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sy.linearlayout.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val names = arrayOf("홍길동1", "홍길동2", "홍길동3")
            val names2 = Array<String>(3, {index -> "홍길동${index+1}"})
            val names3 = arrayOfNulls<String>(3)
            val names4 = emptyArray<String>()

            binding.output1.append("\nnames : ${Arrays.toString(names)}")
            binding.output1.append("\nnames2 : ${Arrays.toString(names2)}")
            binding.output1.append("\nnames3 : ${Arrays.toString(names3)}")
            binding.output1.append("\nnames4 : ${Arrays.toString(names4)}")

            val digits = intArrayOf(1, 2, 3)
            digits[2] = 4
            val aDigits = digits[2]
            val digitCount = digits.count()
            val digitSize = digits.size

            binding.output1.append("\ndigits 배열크기 : $digitCount")
            binding.output1.append("\ndigits 배열크기 : $digitSize")

            val digits2 = digits.plus(5)
            val aIndex = digits2.indexOf(5)//어디에 있는지 위치를 알려주는 것
            val digits3 = digits2.sliceArray(1..aIndex)
            //binding.output1.append("\ndigits3 : ${Arrays.toString(digits3)}")
            binding.output1.append("\ndigits3 : ${digits3.contentToString()}")

            digits.forEachIndexed { index, i ->
                binding.output1.append("\n#${index} : ${i}")
            }

            var iIndex = 0
            for (elem in digits){
                binding.output1.append("\n${iIndex} : ${elem}")
                iIndex += 1
            }

            val iter = digits.iterator()
            var jIndex = 0
            while(iter.hasNext()){
                val elem = iter.next()
                binding.output1.append("\n${jIndex} : ${elem}")
                jIndex += 1
            }
        }
    }
}