package AutomatingWebDriverUni;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RightClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        try {
            Actions action = new Actions(driver);
            WebElement rightClickBtn = driver.findElement(By.cssSelector(".context-menu-one"));
            action.contextClick(rightClickBtn).build().perform();
            driver.findElement(By.xpath("//li/span[contains(text(),'Copy')]")).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();
            action.contextClick(rightClickBtn).build().perform();
            driver.findElement(By.xpath("//li/span[contains(text(),'Paste')]")).click();
            alert.accept();
            action.contextClick(rightClickBtn).build().perform();
            driver.findElement(By.xpath("//li/span[contains(text(),'Quit')]")).click();
            alert.accept();
        }
        catch (NoSuchElementException nsee){
            System.out.println("Element not found!"+nsee.getMessage());
        }
        /*finally {
            driver.quit();
        }*/
    }
}
