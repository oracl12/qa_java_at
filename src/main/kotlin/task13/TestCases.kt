package task13

import org.testng.annotations.Test

//@Listeners(CustomTestListener::class.java)
class TestCases {
    @Test
    fun testWithoutException() {
        // pass
    }
    @Test
    fun testWithException() {
        throw Exception("SOME GREAT TEXT")
    }
}