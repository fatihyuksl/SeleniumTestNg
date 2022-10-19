package tests.day22;

import Pages.BrcPagee;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {

          /*
           -https://www.bluerentalcars.com/ adresine git
           -login butonuna bas
           -test data user email: customer@bluerentalcars.com ,
           -test data password : 12345 dataları girip login e basın
           -login butonuna tiklayin
           -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
            */

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Positive Login", "Valid username");
        // Bir test method olustur positiveLoginTest()
        //  https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        BrcPagee brcPage = new BrcPagee();
        //-https://www.bluerentalcars.com/ adresine git

        //      login butonuna bas
        brcPage.ilkLoginButonu.click();
        extentTest.info("login butonuna tiklandi");

        //test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("Gecerli email yazdirildi");

        //test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("Gecerli sifre yazildi");

        //login butonuna tiklayin123456
        brcPage.ikinciLoginButonu.click();
        extentTest.info("Login butonuna tiklandi");

        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(brcPage.kullaniciProfilIsmi.isDisplayed());
        extentTest.info("Kullanici basarili bir sekilde giris yapti");

        Driver.closeDriver();
    }


}


