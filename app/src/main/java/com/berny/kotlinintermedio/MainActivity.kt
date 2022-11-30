package com.berny.kotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

typealias MyMapList = MutableMap<Int, ArrayList<String>>
typealias MyFun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = MyNestedAndInnerClasses.MyNestedClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enum Classes
        //enumClasses()

        // Nested and Inner Classes
        //nestedAndInnerClasses()

        // Class Inheritance

        //classInheritance()

        // Interfaces
        //interfaces()

        //Visibility Modifiers
        //visibilityModifiers()

        // Data Classes
        //dataClasses()

        // Type aliases
        //typeAliases()

        // Destructuring declarations
        //destructuringDeclarations()

        //Extensions
        //extensions()

        //Lambdas
        lambdas()
    }
    // Lección 1  Kotlin Intermedio : Enum Classes

    enum class Direction(val dir: Int) {

        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description() :String {
            return when (this) {
                NORTH -> "La direccion es NORTE"
                SOUTH -> "La dirección es SUR"
                EAST -> "La dirección es ESTE"
                WEST -> "La dirección es OESTE"
            }
        }
    }

    private fun enumClasses(){

        var userDirection: Direction? = null
        println("Direccion: $userDirection")

        userDirection = Direction.NORTH
        println("Direccion: $userDirection")

        userDirection = Direction.SOUTH
        println("Direccion: $userDirection")

        println("Propiedad name: ${userDirection.name}")
        println("Propiedad ordinal: ${userDirection.ordinal}")

        // Funciones
        println(userDirection.description())

        // Inicializacion
        println(userDirection.dir)

    }
    // Lección 2  Kotlin Intermedio : Nested and Inner Classes

    private fun nestedAndInnerClasses() {
        // Clase Anidada (nested)
        val myNestedClass = MyNestedClass()
        val sum = myNestedClass.sum(40, 50)
        println("el resultado de la suma es $sum")

        // Clase Interna (inner)
        val myInnerClass = MyNestedAndInnerClasses().MyInnerClass()
        val sumTwo = myInnerClass.sumTwo(20)
        println("El resultado de sumar dos es $sumTwo")

    }
    // Lección 3 Kotlin Intermedio : Class Inheritance (herencia)
    private fun classInheritance(){

        val person = Person("sara", 40)

        val programmer = Programmer("Bernardo", 31, "Kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()
        programmer.drive()

        val designer = Designer("Jesus", 33)
        designer.work()
        designer.goToWork()
        designer.drive()
    }

    // Leccion 4 Kotlin Intermedio : Interfaces

    private fun interfaces(){
        val gamer = Person("Bernardo", 31)
        gamer.play()
        gamer.stream()
    }

    // Leccion 5 Kotlin Intermedio : Visibility Modifiers

    private fun visibilityModifiers(){
        //val visibility = Visibility()
        //visibility.name = "Bernardo"
        //visibility.sayMyName()

        val visibilityTwo = VisibilityTwo()
        //visibilityTwo.sayMyNameTow()


    }

    // Leccion 6 Kotlin Intermedio : Data Classes

    private fun dataClasses(){
        val bernardo = Worker("Bernardo", 33, "programador")
        bernardo.lastWork = "Profesor"

        val sara = Worker()

        val ricardo = Worker("Bernardo", 33, "programador")
        ricardo.lastWork = "Profesor"

        // equals & hasCode
        if (bernardo == ricardo) {
            println(("Son iguales"))
        }else {
            println("No son iguales")
        }

        // to string
        println(bernardo.toString())

        // copy
        val bernardo2 = bernardo.copy(age = 35)
        println(bernardo.toString())
        println(bernardo2.toString())

        // ComponentN

        val(name, age, work) = bernardo
        println(name)
        println(age)
        println(work)
    }

    // Leccion 7 Kotlin Intermedio : Type aliases

    private var myMap: MyMapList = mutableMapOf()

    private fun typeAliases () {

        var myNewMap: MyMapList = mutableMapOf()
        myNewMap[1] = arrayListOf("Bernardo" , "Rabasa")
        myNewMap[2] = arrayListOf("Familia" , "de los Rabasa")

        myMap = myNewMap
    }

    // Leccion 8 Kotlin Intermedio : Destructuring declarations

    private fun destructuringDeclarations(){

        val (name, age, work) = Worker("Bernardo Rabasa", 31, "Programador")
        println("$name, $age, $work" )

        val bernardo = Worker("Bernardo", 34, "programador")
        println(bernardo.component1())
        println(bernardo.component2())
        println(bernardo.component3())

        val (bernardoName, bernardoAge, bernardoWork) = myWorker()
        println("$bernardoName, $bernardoAge, $bernardoWork")

        val myMap = mapOf(1 to "Bernardo", 2 to "Paulina", 3 to "Mi amorcito")
        for ((id,name) in myMap){
            println("$id, $name")
        }

    }

    private fun myWorker(): Worker {
        return  Worker("Bernardo Rabasa", 31, "Programador")
    }

    // Leccion 9 Kotlin Intermedio : Extensions

    private fun extensions(){
        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)

        var myDateNullable: Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)
    }

    private fun lambdas(){

        val myIntlist = arrayListOf(0,1,2,3,4,5,6,7,8,9,10)
        val myFilterIntList = myIntlist.filter {myInt ->

            println(myInt)
            if (myInt == 1 ){
                return@filter true
            }
            myInt > 5
        }
        println(myFilterIntList)

        val mySumFun = fun (x: Int, y: Int): Int = x + y
        val myMultFun = fun (x: Int, y: Int): Int = x * y

        myAsyncFun ("Bernardo") {
            print(it)
        }

        println(myOperateFun(5, 10, mySumFun))
        println(myOperateFun(5, 10, myMultFun))
        println(myOperateFun(5, 10) {x, y -> x- y})
    }

    private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int) : Int {
        return  myFun(x, y)
    }

    private fun myAsyncFun(name: String , hello: (String) -> Unit) {
        val myNewString = "Hello $name!"
        hello(myNewString)

        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }
    }
}