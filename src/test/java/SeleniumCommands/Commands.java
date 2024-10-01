package SeleniumCommands;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Commands {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        //Open URL
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
        //get current url as text
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/login");
        //get title
        String title = driver.getCurrentUrl();
        System.out.println(title);
        //get window handle
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("#content > div > a")).click();
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        //get window handles
        Set<String> handles = driver.getWindowHandles();
        List<String> list = new ArrayList<>(handles);
        driver.switchTo().window(list.get(1));
        String title2 = driver.getTitle();
        System.out.println(title2);
        driver.switchTo().window(list.get(0));
        //dropdown handling
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select selectByValue = new Select(driver.findElement(By.id("dropdown")));
        selectByValue.selectByVisibleText("Option 1");
        //Select a element
        //Input text in input box
        //Submit the form
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        System.out.println(driver.getCurrentUrl());
        //switch to Iframe
        //clear input field
        //click an element
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        int width = driver.findElement(By.id("tinymce")).getSize().width;
        System.out.println(width);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Hello Sharmad");
        //take screenshot
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./a.png");
        FileUtils.copyFile(SrcFile, DestFile);
        //expected condition
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tinymce")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));
        //quit driver
        driver.quit();
    }
}
