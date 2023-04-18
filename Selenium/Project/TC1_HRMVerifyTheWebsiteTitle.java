package stepDefinations;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC1_HRMVerifyTheWebsiteTitle  extends BaseClass{

    @Given("User open the browser and navigate to the URL")
    public void openWebsite(){
        //open TS home page
        driver.get("http://alchemy.hguy.co/orangehrm");
        //assertion


    }
    @When("get the title of the website and Validate it matches “OrangeHRM” exactly")
    public void gettitle(){
       String title= driver.getTitle();
        Assert.assertEquals("OrangeHRM",driver.getTitle());
    }

    @Then("If it matches, close the browser")
    public void closeHRMBrowser(){
        if(driver.getTitle().equals("OrangeHRM")){
            driver.quit();
        }


    }
}
