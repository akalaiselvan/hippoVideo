package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public static WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public Base() {

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeSuite
    public WebDriver initiateDriver(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("permissions.default.microphone", 1);
        profile.setPreference("permissions.default.camera", 1);
        profile.setPreference("media. getusermedia. screensharing. allowed_domains",true);
        DesiredCapabilities capabilities= DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,System.getProperty("user.dir")+"\\geckodriver.exe");
        driver=new FirefoxDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait=new WebDriverWait(this.driver,90);
        return driver;
    }

    public boolean isDisplayed(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element.isDisplayed();
    }

    public void clickElement(WebElement element){
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
    }
}
