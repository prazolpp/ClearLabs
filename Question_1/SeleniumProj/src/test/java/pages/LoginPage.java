package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class LoginPage{

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how= How.ID, using="gss-signin-email")
    public WebElement txtEmail;

    @FindBy(how= How.ID, using="gss-signin-password")
    public WebElement txtPassword;

    @FindBy(how= How.ID, using="gss-signin-submit")
    public WebElement btnLogin;

    @FindBy(how=How.ID, using="userGreetingName")
    public WebElement txtName;

    public void Login(String email, String password){
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
    }

    public void ClickLogin(){
        btnLogin.click();
    }

    public void CheckAccountLoggedIn(){
        Assert.assertEquals("Prajwal", txtName.getText());
    }
}