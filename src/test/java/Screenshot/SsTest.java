package Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;

public class SsTest {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.zomato.com/");
    }

    @Test(invocationCount = 5)
    public void test1() throws Exception {
        takeScreenshot("ZomatoHomePage");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    public void takeScreenshot(String fileName) throws Exception{
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:/Users/Sharmad Gondkar/IdeaProjects/Automation-Testing/src/test/java/Screenshot/"+fileName+".jpg"));
    }
}
