package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import static org.testng.Assert.assertTrue;
public class UploadAndDownload {
        @Test
        public static void main(String [] args) {
                WebDriver driver = new ChromeDriver();
                driver.get("https://blueimp.github.io/jQuery-File-Upload/");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
                WebElement uploadEle = driver.findElement(By.xpath("//input[@type='file']"));
                File file = new File("/home/sharmad/Downloads/tree-736885_1280.jpg");
                uploadEle.sendKeys(file.getAbsolutePath());
                driver.findElement(By.xpath("//span[.='Start upload']")).click();
                WebElement deleteButton = driver.findElement(By.cssSelector("button[data-type='DELETE']"));
                boolean displayed = deleteButton.isDisplayed();
                assertTrue(displayed);
        }
}
