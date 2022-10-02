package tests.Day18;

import Pages.HmcPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader {
    @Test
    public void test01() {
        //https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage page = new HmcPage();
        //test data username: manager ,
        page.login.click();
        //test data password : Manager1!
        page.userNameTexti.sendKeys(ConfigReader.getProperty("userName"));
        page.passwordTexti.sendKeys(ConfigReader.getProperty("password"));
        //Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        page.LoginButtonu.click();
        Assert.assertTrue(page.LoginKullanıcı.isDisplayed());
    }
}
