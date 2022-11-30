package com.berny.kotlinintermedio

class Programmer(name: String, age: Int, val language: String):Person(name,age), Vehicle {
    override fun work() {
        println("esta persona esta programando")
    }

    fun sayLanguage(){
        println("Este programador usa el lenguaje $language")
    }

    override fun goToWork() {
        println("Esta Persona va a Google")
    }

    override fun drive() {
        println("Esta persona conduce un coche")
    }

}