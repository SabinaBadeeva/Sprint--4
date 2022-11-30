import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoSamocat {
    private WebDriver driver;
    public LogoSamocat (WebDriver driver) {

        this.driver = driver;
    }

    private By headerLogoScooter = By.cssSelector("a.Header_LogoScooter__3lsAR > img");

    public void isDisplayedClickLogo() {
        WebElement logoPresent = driver.findElement(headerLogoScooter);
        if (driver.findElement(By.cssSelector("a.Header_LogoScooter__3lsAR > img")).isDisplayed()) {
            driver.findElement(By.cssSelector("a.Header_LogoScooter__3lsAR > img")).click();}}
    }


