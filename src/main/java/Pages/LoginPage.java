package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


                                    ///// Locators /////

    private By userName = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");

    private By loginBtn = By.xpath("//input[@value='Log In']");

    private By errorParargraph = By.xpath("//p[@class='error']");







    public LoginPage enterValidUsername(String username){
        driver.findElement(userName).sendKeys(username);
        return this;
    }


    public LoginPage enterValidPassword(String pass){
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    public LoginPage clickTheLoginButton(){
        driver.findElement(loginBtn).click();
        return this;
    }



    public void checkAnErrorMessageIsDisplayedAfterInvalidLogin() {
        String actualErrorMessage = driver.findElement(errorParargraph).getText();
        Assert.assertTrue(actualErrorMessage.contains("The username and password could not be verified"),
                "The message is not matching the expected");
    }

}
