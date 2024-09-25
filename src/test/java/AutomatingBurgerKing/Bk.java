package AutomatingBurgerKing;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Bk {
    public static void main(String[] args){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.burgerking.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            try {
                wait.until(ExpectedConditions.alertIsPresent());
                Alert alert = driver.switchTo().alert();
                alert.accept();
                System.out.println("Alert accepted!");
            }
            catch (NoAlertPresentException | TimeoutException nape_te){
                System.out.println("No Alert present!");
            }
            WebElement onDelivery = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span"));
            WebElement onDineIn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span"));
            try {
                if (onDineIn.isDisplayed()){
                    onDineIn.click();
                    try {
                        Alert alert = driver.switchTo().alert();
                        alert.accept();
                        System.out.println("Alert accepted after changing to delivery");
                    }
                    catch (NoAlertPresentException nape){
                        System.out.println("Alert did not appear after changing to delivery!");
                    }
                }
                else{
                    onDelivery.click();
                }
            }
            catch (ElementNotInteractableException enie){
                System.out.println("Cannot interact with the element!");
            }
            try {
                WebElement chknWing = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/section[1]/div[2]/div[2]/div/div/div/div/div[9]/div/div/picture/img"));
                wait.until(ExpectedConditions.visibilityOf(chknWing));
                    if (chknWing.isDisplayed()) {
                        chknWing.click();
                    }
                    else{
                        driver.findElement(By.xpath("//div[@class='htl-scroll__arrow htl-scroll__arrow_right htl-scroll-rgt htl-scroll__arrow_top']")).click();
                    }
            }
            catch (NoSuchElementException nsee) {
                System.out.println("ChickenWing not found in the menu!");
            }
            System.out.println("Script executed successfully");
        }
        catch (Exception e){
            System.out.println("Some error occurred! "+e.getMessage());
        }
        /*finally {
            driver.quit();
        }*/
    }
}