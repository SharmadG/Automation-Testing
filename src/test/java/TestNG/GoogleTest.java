package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class GoogleTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.google.com");
    }

    @Test (priority = 1, groups = "Title")
    public void googleTitleTest(){
        Assert.assertEquals(driver.getTitle(), "Google", "Title does not match!");
    }

    @Test (priority = 2, groups = "Link Test")
    public void mailLinkTest(){
        Assert.assertTrue(driver.findElement(By.linkText("Gmail")).isDisplayed(), "Gmail link is not displayed!");
    }

    @Test (priority = 3, groups = "Logo")
    public void googleLogoTest(){
        Assert.assertTrue(driver.findElement(By.cssSelector("img[alt='Google']")).isDisplayed(), "Google logo is not displayed!");
    }

    @Test (priority = 4, groups = "Test")
    public void test1(){ System.out.println("Test 1"); }

    @Test (priority = 5, groups = "Test")
    public void test2(){ System.out.println("Test 2"); }

    @Test (priority = 6, groups = "Test")
    public void test3(){ System.out.println("Test 3"); }

    @AfterMethod
    public void tearDown(){
        if (driver != null) driver.quit();
    }
}
