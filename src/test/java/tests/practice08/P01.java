package tests.practice08;
import Pages.HerokuTestPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.Driver;
import utilities.TestBaseRapor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
public class P01 extends TestBaseRapor {


    //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    //Click all the buttons and verify they are all clicked
    HerokuTestPage herokuTestPage;
    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("TIKLAMA PRATİĞİ", "PRACTICE08");
        extentTest.info("Aciklama");

        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");
        extentTest.info("driver get ile url gidildi");
        //Click all the buttons and verify they are all clicked
        herokuTestPage = new HerokuTestPage();
        //kodlarımız yazarken clean code kapsamında daha sade kod yazabilmek amacı ile her test methodu içerisinde
        //ayrı bir object create etmektense bu objecti class seviyesinde instance olarak create edip
        //test methodlarında buna değer atamak ve kullanmak daha uygun bir yöntemdir
        extentTest.info("page objesi üzerinden elementelere tıklanmaya baslandı");
        herokuTestPage.onblur.click();
        herokuTestPage.onclick.click();
        herokuTestPage.onclick.click();
        actions.contextClick(herokuTestPage.contextmenu).
                doubleClick(herokuTestPage.doubleClick).
                click(herokuTestPage.onfocus).
                click(herokuTestPage.keydown)
                .sendKeys(Keys.ENTER).
                click(herokuTestPage.keyup).
                sendKeys(Keys.ENTER).
                click(herokuTestPage.keypress).
                sendKeys(Keys.ENTER).
                moveToElement(herokuTestPage.mouseOver).
                moveToElement(herokuTestPage.mouseLeave).
                moveToElement(herokuTestPage.mouseOver).
                click(herokuTestPage.mouseDown).perform();
        Thread.sleep(2000);
        extentTest.info("tıklama islemi burada bitti");
    }
    @Test (dependsOnMethods = "test01")
    public void test02() {
        extentTest=extentReports.createTest("TIKLAMA assertion", "assertion");
        extentTest.info("burada listin size ı alınarak doğrulama yapıldı");
        List<WebElement> clicked = herokuTestPage.eventTriggered;
        Assert.assertEquals(clicked.size(), 11);
        extentTest.pass("basarılı sekilde sonuclandı");
    }
}