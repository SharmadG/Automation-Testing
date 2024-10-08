package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
public class GoogleTitleTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.google.com");
    }
    /*@Test()
    public void googleTitleTest(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title, "Google", "Title not matched");
    }*/
    @Test ()
    public void googleLogoTest(){
        boolean b = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
        Assert.assertTrue(b); // B should be true here
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}