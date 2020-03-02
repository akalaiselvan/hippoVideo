package pageobjects;

import helpers.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class PublishVideo extends Base {
    public PublishVideo(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "videoPublishTab-heading")
    WebElement publishTab;

    @FindBy(xpath = "//input[@placeholder='Enter email id']")
    WebElement emailTextBox;

    @FindBy(id="emailTo")
    WebElement mailTo;

    @FindBy(id="emailSubject")
    WebElement subject;

    @FindBy(id = "emailSendBtn")
    WebElement sendMail;

    @FindBy(id = "mailSuccess")
    WebElement mailSucessTag;

    @FindBy(id = "videoCampaignsTab-heading")
    WebElement videoCampaignTab;

    @FindBy(id="videoCampaign")
    WebElement videoCampaign;

    @FindBy(id="grantAccessBtn")
    WebElement configureMail;

    @FindBy(id = "configureGmailSettingsBtn")
    WebElement gmailConfigure;

    @FindBy(id = "identifierId")
    WebElement gmailTxtBox;

    @FindBy(id = "identifierNext")
    WebElement gmailNext;

    @FindBy(id = "password")
    WebElement gmailPassword;

    @FindBy(id="passwordNext")
    WebElement gmailPwdNext;

    public void publishVideo(){
        clickElement(publishTab);
        if (isDisplayed(emailTextBox)){
            emailTextBox.sendKeys("klisvn@gmail.com");
            if (isDisplayed(subject)){
                subject.sendKeys("Summa purpose");
                sendMail.click();
            }
        }
        if (isDisplayed(mailSucessTag)){
            System.out.println("Mail Sent Sucessfully");
        }
    }


    public void startVideoCampaign(){
        clickElement(videoCampaignTab);
        clickElement(videoCampaign);
        clickElement(configureMail);
        configureGmail();
    }

    private void configureGmail(){
        ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
            clickElement(gmailConfigure);
            ArrayList<String> mailtabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(mailtabs.get(2));
            if (isDisplayed(gmailTxtBox)){
                gmailTxtBox.sendKeys("klisvn@gmail.com");
                clickElement(gmailNext);
                if (isDisplayed(gmailPassword)){
                    gmailPassword.sendKeys("ksjrgm1028");
                    clickElement(gmailPwdNext);
                }
            }


    }
}
