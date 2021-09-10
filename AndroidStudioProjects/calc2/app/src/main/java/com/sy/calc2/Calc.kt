package com.sy.calc2

class Calc :Calculator{
    override fun add(a:Int, b:Int) = a+b

    override fun subtract(a:Int, b:Int) = a-b

    override fun multiply(a:Int, b:Int) = a*b

    override fun divide(a:Int, b:Int) = a/b
}