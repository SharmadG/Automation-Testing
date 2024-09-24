package AutomatingWebDriverUni;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class RadioBtn {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        driver.manage().window().maximize();
        try{
            driver.findElement(By.xpath("//form[@id='radio-buttons']/input[@value='yellow']")).click();
        }
        catch (Exception e){
            System.out.println("Unable to locate the element!" + e.getMessage());
        }
        finally {
            System.out.println("Script executed successfully!");
            driver.quit();
        }
    }
}
