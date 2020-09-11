package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage{

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.XPATH, using="//button[@data-stid='location-field-destination-dialog-trigger']")
    public WebElement btnPlace;

    @FindBy(how= How.XPATH, using="//input[@aplaceholder='Where are you going?']")
    public WebElement inputPlace;

    @FindBy(how= How.XPATH, using="//button[@data-stid='location-field-destination-result-item-button']")
    public WebElement btnFirstResult;

    @FindBy(how= How.XPATH, using="//button[@data-testid='submit-button']")
    public WebElement btnSubmit;

    @FindBy(how= How.XPATH, using="//button[@data-testid='open-hotel-filters']")
    public WebElement sortButton;

    @FindBy(how= How.XPATH, using="//button[@data-testid='open-dynamic-map']")
    public WebElement openMapButton;


    public void EnterPlace(String place){
        btnPlace.click();
        inputPlace.sendKeys(place);
    }
    public void SearchPlace(){
        btnFirstResult.click();
        btnSubmit.click();
    }
    public void checkSortAndMapButtons(){
        Assert.assertEquals("Sort & Filter", sortButton.getText());
        Assert.assertEquals("View in a map", openMapButton.getText());
    }

}