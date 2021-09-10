package com.sy.basic3

import android.widget.TextView

open class Person(open var name:String?) {
    var age:Int? = null
    var address:String? = null

    constructor(name:String?, age:Int?, address:String?):this(name){
        this.age = age
        this.address = address
    }
    open fun walk(output: TextView){
        output.text = "사람이 걷는다."
    }
}