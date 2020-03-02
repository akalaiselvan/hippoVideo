import helpers.Base;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.*;

public class Main extends Base {

    public Main(){
    }
    public Main(WebDriver driver) {
        super(driver);
    }

    @Test(priority = 0)
    public void getLink(){
        driver.get("https://www.hippovideo.io");
    }
//
//    @Test(priority = 1)
//    public void signUp(){
//        SignUpBusiness signUpBusiness=new SignUpBusiness(driver,"akselvan44@gmail.com","ksjrksjrks");
//        signUpBusiness.signUpWithNewUser();
//    }
//
//    @Test(priority = 2)
//    public void fillBusinessDetails(){
//        EnterBusinessDetails businessDetails=new EnterBusinessDetails(driver,"business","artist"
//                                              ,"bubble","9787086356");
//        businessDetails.getPlan();
//        businessDetails.fillBusinessDetails();
//    }

    @Test(priority = 1)
    public void clidk(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.setUsernameAndPassword("akselvan44@gmail.com","ksjrksjrks");
    }

    @Test(priority = 2)
    public void startVideo() throws InterruptedException {
        RecordVideo recordVideo=new RecordVideo(driver);
        recordVideo.startCreatingVideo();
        Thread.sleep(10000);
        recordVideo.startRecord();
        recordVideo.stopRecording(2);
    }

    @Test(priority = 3)
    public void personalizeVideo(){
        PersonalizeVideo personalizeVideo=new PersonalizeVideo(driver);
        personalizeVideo.personalizeVideo();
    }

    @Test(priority = 4)
    public void publishVideo(){
        PublishVideo publishVideo=new PublishVideo(driver);
        publishVideo.startVideoCampaign();
    }


}
