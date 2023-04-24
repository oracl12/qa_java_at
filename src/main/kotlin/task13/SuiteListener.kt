package task13

import org.apache.commons.io.FileUtils
import org.apache.log4j.Logger
import org.hibernate.cfg.Configuration
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.*
import task7.User
import task7.Address
import java.io.File

@Throws(Exception::class)
fun takeSnapShot(webdriver: WebDriver, fileWithPath: String) {
    val scrShot = webdriver as TakesScreenshot
    val srcFile: File = scrShot.getScreenshotAs(OutputType.FILE)
    val destFile = File(fileWithPath)
    FileUtils.moveFile(srcFile, destFile)
}

class CustomTestListener : ITestListener {
    private var logger = Logger.getLogger(ITestListener::class.java)
    private var driver: ChromeDriver = ChromeDriver()

    override fun onTestStart(result: ITestResult) {
        // we got some data
        val configuration = Configuration()
        configuration.configure("hibernate.cfg.xml")
        configuration.addAnnotatedClass(User::class.java)
        configuration.addAnnotatedClass(Address::class.java)

        val sessionFactory = configuration.buildSessionFactory()
        sessionFactory.openSession()

        // getting some user

        // we open browser
        driver["https://demoqa.com/register"]
    }

    override fun onTestFailure(result: ITestResult) {
        logger.info("On Test Failure ${result.testName} ${result.name}")
        takeSnapShot(driver, "E:\\qa_java_at\\src\\main\\kotlin\\task13\\screenshots\\test.png") ;
    }
}

// second part will finish later after clarifying
class CustomSuiteListener : ISuiteListener {
//    override fun onStart(suite: ISuite?) {
//
//    }

//    override fun afterSuite(result: ITestResult) {
//        println("Test Failed" + result.name)
//    }
}