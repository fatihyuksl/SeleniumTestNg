package tests.day21;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandlesReusableMethod {
    @Test
    public void test01() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        Driver.getDriver().getWindowHandle();
        //● Click Here butonuna basın.
        Driver.getDriver().findElement(By.cssSelector("a[href=\"/windows/new\"]")).click();
        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        Driver.getDriver().getWindowHandles();
        List<String> wh=new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(wh.get(1));
        assert Driver.getDriver().getTitle().equals("New Window");

    }

    @Test
    public void test02() {
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //● Click Here butonuna basın.
        ReusableMethods.waitFor(3);
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        // acilan yeni tab'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Driver.quitDriver();

    }
}
