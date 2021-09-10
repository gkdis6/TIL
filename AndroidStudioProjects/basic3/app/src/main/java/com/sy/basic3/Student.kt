package com.sy.basic3

import android.widget.TextView

class Student(override var name:String?) : Person(name) {
    constructor(alias: String?, age:Int?, address:String?):this(alias){
        this.age = age
        this.address = address
    }

    override fun walk(output: TextView) {
        // super.walk(output) 원래의 코드를 호출
        output.text = "학생이 걷는다."
    }
}