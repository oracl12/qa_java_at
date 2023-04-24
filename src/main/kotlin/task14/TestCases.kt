package task14

import org.testng.annotations.Test

class TestCases {
    @Test(priority = 0, description="Always true")
    fun testWithoutException() {
        assert(true)
    }
    @Test(priority = 1, description="Always error")
    fun testWithException() {
        throw Exception("SOME GREAT TEXT")
    }
}