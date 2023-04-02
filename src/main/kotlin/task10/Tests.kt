package task10

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert.assertTrue
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test

class Tests {
    private var driver: ChromeDriver = ChromeDriver()

    @BeforeSuite
    fun initializeWebDriver(){
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
        driver["https://demoqa.com/login"]
    }

    @Test
    fun testH2() {
        val h2 = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h2"))
        assertTrue(h2.isDisplayed)
    }

    @Test
    fun testLabel() {
        val label = driver.findElement(By.xpath("//*[@id=\"userName-label\"]"))
        assertTrue(label.isDisplayed)
    }

    @Test
    fun testInput() {
        val input = driver.findElement(By.xpath("//*[@id=\"userName\"]"))
        assertTrue(input.isDisplayed)
    }

    @Test
    fun testButton() {
        val button = driver.findElement(By.xpath("//*[@id=\"login\"]"))
        assertTrue(button.isDisplayed)
    }

    @Test
    fun testSection() {
        val section = driver.findElement(By.xpath("//*[@id=\"RightSide_Advertisement\"]"))
        assertTrue(section.isDisplayed)
    }
}