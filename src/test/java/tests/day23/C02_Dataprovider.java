package tests.day23;

import Pages.BrcPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_Dataprovider {


    @DataProvider
    public static Object[][] kullanıcılar() {
        return new Object[][]{{"fuksel@gmail.com","12345"},{"yuksel@gmail.com","45678"},{"ahmet@gmail.com","123456"}};
    }

    @Test(dataProvider="kullanıcılar")
    public void test01(String userEmail, String password) throws InterruptedException {
        BrcPage page = new BrcPage();
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //login butonuna bas
        page.ilkLoginButonu.click();
        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        page.emailTextBox.sendKeys(userEmail);
        Thread.sleep(3000);
        page.passwordTextBox.sendKeys(password);

        //login butonuna tiklayin
        page.ikinciLoginButonu.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(page.ikinciLoginButonu.isDisplayed());



    }
}
