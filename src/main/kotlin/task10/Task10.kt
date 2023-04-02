package task10

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

// My variant: https://demoqa.com/login
// 1 - h2 element
// 2 - label
// 3 - input
// 4 - button
// 5 - section

fun main(){
    WebDriverManager.chromedriver().setup()
    val driver = ChromeDriver()
    driver["https://demoqa.com/login"]
    driver.manage().window().maximize()

    val h2 = driver.findElement(By.xpath("//*[@id=\"userForm\"]/div[1]/h2"))
    println(h2.text)

    val label = driver.findElement(By.xpath("//*[@id=\"userName-label\"]"))
    println(label.getAttribute("class"))

    val input = driver.findElement(By.xpath("//*[@id=\"userName\"]"))
    input.sendKeys("Some beautiful value");
    println(input.getAttribute("value"))

    val wait = WebDriverWait(driver, 30, 5000)
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]")))
    driver.findElement(By.xpath("//*[@id=\"login\"]")).click()
    // password input check cause before we already filled up username, so when login only password is empty
    val inputAfterButtonPressed = driver.findElement(By.xpath("//*[@id=\"password\"]"))
    println(inputAfterButtonPressed.getAttribute("class"))
    println(
        "Input has invalid style?: ${inputAfterButtonPressed.getAttribute("class").contains("is-invalid")}"
    )

    val section = driver.findElement(By.xpath("//*[@id=\"RightSide_Advertisement\"]"))
    println(section.isDisplayed)

    driver.quit()
}