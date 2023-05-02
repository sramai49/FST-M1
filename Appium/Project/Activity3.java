package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import static examples.ActionBase.doSwip;

public class Activity3 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium");


    }

    @Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();

        //wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@text='Get Started!']")));

        //Scroll to end by setting the start and end points
        Point start = new Point((int) (dims.width * 0.5), (int) (dims.height * 0.9));
        Point end = new Point((int) (dims.width * 0.5), (int) (dims.height * 0.6));

        doSwip(driver, start, end, 100);

        //locate element and click it
        wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do List')]"))
        ).click();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
        WebElement AddTaskTxtbox=driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));
        WebElement AddTaskBtn=driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));
        AddTaskTxtbox.sendKeys("Add tasks to list");
        AddTaskBtn.click();
        Thread.sleep(2000);
        AddTaskTxtbox.sendKeys("Get number of tasks");
        AddTaskBtn.click();
        Thread.sleep(2000);
        AddTaskTxtbox.sendKeys("Clear the list");
        AddTaskBtn.click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=' Clear List']")).click();
        List<WebElement> tasklist = driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksList']/android.view.View"));
        int TasklistCount = tasklist.size();
        Assert.assertEquals(TasklistCount,0);


    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
