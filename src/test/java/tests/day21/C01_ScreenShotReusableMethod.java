package tests.day21;

import Pages.AmazonPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {
    @Test
    public void test01() throws IOException {
        //Hepsiburada sayfasına gidiniz
        Driver.getDriver().get("https://hepsiburada.com");
        //ve sayfanın resmini alınız
        ReusableMethods.getScreenshot("hepsiburada");
        Driver.closeDriver();

    }

    @Test
    public void test02() throws IOException {
        //amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //nutella aratınız
        AmazonPage amznpage=new AmazonPage();
        amznpage.aramakutusu.sendKeys("Nutella", Keys.ENTER);
        // arama sonuc yazısı webelementinin resmini alınızği123


        ReusableMethods.getScreenshotWebElement("AramaSonucWe",amznpage.aramaSonucuElementi);
    }
}
