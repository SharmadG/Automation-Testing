package Wait;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
public class ExplicitWait {
    public static void main(String[] args) {

        //Explicit waits or timeouts are mostly used for Ajax(Dynamic Components) components
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//div[@class='_6ltg']//a[@data-testid='open-registration-form-button']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement firstName = driver.findElement(By.name("firstname"));
        WebElement lastName = driver.findElement(By.name("lastname"));
        WebElement mobileNum = driver.findElement(By.name("reg_email__"));
        WebElement password = driver.findElement(By.name("reg_passwd__"));

        sendKeys(driver, firstName, Duration.ofSeconds(10), "Sharmad");
        sendKeys(driver, lastName, Duration.ofSeconds(10), "Gondkar");
        sendKeys(driver, mobileNum, Duration.ofSeconds(10), "9876543210");
        sendKeys(driver, password, Duration.ofSeconds(10), "abc@123");
    }
    public static void sendKeys(WebDriver driver, WebElement element, Duration timeout, String value) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(value);
    }
    public static void clickOn(WebDriver driver, WebElement element, Duration timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }
}

