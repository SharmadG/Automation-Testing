package WebDriverUni;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dropdown {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            //Programming language
            WebElement dropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdowm-menu-1")));
            Select selectDD1 = new Select(dropdown1);
            selectDD1.selectByValue("python");
            System.out.println("Python selected from first Dropdown!");
            Thread.sleep(5000);
            //IDE
            WebElement dropdown2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdowm-menu-2")));
            Select selectDD2 = new Select(dropdown2);
            selectDD2.selectByValue("maven");
            System.out.println("Maven selected from second Dropdown!");
            Thread.sleep(5000);
            //WebTech lang
            WebElement dropdown3 = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdowm-menu-3")));
            Select selectDD3 = new Select(dropdown3);
            selectDD3.selectByValue("javascript");
            System.out.println("Javascript selected from third Dropdown!");
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
        } finally {
            System.out.println("Script executed successfully");
            driver.quit();
        }
    }
}
