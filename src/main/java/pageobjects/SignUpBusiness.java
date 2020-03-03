package pageobjects;

import helpers.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.security.Key;

public class SignUpBusiness extends Base {

    private String username;
    private String pwd;
    private static Logger log=Logger.getLogger(SignUpBusiness.class);

    public SignUpBusiness(WebDriver driver,String username,String pwd) {
        this.driver=driver;
        this.username=username;
        this.pwd=pwd;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailTextBox;

    @FindBy(xpath = "//input[@type='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    public void signUpWithNewUser(){
        log.info("Signing up business..");
        if (isDisplayed(emailTextBox)){
            emailTextBox.sendKeys(this.username);
            if (isDisplayed(password)){
                password.sendKeys(this.pwd);
                password.sendKeys(Keys.ENTER);
            }
        }
    }
}
