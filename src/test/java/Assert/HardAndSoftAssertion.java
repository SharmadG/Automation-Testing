package Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
public class HardAndSoftAssertion {
    // Example of hard assertion
    @Test
    public void hardAssertion(){
        System.out.println("Open browser");
        Assert.assertEquals(true, false); // hard assertion - It will make sure that if the condition fails, further execution will be revoked
        System.out.println("enter username");
        System.out.println("enter password");
        System.out.println("click on sign in button");
        Assert.assertEquals(true, false); // hard assertion
        System.out.println("validate home page");
        Assert.assertEquals(true, false); // hard assertion -- if any of the condition fails, then none of the following line of code will be executed
        System.out.println("go to deals page");
        System.out.println("create a deal");
        System.out.println("go to contacts");
        System.out.println("create a contact");
    }
    //Example of Soft assertion
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void softAssertion() {
        System.out.println("Open browser");
        Assert.assertEquals(true, false); // hard assertion - It will make sure that if the condition fails, further execution will be revoked
        System.out.println("enter username");
        System.out.println("enter password");
        System.out.println("click on sign in button");
        softAssert.assertEquals(true, false); // hard assertion
        System.out.println("validate home page");
        softAssert.assertEquals(true, false); /* soft assertion -- even if the condition fails, it will still execute the next lines of code. It will not mark your
                                                                                  test case as fail even if the test case fails. To overcome this issue we should make use of
                                                                                  "softAssert.assertAll()" condition. */
        System.out.println("go to deals page");
        System.out.println("create a deal");
        softAssert.assertEquals(true, false);
        System.out.println("go to contacts");
        System.out.println("create a contact");
        softAssert.assertEquals(true, false);
        softAssert.assertAll();
    }
    @Test
    public void test1(){
        System.out.println("Log out");
        softAssert.assertEquals(true, false); // here the test case fail and if we don't make use of assertAll() then it will display the test case as passed
        softAssert.assertAll(); // after using the assertAll() condition, the test case will execute without any interruption but display the test result as failed
    }
    @AfterClass
    public void tearDown(){
        softAssert.assertAll();
    }
}