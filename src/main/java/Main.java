import helpers.Base;
import org.openqa.selenium.Alert;
import org.testng.annotations.Parameters;
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

    @Test
    @Parameters({"url"})
    public void getLink(String url){
        driver.get(url);
    }


    @Test
    @Parameters({"mail","password"})
    public void signUp(String mailId,String password){
        SignUpBusiness signUpBusiness=new SignUpBusiness(driver,"akselvan44@gmail.com","1028ksjr");
        signUpBusiness.signUpWithNewUser();
    }

    @Test
    @Parameters({"plan","name","company","phNo"})
    public void fillBusinessDetails(String plan,String name,String company,String phNo){
        EnterBusinessDetails businessDetails=new EnterBusinessDetails(driver,plan,name
                                              ,company,phNo);
        businessDetails.getPlan();
        businessDetails.fillBusinessDetails();
    }

//    @Test(priority = 1)
//    public void clidk(){
//        LoginPage loginPage=new LoginPage(driver);
//        loginPage.clickLoginButton();
//        loginPage.setUsernameAndPassword("akselvan44@gmail.com","ksjrksjrks");
//    }

    @Test
    @Parameters({"videoDuration"})
    public void startVideo(String duration) throws InterruptedException {
        RecordVideo recordVideo=new RecordVideo(driver);
        recordVideo.startCreatingVideo();
        Thread.sleep(3000);
        recordVideo.startRecord();
        recordVideo.stopRecording(Integer.parseInt(duration));
    }

    @Test
    public void personalizeVideo(){
        PersonalizeVideo personalizeVideo=new PersonalizeVideo(driver);
        personalizeVideo.personalizeVideo();
    }

    @Test
    @Parameters({"publishMail","publishFirstName","publishSubject"})
    public void publishVideo(String publishMail,String publishFirstName,String publishSubject){
        PublishVideo publishVideo=new PublishVideo(driver);
        publishVideo.startVideoCampaign();
        publishVideo.addContactAndSendMail(publishMail,publishFirstName,publishSubject);
    }

}
