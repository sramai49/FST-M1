package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TC3_LoggingIntoTheSite extends BaseClass {


    @Given("User open the browser")
    public void openWebsite() {
        //open TS home page
        driver.get("http://alchemy.hguy.co/orangehrm");
        //assertion


    }

    @When("^valid \"(.*)\" and \"(.*)\" is entered$")
    public void enterTheCredentials(String username, String password) {
        WebElement UserNameTxtBox = driver.findElement(By.id("txtUsername"));
        if (UserNameTxtBox.isDisplayed()) {
            UserNameTxtBox.sendKeys(username);
        }
        WebElement PasswordTxtBox = driver.findElement(By.id("txtPassword"));
        if (PasswordTxtBox.isDisplayed()) {
            PasswordTxtBox.sendKeys(password);
        }


    }

    @Then("Click on the login button")
    public void clickOnLoginButton() {
        WebElement btnLogin = driver.findElement(By.id("btnLogin"));
        if (btnLogin.isEnabled()) {
            btnLogin.click();
        }
    }

    @Then("verify the home page has been displayed")
    public void VerifyHRMHomePage() {
        WebElement HRMimgLink = driver.findElement(By.xpath("//div[@id='branding']/a/img"));
        if (HRMimgLink.isDisplayed()) {
            System.out.println("User able to login HRM page successfully");
        }
    }

    @Then("close the HRM browser")
    public void closeHRMBrowser() {
        driver.quit();

    }
}
