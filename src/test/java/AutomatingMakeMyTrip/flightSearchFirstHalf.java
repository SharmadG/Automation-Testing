package AutomatingMakeMyTrip;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class flightSearchFirstHalf {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try{
            driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
            //fromCity
            driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox searchCity inactiveWidget ']")).click();
            WebElement fromCityDD = driver.findElement(By.xpath("//div[@id='react-autowhatever-1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 100);", fromCityDD);
            driver.findElement(By.xpath("//p[contains(text(),'Pune, India')]")).click();
            //toCity
            driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox searchToCity inactiveWidget ']")).click();
            WebElement toCityDD = driver.findElement(By.xpath("//div[@id='react-autowhatever-1']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 100);", toCityDD);
            driver.findElement(By.xpath("//p[contains(text(),'Goa - Dabolim Airport, India')]")).click();
            //driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
            //departureDate
            driver.findElement(By.xpath("//div[@aria-label='Wed Oct 30 2024']")).click();
            //returnDate
            driver.findElement(By.xpath("//div[@class='flt_fsw_inputBox dates reDates inactiveWidget ']")).click();
            driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            driver.findElement(By.xpath("//div[@aria-label='Sat Nov 30 2024']")).click();
            //travellersAndClass
            driver.findElement(By.xpath("//div[@data-cy='flightTraveller']")).click();
            driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li[@data-cy='adults-3']")).click();
            driver.findElement(By.xpath("//ul[@class='guestCounter font12 darkText gbCounter']/li[@data-cy='children-2']")).click();
            driver.findElement(By.xpath("//ul[@class='guestCounter classSelect font12 darkText']/li[@data-cy='travelClass-3']")).click();
            //clickApply
            driver.findElement(By.xpath("//div[@class='right makeFlex hrtlCenter']/button[contains(text(),'APPLY')]")).click();
            //tripType (One Way, Round Trip, Multi City)
            driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']/span[@class='tabsCircle appendRight5']")).click(); //oneWay trip select
            Thread.sleep(4000);
            //clickSearch
            driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click(); //searchBtn clicked

            //Further script is just a trail and error based code. Network access is revoked!

            //if random overlay appear
            try {
                WebElement commOverlay = driver.findElement(By.xpath("//div[@class='commonOverlay ']"));
                if(commOverlay.isDisplayed()){
                    driver.findElement(By.xpath("//span[@class='bgProperties overlayCrossIcon icon20']")).click();
                }
            }
            catch (NoSuchElementException nsee){
                System.out.println("No such element found");
            }

            try{
                WebElement netProbPg = driver.findElement(By.xpath("//button[@class='button buttonPrimary buttonBig fontSize14']"));
                while(netProbPg.isDisplayed()){
                    driver.findElement(By.xpath("//div[@id='fullpage-error']")).click();
                    System.out.println("Refresh clicked");
                }
            }
            catch (Exception e){
                System.out.println("Unknown error occurred");
            }

            System.out.println("Script executed successfully!");
        }
        catch (NoSuchElementException nsee){
            System.out.println("Element not found!"+nsee.getMessage());
        }
        catch (ElementNotInteractableException enie){
            System.out.println("Cannot interact with element!"+enie.getMessage());
        }
        catch (Exception e){
            System.out.println("Something went wrong!"+e.getMessage());
        }
        finally {
            driver.quit();
        }
    }
}
