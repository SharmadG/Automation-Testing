package AutomatingWebDriverUni;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectedAndDisabled {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement drop = driver.findElement(By.id("fruit-selects"));
        Select select = new Select(drop);
        try {
            driver.findElement(By.xpath("//div[@class='col-sm-4 col-lg-4 col-md-4']//form//input[@value='lettuce']")).click();
            driver.findElement(By.xpath("//div[@class='col-sm-4 col-lg-4 col-md-4']//form//input[@value='pumpkin']")).click();
            select.selectByValue("pear");
            System.out.println("Pear selected!");
            Thread.sleep(3000);
            System.out.println("Script executed successfully!");
        }
        catch(UnsupportedOperationException uoe){
            System.out.println("Element you are trying to select is disabled! "+uoe.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}
