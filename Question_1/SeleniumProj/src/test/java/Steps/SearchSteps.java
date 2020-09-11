package Steps;

        import io.cucumber.datatable.DataTable;
        import io.cucumber.java.en.And;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import pages.LoginPage;
        import pages.SearchPage;

        import java.util.Collections;
        import java.util.concurrent.TimeUnit;

        import java.util.List;

public class SearchSteps {
    WebDriver driver;

    @Given("I navigate to the search page")
    public void iNavigateToTheSearchPage() {
        System.setProperty("webdriver.chrome.driver","/Users/prajwalpyakurel/desktop/java_projects/selenium/chromedriver");
        driver =  new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.orbitz.com/?pwaLob=wizard-hotel-pwa");
    }

    @When("I enter the following for search details")
    public void iEnterTheFollowingForSearchDetails(DataTable table ) {
        SearchPage page = new SearchPage(driver);
        List<List<String>> data = table.cells();
        String location = data.get(1).get(0);
        page.EnterPlace(location);
    }


    @And("I choose the first option and click the search button")
    public void iChooseTheFirstOptionAndClickTheSearchButton() {
        SearchPage page = new SearchPage(driver);
        page.SearchPlace();

    }

    @And("I should be able to see a Sort and Filter Button, and a Map button")
    public void iShouldBeAbleToSeeASortAndFilterButtonAndAMapButton() {
        SearchPage page = new SearchPage(driver);
        page.checkSortAndMapButtons();
    }
}