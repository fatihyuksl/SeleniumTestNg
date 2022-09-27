package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseBeforeAfter;

public class C04_DependsOfmethod extends TestBase {
    @Test
    public void test1() {
        //amazon ana sayfasıan gidelim
        driver.get("https://www.amazon.com");
    }
    @Test (dependsOnMethods = "test1")
    public void Test2() {
        //Nutella Aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

    }
    @Test(dependsOnMethods="test2")
    public void test3() {
        //Sonuc yazısının amazon içerdiğini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.getText().contains("Nutella"));

    }
}
