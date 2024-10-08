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
    /*@Test(invocationCount = 5)
    public void sum(){
        int a = 10;
        int b = 20;
        int c = a + b;
        System.out.println(c);
    }*/

    //Exception timeout test
    /*@Test(timeOut = 2000)
    public void infiniteLoop(){
        int i =1;
        while(i==1){
            System.out.println(i);
        }
    }*/

    //expected exception
    @Test(expectedExceptions = NumberFormatException.class)
    public void test1(){
        String x = "100A";
        Integer.parseInt(x);
    }
}
