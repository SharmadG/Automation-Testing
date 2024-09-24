package AutomatingWebDriverUni;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class ActionPrac {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Actions/index.html#");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        action.moveToElement(ele).perform();
        driver.findElement(By.linkText("Link 1")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000);
        driver.quit();
        /*Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        action.moveToElement(ele).perform();
        driver.findElement(By.linkText("Link 1")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(3000);
        driver.quit();*/
    }
}
