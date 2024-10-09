package BurgerKing;
import org.openqa.selenium.By;
public class BurgerKingEle {
    public static By deliveryOption = By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span");
    public static By dineInOption = By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span");
    public static By chickenWing = By.xpath("/html/body/div[1]/div[3]/div[2]/section[1]/div[2]/div[2]/div/div/div/div/div[9]/div/div/picture/img");
    public static By scrollableOuterDiv = By.xpath("//div[@class='product-page_wrapper']");
    public static By nonVegFilter = By.xpath("//div[@class='burgertype__item burgertype__item_inactive' and contains(text(),'non-veg')]");
    public static By periPeriFriesMedium = By.xpath("//*[@id='root']/div[3]/div/div[3]/div[1]/div[2]/div[7]/div/div/div[2]/div[2]/div[2]/button/div");
    public static By periPeriFriesLarge = By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[2]/div[2]/div/div[3]");
    public static By periPeriFriesButton = By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[4]/div[3]/div[2]/button");
    public static By chocoMouButton = By.xpath("/html/body/div[1]/div[3]/div/div[4]/div/div[1]/div/div/div/div/div[6]/div[1]/div[2]/button");
    public static By snacksMenu = By.xpath("/html/body/div[1]/div[3]/div/div[1]/div/div/div[2]/div/div/div[6]/div");
    public static By periPeriSpiceMix = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/button/div");
    public static By masalaHashbrown = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[9]/div/div/div[2]/div[2]/div[2]/button/div");
    public static By fieryHellDip = By.xpath("/html/body/div[1]/div[3]/div/div[3]/div[1]/div[2]/div[5]/div/div/div[2]/div[2]/div[2]/button/div");
    public static By cartButton = By.xpath("//ul/li/span[contains(text(),'Cart')]");
    public static By loginButton = By.xpath("//button[@type='button']/span[1]");
    public static By mobileNumberField = By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/input");
    public static By getOtpButton = By.xpath("/html/body/div[1]/div[3]/div/div/div[3]/div/div[1]/div/div/div/div[2]/div[2]/button");
}
