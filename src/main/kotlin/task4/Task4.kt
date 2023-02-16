package task4

import kotlin.concurrent.thread
import kotlin.reflect.full.createInstance

class Task4 {
    constructor() {}

    constructor(firstName: String, secondName: String) {}

    constructor(email: String) {}
}

fun <T : Any> customGeneric(array: Array<T>) {
    array.forEach {
        print(it)
        print(" ")
    }
    print("\n")
}

fun main() {
    val t = Thread()
    var n = 0
    thread(start = true) {
        repeat(4) {
            println("Hello world")
            Thread.sleep(1000)
        }
    }

    val obj1 = Task4("ostap", "pelo")
    val obj2 = Task4("some_email@gmail.com")

    println(Task4::class.constructors) // all contructors
    println(Task4::class.createInstance())
    customGeneric(arrayOf(0, 1, 2, 3, 4, 5, 6))
    customGeneric(arrayOf("a", "b", "c", "d"))
}