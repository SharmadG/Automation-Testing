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
        JavascriptExecutor innerWin = (JavascriptExecutor)  driver;
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
            driver.findElement(By.xpath("//div[@class='burgertype__item burgertype__item_inactive' and contains(text(),'non-veg')]")).click();
            WebElement scrollableOuterDiv = driver.findElement(By.xpath("//div[@class='product-page_wrapper']"));
            outerWin.executeScript("arguments[0].scrollTop += 900",scrollableOuterDiv);
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[6]/div/div/div[2]/div[2]/div[2]/button/div")).click();
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[2]/div[2]/button")).click();
            for (int i=0; i<3; i++){
                driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[2]/div[2]/div/div[3]")).click();
                System.out.println(i+1 + " Fries(L) added!");
            }
            driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[3]/div[2]/button")).click();
            System.out.println("Peri Peri Fries added!");
            WebElement scrollableInnerDiv = driver.findElement(By.xpath("(//div[@class='modal_wrapper undefined undefined']//descendant::div/div)[1]"));
            WebElement chocoMou = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[6]/div[1]/div[2]/button"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",chocoMou);
            chocoMou.click();
            System.out.println("Chocolate Mouse added!");
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