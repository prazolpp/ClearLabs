package Steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import java.util.List;

public class LoginSteps {
    WebDriver driver;


    @Given("I navigate to the login page")
    public void iNavigateToTheLoginPage() throws Throwable{

        System.setProperty("webdriver.chrome.driver","/Users/prajwalpyakurel/desktop/java_projects/selenium/chromedriver");
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com");
        driver.findElement(By.id("header-account-menu")).click();
        driver.findElement(By.id("header-account-signin-button")).click();
        System.out.println("I should see userform page");
    }

    @When("I enter the following for login")
    public void iEnterTheFollowingForLogin(DataTable table) {
        LoginPage page = new LoginPage(driver);
        List<List<String>> data = table.cells();
        String email = data.get(1).get(0);
        String password = data.get(1).get(1);
        page.Login(email, password);

    }

    @And("I click the login button")
    public void iClickTheLoginButton() throws Throwable{
        LoginPage page = new LoginPage(driver);
        page.ClickLogin();
    }

    @Then("I should see the homepage with me being logged in")
    public void iShouldSeeTheHomepageWithMeBeingLoggedIn() throws Throwable {
        LoginPage page = new LoginPage(driver);
        page.CheckAccountLoggedIn();
    }

}
