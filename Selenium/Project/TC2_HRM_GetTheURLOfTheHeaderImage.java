package stepDefinations;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC2_HRM_GetTheURLOfTheHeaderImage extends BaseClass {
    @BeforeAll
    public static void setUp(){
        WebDriverManager.firefoxdriver().setup();;
        driver=new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Given("user is on the HRM website")
    public void openPage(){
        //open TS home page
        driver.get("http://alchemy.hguy.co/orangehrm");
        //assertion
        Assert.assertEquals("OrangeHRM",driver.getTitle());

    }

    @When("print the URL of header image")
    public void getTheURLOFHeaderImg(){
        WebElement HRMHeaderIMG = driver.findElement(By.xpath("//div[@id=\"divLogo\"]/img"));
        String HRMHeaderIMGURL=HRMHeaderIMG.getAttribute("src");
        System.out.println(HRMHeaderIMGURL);
    }


    @Then("close the browser")
    public void closeHRMBrowser(){
        driver.quit();

    }
}
