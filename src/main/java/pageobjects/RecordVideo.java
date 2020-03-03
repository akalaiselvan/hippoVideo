package pageobjects;

import helpers.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RecordVideo extends Base {

    private static Logger log=Logger.getLogger(RecordVideo.class);

    public RecordVideo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='importIcon import']")
    WebElement addContent;

    @FindBy(xpath = "//section[@data-name='Create video _+']")
    WebElement createVideo;

    @FindBy(css = "#startRecording")
    WebElement startVideo;

    @FindBy(id = "chrome-modalTitle")
    WebElement pluginValidation;

    @FindBy(id = "chrome-modalYesBtn")
    WebElement installPlugin;

    @FindBy(xpath = "//div[@class='g-c-R  webstore-test-button-label']")
    WebElement chromeAddExtension;

    @FindBy(id = "screenRecord")
    WebElement screenShare;

    @FindBy(id = "stopRecording")
    WebElement stopRecoreding;

    public void startCreatingVideo() {
        log.info("Creating video..");
        clickElement(addContent);
        clickElement(createVideo);
    }

    public void startRecord() {
        log.info("Recording Started");
        clickElement(screenShare);
        clickElement(startVideo);
    }

    public void stopRecording(int duration) {
        log.info("Estimated video duration "+duration+" seconds");
        wait.until(ExpectedConditions.elementToBeClickable(stopRecoreding));
        if (isDisplayed(stopRecoreding)) {
            try {
                Thread.sleep(duration * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clickElement(stopRecoreding);
        }
    }
}
