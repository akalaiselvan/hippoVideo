package pageobjects;

import helpers.Base;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterBusinessDetails extends Base {

    private String plan;
    private String name;
    private String cname;
    private String phno;

    private static Logger log=Logger.getLogger(EnterBusinessDetails.class);

    public EnterBusinessDetails(WebDriver driver,String plan,String name,String cname,String phno) {
        this.driver=driver;
        this.plan=plan;
        this.name=name;
        this.cname=cname;
        this.phno=phno;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "Individual-1")
    WebElement personal;

    @FindBy(id = "Education-2")
    WebElement education;

    @FindBy(id = "Business-4")
    WebElement business;

    @FindBy(id = "Marketing")
    WebElement marketing;

    @FindBy(id = "Business-next-btn")
    WebElement nxtButton;

    @FindBy(id = "firstNameTxt")
    WebElement firstName;

    @FindBy(id="companyNameTxt")
    WebElement companyName;

    @FindBy(id = "phoneTxt")
    WebElement phNumber;

    @FindBy(id = "saveCompanyName")
    WebElement companyNext;


    public void getPlan(){
        clickElement(selectPlan(this.plan));
        clickElement(marketing);
        clickElement(nxtButton);
    }


    public void fillBusinessDetails(){
        log.info("Configuring Business details");
        if (isDisplayed(firstName)){
            firstName.sendKeys(this.name);
            if (isDisplayed(companyName)){
                companyName.sendKeys(this.cname);{
                    if (isDisplayed(phNumber)){
                        phNumber.sendKeys(this.phno);
                        clickElement(companyNext);
                    }
                }
            }
        }
        log.info("Business details configured");
    }
    public WebElement selectPlan(String plan) {
        log.info("Selecting plan");
        if (plan.equalsIgnoreCase("personal")) {
            log.info("Selected plan : Personal");
            return personal;
        } else if (plan.equalsIgnoreCase("education")) {
            log.info("Selected plan : Education");
            return education;
        } else if (plan.equalsIgnoreCase("business")) {
            log.info("Selected plan : Business");
            return business;
        }
        return null;
    }

}
