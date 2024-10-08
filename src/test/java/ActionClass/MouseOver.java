package ActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource.demo.orangehrmlive.com/index.php/auth/login");
        driver.manage().window().maximize();
        //login
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnLogin")).click();
        //Admin --> User Management --> Users
        Actions act = new Actions(driver);
        WebElement admin = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
        WebElement userMg = driver.findElement(By.xpath("//*[@id='menu_admin_UserManagement']"));
        WebElement users = driver.findElement(By.xpath("//*[@id='menu_admin_viewSystemUsers']"));
        /*act.moveToElement(admin).build().perform(); //mouseOver to admin tab
        act.moveToElement(userMg).build().perform(); //mouseOver to user management tab
        act.moveToElement(users).click().build().perform(); //mouseOver to users and click the option*/
        act.moveToElement(admin).moveToElement(userMg).moveToElement(users).click().build().perform(); // single line of code to perform above 3 lines of action;
    }
}
