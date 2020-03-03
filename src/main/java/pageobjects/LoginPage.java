package pageobjects;

import helpers.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base {

    private static Logger log=Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='nav-link log-btn']")
    WebElement loginButton;

    @FindBy(css = "#user_email")
    WebElement username;

    @FindBy(css = "#user_password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement signIn;

    private boolean isLoginButtonFlond(){
        return isDisplayed(loginButton);
    }


    public void clickLoginButton(){
        if (isLoginButtonFlond()){
            loginButton.click();
        }
    }

    public void setUsernameAndPassword(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        signIn.click();
    }
}
