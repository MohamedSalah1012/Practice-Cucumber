package StepDefinations;


import Pages.LoginPage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ValidLoginTest {
    private WebDriver driver;
//    private LoginPage loginPage;






        @Test()
        @Given("Given the user is on the login page")
        public void theUserIsOnTheLoginPage() {
            driver.get("https://parabank.parasoft.com/parabank/index.htm");
        }

        @Test(dependsOnMethods = "theUserIsOnTheLoginPage")
        @When("The user enters valid credentials")
            public void theUserEntersInvalidCredentials() {
                      new LoginPage(driver)
                              .enterValidUsername("mnmn")
                               .enterValidPassword("123");
            }


        @Test(dependsOnMethods = "theUserEntersInvalidCredentials")
        @Then("The he user should be redirected to the dashboard")
            public void theUserShouldNotRedirectedToTheDashboard() {
                    new LoginPage(driver)
                             .clickTheLoginButton()
                             .checkAnErrorMessageIsDisplayedAfterInvalidLogin();
            }


        @BeforeClass
        public void setDriver(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @AfterClass
        public void tearDown(){
            if (driver != null){
                driver.quit();
            }
        }


    }


