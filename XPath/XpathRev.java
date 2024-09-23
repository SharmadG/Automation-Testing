package XPath;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
public class XpathRev {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class=\"zlQd20 \"]/img[@src=\"https://rukminim2.flixcart.com/fk-p-flap/1600/270/image/7c6cf1a109b087d2.jpg?q=20\"]")).click();
        driver.findElement(By.xpath("//div[@class='_8z-Twi _4bzjfU gqcSqV']//img[@src='https://rukminim2.flixcart.com/fk-p-flap/100/100/image/ca8f425745024727.jpg?q=50']")).click();
        driver.findElement(By.xpath("//div[@class='cPHDOP col-12-12']//descendant::div[@data-id='WATG6EYSF8UBTFSM']//descendant::div[@class='gqcSqV YGE0gZ']//img[@class='_53J4C-']")).click();
    }

}
