package AutomatingBurgerKing;
import BurgerKing.BurgerKingEle;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
public class Bk extends BurgerKingEle {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor jsExecutor;
    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        jsExecutor = (JavascriptExecutor) driver;
        driver.get("https://www.burgerking.in/");
    }
    @Test
    public void testHandleAlert() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            System.out.println("Alert accepted!");
        } catch (NoAlertPresentException | TimeoutException e) {
            System.out.println("No alert present!");
        }
    }
    @Test
    public void testSelectDeliveryOrDineIn() {
        try {
            if (driver.findElement(dineInOption).isDisplayed()) {
                driver.findElement(dineInOption).click();
            } else {
                driver.findElement(deliveryOption).click();
            }
        } catch (Exception e) {
            System.out.println("Error selecting option: " + e.getMessage());
        }
    }
    @Test
    public void testAddChickenWingsAndFries() {
        try {
            WebElement chknWing = driver.findElement(chickenWing);
            wait.until(ExpectedConditions.visibilityOf(chknWing));
            if (chknWing.isDisplayed()) {
                chknWing.click();
            } else {
                driver.findElement(By.xpath("//div[@class='htl-scroll__arrow htl-scroll__arrow_right htl-scroll-rgt htl-scroll__arrow_top']")).click();
            }
            driver.findElement(nonVegFilter).click();
            jsExecutor.executeScript("arguments[0].scrollTop += 900", scrollableOuterDiv);
            driver.findElement(periPeriFriesMedium).click();
            System.out.println("Peri Peri Fries Medium added!");
        } catch (Exception e) {
            System.out.println("Error adding items: " + e.getMessage());
        }
    }
    @Test
    public void testAddDessertAndSnacks() {
        try {
            WebElement chocoMou = driver.findElement(chocoMouButton);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", chocoMou);
            chocoMou.click();
            System.out.println("Chocolate Mousse added!");

            WebElement snacks = driver.findElement(snacksMenu);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", snacks);
            snacks.click();

            WebElement periPeri = driver.findElement(periPeriSpiceMix);
            jsExecutor.executeScript("arguments[0].scrollIntoView(true);", periPeri);
            periPeri.click();
            System.out.println("Peri Peri Spice Mix added!");
        } catch (Exception e) {
            System.out.println("Error adding dessert/snacks: " + e.getMessage());
        }
    }
    @Test
    public void testCartAndCheckout() {
        try {
            driver.findElement(cartButton).click();
            driver.findElement(loginButton).click();
            driver.findElement(mobileNumberField).sendKeys("9876543210");
            driver.findElement(getOtpButton).click();
            System.out.println("OTP requested successfully");
        } catch (Exception e) {
            System.out.println("Error during checkout: " + e.getMessage());
        }
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}