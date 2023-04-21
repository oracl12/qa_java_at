package task12

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

//Spans:
//getText - retrieves the text value of a span
//verifySpanExists - verifies if a span exists on the page
//waitForSpanToBeVisible - waits for a span to be visible on the page


class LoginPage(driver: WebDriver) {
    private var webDriver: WebDriver = driver
    private var span: By = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[6]/span");

    fun getText(): String {
        return webDriver.findElement(span).text
    }

    fun verifySpanExists(): Boolean {
        return webDriver.findElements(span).size != 0
    }

    fun waitForSpanToBeVisible() {
        WebDriverWait(
            webDriver,
            20
        ).until(ExpectedConditions.visibilityOfElementLocated(span))
    }
}