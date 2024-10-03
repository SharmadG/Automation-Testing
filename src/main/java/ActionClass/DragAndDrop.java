package ActionClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
        WebElement source = driver.findElement(By.id("box1"));
        WebElement target = driver.findElement(By.id("box103"));
        Actions act = new Actions(driver);
        //act.clickAndHold(source).moveToElement(target).release().build().perform();
        act.dragAndDrop(source, target).build().perform();  //helps you in performing all of the above actions without using multiple methods
    }
}
