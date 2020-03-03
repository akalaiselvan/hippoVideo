package pageobjects;

import helpers.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalizeVideo extends Base {

    private int notifyCount;
    private static Logger log=Logger.getLogger(PersonalizeVideo.class);

    public PersonalizeVideo(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "personlizationTab-heading")
    WebElement personalizeTab;

    @FindBy(id="videoPersonalization")
    WebElement videoPersonalize;

    @FindBy(id="personalizeButton")
    WebElement personalizeButton;

    @FindBy(id="seTextEditable")
    WebElement editableTextArea;

    @FindBy(id="saveSimpleEdit")
    WebElement saveVideoEdit;

    @FindBy(id = "vdoProcessOkBtn")
    WebElement notifyOkBtn;

    @FindBy(id = "at-view-36")
    WebElement drpDwn;

    public void personalizeVideo(){
        log.info("Video Personalization started");
        clickElement(personalizeTab);
        clickElement(videoPersonalize);
        enterPersonaliZation();
        if (isDisplayed(editableTextArea)){
            addTextInVideo("Hi","first");
            Actions actions=new Actions(driver);
            actions.dragAndDropBy(editableTextArea,250,50).build().perform();
        }
        clickElement(saveVideoEdit);
    }
    public boolean isNotifyWindowFound(){
        return isDisplayed(notifyOkBtn);
    }

    public void enterPersonaliZation(){
        clickElement(personalizeButton);
        if (isNotifyWindowFound()){
            WebDriverWait waitForPersonlizeButton=new WebDriverWait(driver,180);
            waitForPersonlizeButton.until(ExpectedConditions.elementToBeClickable(editableTextArea));
        }
    }

    public void addTextInVideo(String text,String tag){
        log.info("Selected tag in test : "+tag);
        editableTextArea.sendKeys(text+" $"+tag);
        if (isDisplayed(drpDwn))
        editableTextArea.sendKeys(Keys.ENTER);
    }
}
