package RobotClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
public class DemoClass {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.edureka.co");
        driver.manage().window().maximize();
        Robot robot = new Robot();
        driver.findElement(By.linkText("Courses")).click();
        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_DOWN);
        Thread.sleep(4000);
        robot.keyRelease(KeyEvent.VK_DOWN);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        System.out.println("a");
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        System.out.println("b");
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(4000);
        System.out.println("c");
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.mouseMove(30,100);
        System.out.println("d");
        driver.quit();
    }
}