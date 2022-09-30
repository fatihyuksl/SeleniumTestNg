package tests;

import Pages.FaceebookPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_PageClassFaceBookTest {
    @Test
    public void test01() {
        FaceebookPage faceebookPage= new FaceebookPage();
        // facebook anasayfaya gidin
        Driver.getDriver().get("https://www.facebook.com/");
        // cikarsa cookies kabul edin
        //facebookPage.cookieButonu.click();
        //POM’a uygun olarak email, sifre kutularini ve giris yap
        //butonunu locate edin
        Faker faker = new Faker();

        // kullanici mail kutusuna yanlis kullanici ismi yazdirin
        faceebookPage.mailkutusu.sendKeys(faker.internet().emailAddress());
        faceebookPage.sifreKutusu.sendKeys(faker.internet().password());
        faceebookPage.login.click();
        Assert.assertTrue(faceebookPage.girilemediYaziElementi.isDisplayed());
    }
}
