package task3

import java.lang.Exception
import java.util.Collections

/*
Array Rotation: Write a Java program that takes an array of integers and rotates
it by a given number of positions. Your program should prompt the user to enter the array size
and the elements of the array, and then the number of positions to rotate the array.
Finally, your program should output the rotated array.
Make ArrayList from the result array and performs the following operations:
 a) Add an element to the end of the list;
 b) Remove an element from the list;
 c) Replace an element in the list;
 d) Sort the list in alphabetical order;
 e) Print the elements of the list;
Make up the situation for NumberFormatException. Catch it and display the explanation for your custom case.*/

fun main() {
    try {
        println("Enter start size of array")
//        val a = 1 / 0 // to check another catch
        val size = readln().toInt()
        val array = IntArray(size)

        println("Enter elements of array")
        for (i: Int in 0 until size) {
            array[i] = readln().toInt()
        }

        println("Enter start number to rotate array")
        val rotateN = readln().toInt()

        for (i: Int in 0 until rotateN) {
            val x = array[size - 1]
            var e = size - 1
            while (e > 0) {
                array[e] = array[e - 1]
                e -= 1
            }
            array[0] = x
        }
        println("Rotated Array:")
        println(array.toList())

        val arrayList = array.toCollection(ArrayList())
        arrayList.add(100)
        arrayList.add(1000)
        arrayList.remove(1000)
        Collections.replaceAll(arrayList, 1000, 12)
        arrayList.sort()
        println("Sorted ArrayList:")
        println(arrayList)
    } catch (e: NumberFormatException) {
        println("Some error occured")
        println("Somewhere u passed bad integer try again")
    } catch (e: Exception) {
        println("Some another error accurred")
    }
}
