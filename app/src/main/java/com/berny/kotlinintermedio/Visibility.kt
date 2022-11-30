package com.berny.kotlinintermedio

class Visibility {
    var name: String? = null

    fun sayMyName(){
        name?.let {
            println("Mi nombre es $it")
        }?: run {
           println("no tengo nombre")
        }
    }
}

open class VisibilityTwo {
    protected fun sayMyNameTow () {
        val visibility = Visibility()
        visibility.name ="Bernardo"
    }

}

class VisibilityThree: VisibilityTwo(){

    internal val age: Int? = null

    fun sayMyNameThree() {
        sayMyNameTow()
    }
}