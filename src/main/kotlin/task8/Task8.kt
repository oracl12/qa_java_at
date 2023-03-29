package task8

import org.testng.AssertJUnit.*
import org.testng.annotations.DataProvider
import org.testng.annotations.Parameters
import org.testng.annotations.Test
import task2.Task2


class Task8 {
    @DataProvider(name = "test1")
    @Test
    fun andFuncTest() {
        assertTrue(Task2(1, 0).andFunc() == 0)
    }

    @Parameters("a", "b")
    @DataProvider(name = "test1")
    @Test
    fun andFuncWithParamsTest(a: String, b: String) {
        assertTrue(Task2(a.toInt(), b.toInt()).andFunc() == 1)
    }

    @DataProvider(name = "test1")
    @Test
    fun orFuncTest() {
        assert(Task2(1, 0).orFunc() == 1)
    }

    @DataProvider(name = "test1")
    @Test
    fun invFuncTest() {
        assert(Task2(0, 0).invFunc(13) == -14)
    }
}
