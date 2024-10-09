package Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
public class ScreenshotHandle {
    static WebDriver driver;
    public static void main(String[] args) throws Exception {
        driver = new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        takeScreenshot("Facebook_LoginPage");
        driver.quit();
    }
    public static void takeScreenshot(String fileName) throws Exception{
        //1. Take screenshot and store it as a file format:
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //2. Copy the screenshot to desired location using copyfile method:
        FileUtils.copyFile(file, new File("C:/Users/Sharmad Gondkar/IdeaProjects/Automation-Testing/src/test/java/Screenshot/"+fileName+".jpg"));
    }
}