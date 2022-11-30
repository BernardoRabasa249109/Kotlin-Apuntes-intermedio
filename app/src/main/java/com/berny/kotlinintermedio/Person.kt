package com.berny.kotlinintermedio

open class Person (name: String, age: Int) :Work(), Game {

    // Cualquier clase tiene una super clase llamada "any"

   open fun work (){
        println("Esta persona esta trabajando")

    }

    override fun goToWork() {
        println("Esta persona va al trabajo")
    }

    // Game Interface

    override val game: String = "Among Us"

    override fun play() {
        println("Esta persona Esta gugando a $game")
    }

}