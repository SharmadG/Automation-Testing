package TestNG;

import org.testng.annotations.Test;

public class TestNgFeatures {

    //dependsOnMethods feature practice
    /*@Test
    public void loginTest(){
        System.out.println("Login test");
    }
    @Test(dependsOnMethods = "loginTest")
    public void homePageTest(){
        System.out.println("home page test");
    }*/

    //Invocation count test
    @Test(invocationCount = 10)
    public void sum(){
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);
    }
}
