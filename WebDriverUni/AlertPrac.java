package WebDriverUni;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class AlertPrac {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[@id='button1']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        System.out.println("JavaScript Alert Accepted");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@id='button2']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Close']")));
        closeButton.click();
        System.out.println("Modal Popup dismissed");
        Thread.sleep(3000);
        driver.quit();
    }
}
