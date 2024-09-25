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
        JavascriptExecutor outerWin = (JavascriptExecutor) driver;
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
            WebElement scrollableOuterDiv = driver.findElement(By.xpath("//div[@class='product-page_wrapper']"));
            driver.findElement(By.xpath("//div[@class='burgertype__item burgertype__item_inactive' and contains(text(),'non-veg')]")).click();
            outerWin.executeScript("arguments[0].scrollTop += 900",scrollableOuterDiv);
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[6]/div/div/div[2]/div[2]/div[2]/button/div")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[2]/div[2]/button")).click();
            int count=0;
            for (int i=0; i<3; i++){
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[2]/div[2]/div/div[3]")).click();
                count++;
            }
            System.out.println(count + " Fries(L) added!");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[3]/div[2]/button")).click();
            System.out.println("Peri Peri Fries added!");
            //adding chocolate mouse
            WebElement chocoMou = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[6]/div[1]/div[2]/button"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",chocoMou);
            chocoMou.click();
            System.out.println("Chocolate Mouse added!");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[7]/button")).click();
            //navigating to snacks menu
            WebElement snacks = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/div/div[2]/div/div/div[6]/div"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",snacks);
            snacks.click();
            //adding peri peri spice mix
            WebElement periPeri = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/button/div"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",periPeri);
            periPeri.click();
            System.out.println("Peri Peri Spice mix added!");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[6]/button")).click();
            //adding masala hashbrown
            WebElement masalaHashbrown = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[9]/div/div/div[2]/div[2]/div[2]/button/div"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",masalaHashbrown);
            masalaHashbrown.click();
            System.out.println("Masala Hashbrown added!");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[6]/button")).click();
            //adding fiery hell dip
            WebElement fieryHellDip = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[5]/div/div/div[2]/div[2]/div[2]/button/div"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",fieryHellDip);
            fieryHellDip.click();
            System.out.println("Fiery Hell Dips added!");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[6]/button")).click();
            //adding peri peri fries medium
            WebElement periPeriFries = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[3]/div[1]/div[2]/div[7]/div/div/div[2]/div[2]/div[2]/button/div"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",periPeriFries);
            periPeriFries.click();
            System.out.println("Peri peri medium Fries added!");
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[6]/button")).click();
            //click on cart
            driver.findElement(By.xpath("//ul/li/span[contains(text(),'Cart')]")).click();
            //click on login to place order
            driver.findElement(By.xpath("//button[@type='button']/span[1]")).click();
            //send value to enter mobile number textfield
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/input")).sendKeys("9876543210");
            //get otp
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/button")).click();
            System.out.println("Script executed successfully");
        }
        catch (Exception e){
            System.out.println("Some error occurred! "+e.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}