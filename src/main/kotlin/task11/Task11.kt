package task11

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.Assert
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test


class Task11 {
    // One problem: check line 63
    private val username: String = "ostap_pelo_${Math.random()}"
    private val password: String = "Root24331*"

    private var driver: ChromeDriver = ChromeDriver(
        ChromeOptions()
            .addArguments("start-maximized")
            .addArguments("disable-infobars")
            .addArguments("--disable-extensions")
    )

    @BeforeSuite
    fun initializeWebDriver(){
        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver(        ChromeOptions()
            .addArguments("start-maximized")
            .addArguments("disable-infobars")
            .addArguments("--disable-extensions"))
    }

    @Test(priority = 1)
    fun testRegisterScenario() {
        driver["https://demoqa.com/register"]
        val firstNameInput = getElementByXPath("//*[@id=\"firstname\"]")
        val lastNameInput = getElementByXPath("//*[@id=\"lastname\"]")
        val userNameInput = getElementByXPath("//*[@id=\"userName\"]")
        val passwordInput = getElementByXPath("//*[@id=\"password\"]")

        firstNameInput.sendKeys("Ostap")
        lastNameInput.sendKeys("Pelo")
        userNameInput.sendKeys(username)
        passwordInput.sendKeys(password)

        WebDriverWait( // recaptcha pass; You should do it manual because I did not find way to skip it
            driver,
            10
        ).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name,'a-')]")))
        WebDriverWait( // recaptcha pass
            driver,
            20
        ).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]"))).click()

        WebDriverWait( // register click; IDK why but it takes around minute for WebDriver to see visible button
            driver,
            100
        ).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"register\"]"))).click()
    }

    @Test(priority = 2)
    fun testLoginScenario() {
        driver["https://demoqa.com/login"]
        val userNameInputLogin = getElementByXPath("//*[@id=\"userName\"]")
        val passwordInputLogin = getElementByXPath("//*[@id=\"password\"]")
        userNameInputLogin.sendKeys(username)
        passwordInputLogin.sendKeys(password)
        WebDriverWait( // login click
            driver,
            10
        ).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"login\"]"))).click()
        Thread.sleep(1000)
        val logOut = driver.findElement(By.xpath("//*[@id=\"submit\"]"))
        Assert.assertTrue(logOut.isDisplayed) // logout button exists
        Assert.assertEquals(driver.currentUrl, "https://demoqa.com/profile") // we are on profile page

        driver.close()
    }


    private fun getElementByXPath(xpath: String): WebElement {
        return driver.findElement(By.xpath(xpath)) ?: throw Error()
    }
}