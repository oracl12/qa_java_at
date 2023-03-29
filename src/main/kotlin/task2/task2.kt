package task2

class Task2(private val a: Int, private val b: Int) {
    fun andFunc(): Int {
        return a and b
    }

    fun orFunc(): Int {
        return a or b
    }

    fun invFunc(value: Int): Int {
        return value.inv()
    }

    fun shlAFunc(value: Int): Int {
        return a shl value
    }

    fun shrAFunc(value: Int): Int {
        return a shr value
    }

    fun ushrAFunc(value: Int): Int {
        return a ushr value
    }
}