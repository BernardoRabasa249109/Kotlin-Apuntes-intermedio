package com.berny.kotlinintermedio

class Designer(name: String, age: Int):Person(name,age), Vehicle {
    override fun work() {
        println("esta persona esta diseñando")
    }

    override fun goToWork() {
        println("Esta persona va a el estudio")
    }

    override fun drive() {
        println("Esta persona maneja un Ferrary")
    }

}