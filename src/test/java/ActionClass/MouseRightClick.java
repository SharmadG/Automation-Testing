package ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class MouseRightClick {
    WebDriver driver;
    @BeforeMethod
    public void createDriver(){
        driver = new ChromeDriver();
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
        driver.manage().window().maximize();
    }
    @Test
    public void test1(){
        Actions act = new Actions(driver);
        WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));
        act.contextClick(button).build().perform(); //Right-click on the element
        driver.findElement(By.xpath("/html/body/ul/li[3]")).click(); //perform click on the COPY option from the drop-down
        System.out.println(driver.switchTo().alert().getText()); //print the text from the alert
        driver.switchTo().alert().accept(); //click ACCEPT or CONTINUE on the alert box to close the Alert
        System.out.println("Script executed Successfully!");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}