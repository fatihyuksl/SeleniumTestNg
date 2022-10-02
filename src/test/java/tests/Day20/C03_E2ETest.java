package tests.Day20;

import Pages.HmcPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

public class C03_E2ETest {
    @Test
    public void testE2E() throws InterruptedException {
        //https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));
        HmcPage hmcPage = new HmcPage();
        hmcPage.login.click();
        //Username textbox ve password metin kutularını locate edin ve asagidaki verileri
        //Username : manager
        //Password  : Manager1!
        //Login butonuna tıklayın.
        hmcPage.userNameTexti.sendKeys(ConfigReader.getProperty("userName"));
        hmcPage.passwordTexti.sendKeys(ConfigReader.getProperty("password"));
        hmcPage.LoginButtonu.click();
        //Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        Actions action= new Actions(Driver.getDriver());
        hmcPage.hotelmahagement.click();
        Thread.sleep(2000);
        hmcPage.roomreservation.click();
        Thread.sleep(2000);
        hmcPage.addHotelButton.click();
        Thread.sleep(2000);
        //Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        //Save butonuna tıklayın.
        Faker faker = new Faker();
        hmcPage.İdUser.sendKeys("manager");
        action.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/08/2022")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys("skajdlaksjdaasd")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        //“RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(3000);
        Assert.assertTrue(hmcPage.RoomReservationText.isDisplayed());/
        //OK butonuna tıklayın.
        hmcPage.savabutton.click();






    }
}
