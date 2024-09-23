package Alerts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class AlertDemo {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
        //simpleAlert
        driver.findElement(By.id("alertBox")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(2000);
        simpleAlert.accept();
        Thread.sleep(2000);
        */
        /*
        //confirmationAlert
        driver.findElement(By.id("confirmBox")).click();
        Alert confirmationAlert = driver.switchTo().alert();
        System.out.println(confirmationAlert.getText());
        Thread.sleep(2000);
        confirmationAlert.accept();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("output")).getText());
        */
        js.executeScript("window.scrollBy(0,800)","");
        driver.findElement(By.id("promptBox")).click();
        Alert promptAlert = driver.switchTo().alert();
        System.out.println(promptAlert.getText());
        Thread.sleep(3000);
        promptAlert.sendKeys("Sharmad");
        Thread.sleep(3000);
        promptAlert.accept();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.id("output")).getText());
        driver.quit();
    }
}
