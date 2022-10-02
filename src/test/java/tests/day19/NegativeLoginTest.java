package tests.day19;

import Pages.HmcPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {



    @Test
    public void test01() {
        //1 ) Bir Class olustur : NegativeTest
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage page = new HmcPage();
        page.login.click();
        //test data username: manager ,
        page.userNameTexti.sendKeys(ConfigReader.getProperty("hmcWrongUser"));
        //test data password : manager1!
        page.passwordTexti.sendKeys(ConfigReader.getProperty("hmcWrongPassword"));
        // Degerleri girildiginde sayfaya girilemedigini test et
        page.LoginButtonu.click();
        Assert.assertTrue(page.girisYapilamadiElementi.isDisplayed());

    }
}
