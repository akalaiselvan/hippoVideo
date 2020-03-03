package pageobjects;

import helpers.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class PublishVideo extends Base {

    private static Logger log=Logger.getLogger(PublishVideo.class);

    public PublishVideo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "videoPublishTab-heading")
    WebElement publishTab;

    @FindBy(xpath = "//input[@placeholder='Enter email id']")
    WebElement emailTextBox;

    @FindBy(id = "emailTo")
    WebElement mailTo;

    @FindBy(id = "emailSubject")
    WebElement subject;

    @FindBy(id = "emailSendBtn")
    WebElement sendMail;

    @FindBy(id = "mailSuccess")
    WebElement mailSucessTag;

    @FindBy(id = "videoCampaignsTab-heading")
    WebElement videoCampaignTab;

    @FindBy(id = "videoCampaign")
    WebElement videoCampaign;

    @FindBy(id = "grantAccessBtn")
    WebElement configureMail;

    @FindBy(id = "configureGmailSettingsBtn")
    WebElement gmailConfigure;

    @FindBy(xpath = "//input[@type='email']")
    //@FindBy(id = "identifierId")
            WebElement gmailTxtBox;

    //@FindBy(xpath = "//input[@type='email']")
    @FindBy(id = "identifierNext")
    WebElement gmailNext;

    @FindBy(xpath = "//input[@type='password']")
    //@FindBy(id = "identifierNext")
            WebElement gmailPassword;

    @FindBy(id = "passwordNext")
    WebElement gmailPwdNext;

    @FindBy(id="submit_approve_access")
    WebElement gmailAllowAcess;

    @FindBy(id = "addContacts")
    WebElement addContacts;

    @FindBy(xpath = "//span[@class='add-contacts-btn']")
    WebElement addContactToMail;

    @FindBy(xpath = "//div[@class='large-3 columns direct-contacts-email']/input[1]")
    WebElement mailId;

    @FindBy(xpath = "//div[@class='large-9 columns hp-custom-scromm ac-parent direct-contacts-mfields']/div[1]/table/tbody/tr/td/input")
    WebElement firstName;

    @FindBy(id = "emailSubject")
    WebElement mailSubject;

    @FindBy(id = "sendEmailBtn")
    WebElement mailSend;


    /*public void publishVideo() {
        clickElement(publishTab);
        if (isDisplayed(emailTextBox)) {
            emailTextBox.sendKeys("klisvn@gmail.com");
            if (isDisplayed(subject)) {
                subject.sendKeys("Summa purpose");
                sendMail.click();
            }
        }
        if (isDisplayed(mailSucessTag)) {
            System.out.println("Mail Sent Sucessfully");
        }
    }
*/

    public void startVideoCampaign(String mail,String pwd) {
        log.info("Campaigning video..!");
        clickElement(videoCampaignTab);
        clickElement(videoCampaign);
        clickElement(configureMail);
        configureGmail(mail,pwd);
    }


    public void addContactAndSendMail(String mail, String fName, String mailSub) {
        log.info("Adding contact : "+mail);
        clickElement(addContactToMail);
        if (isDisplayed(mailId)) {
            mailId.sendKeys(mail);
            if (isDisplayed(firstName)) {
                firstName.sendKeys(fName);
                clickElement(addContacts);
            }
        }
        if (isDisplayed(mailSubject)) {
            mailSubject.sendKeys(mailSub);
            clickElement(mailSend);
        }
    }


    private void configureGmail(String mail,String pwd) {
        log.info("Configuring gmail");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        clickElement(gmailConfigure);
        ArrayList<String> mailtabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(mailtabs.get(2));
        if (isDisplayed(gmailTxtBox)) {
            gmailTxtBox.sendKeys(mail);
            gmailTxtBox.sendKeys(Keys.ENTER);
            //clickElement(gmailNext);
            if (isDisplayed(gmailPassword)) {
                gmailPassword.sendKeys(pwd);
                gmailPassword.sendKeys(Keys.ENTER);
                //clickElement(gmailPwdNext);
                clickElement(gmailAllowAcess);
            }
        }
        ArrayList<String> back = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(back.get(0));
    }
}
