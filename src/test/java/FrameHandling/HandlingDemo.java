package FrameHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class HandlingDemo {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.freecrm.com/");
        driver.findElement(By.name("username")).sendKeys("naveenk");
        driver.findElement(By.name("password")).sendKeys("test@123");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
        driver.switchTo().frame("mainpanel");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
    }
}
