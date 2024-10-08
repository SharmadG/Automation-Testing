package PopUps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
public class PermissionPopUps {
    public static void main(String[] args) throws Exception {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications",2);
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://web-push-book.gauntface.com/demos/notification-examples/");
        driver.manage().window().maximize();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/main/p[3]/input")).click();
        driver.quit();
    }
}