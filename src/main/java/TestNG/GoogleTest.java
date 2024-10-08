/*
 * package TestNG; import org.openqa.selenium.By; import
 * org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * import java.time.Duration; public class GoogleTest { WebDriver driver;
 * 
 * @BeforeMethod public void setUp(){ driver = new ChromeDriver();
 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 * driver.get("http://www.google.com"); }
 * 
 * @Test (priority = 1, groups = "Title") public void googleTitleTest(){ String
 * title = driver.getTitle(); System.out.println(title); }
 * 
 * @Test (priority = 3, groups = "Logo") public void googleLogoTest(){ boolean b
 * =
 * driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed(
 * ); }
 * 
 * @Test (priority = 2, groups = "Link Test") public void mailLinkTest(){
 * boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed(); }
 * 
 * @Test (priority = 4, groups = "Test") public void test1(){
 * System.out.println("Test 1"); }
 * 
 * @Test (priority = 5, groups = "Test") public void test2(){
 * System.out.println("Test 2"); }
 * 
 * @Test (priority = 6, groups = "Test") public void test3(){
 * System.out.println("Test 3"); }
 * 
 * @AfterMethod public void tearDown(){ driver.quit(); } }
 */