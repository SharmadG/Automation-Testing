package Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
public class FluWait {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//div[@class='_6ltg']//a[@data-testid='open-registration-form-button']")).click();
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='firstname']")));
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sharmad");
        System.out.println("Code execution ended");
        driver.quit();
    }
}
