package TestNG;
import org.testng.annotations.*;
public class TestNgBasics {
    //pre-conditions annotations start here with @Before
    @BeforeSuite
    public void setUp(){
        System.out.println("Set up system property for chrome");
    }
    @BeforeTest
    public void launchBrowser(){
        System.out.println("Launch chrome browser");
    }
    @BeforeClass
    public void login(){
        System.out.println("Login to app");
    }
    @BeforeMethod
    public void enterURL(){
        System.out.println("Enter URL");
    }
    //pre-conditions annotations end here

    //This is the test condition. Start with @Test
    @Test
    public void googleTitleTest(){
        System.out.println("Google Title test case");
    }

    @Test
    public void searchTest(){
        System.out.println("Search Test");
    }

    @Test
    public void googleLogoTest(){
        System.out.println("Google logo test");
    }
    //test condition end here

    //post conditions start here with @After
    @AfterMethod
    public void logout(){
        System.out.println("Logout from App");
    }
    @AfterClass
    public void closeBrowser(){
        System.out.println("Close Browser");
    }
    @AfterTest
    public void deleteAllCookies(){
        System.out.println("Delete all cookies");
    }
    @AfterSuite
    public void generateTestReport(){
        System.out.println("Generate test report");
    }
    //post conditions end here
}
