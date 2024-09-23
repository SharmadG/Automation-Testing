package ExpliOnCanva;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ExpliWait {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
            driver.get("https://www.canva.com/en_in/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            js.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(5000);
            WebElement hubSpot = driver.findElement(By.xpath("//div[@class='LkC0ZQ LJ0Bgw']//descendant::ul[@class='yiU4lw' and @aria-hidden='true']//descendant::li/img[@alt='HubSpot']"));
            js.executeScript("window.scrollBy(0,3700)", "");
    }
    /*public static void clickOn(WebDriver driver, WebElement element, Duration timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }*/
}