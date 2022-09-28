package tests.Day17;

import Pages.AmazonPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.Driver;

public class C05_PageClass {
    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
        AmazonPage amazon=new AmazonPage();
        amazon.aramakutusu.sendKeys("Nutella", Keys.ENTER);

    }
}
