package tests.day22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
import utilities.TestBaseCross;

public class C03_SoftAssert extends TestBaseCross {
    @Test
    public void test01() {
        SoftAssert softAssert = new SoftAssert();
        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon123"),"Girdiğiniz kelimeyi içermiyor");
        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramakutusu.isEnabled(),"Web element erişilmez");
        //4-arama kutusuna Nuella yazıp aratın
        aramakutusu.sendKeys("Nutella", Keys.ENTER);
        //5-arama yapıldıgını test edin
        WebElement sonuc= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"SonucWebElementi görüntülenmedi");
        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella42"),"Nutella içermiyor");
        softAssert.assertAll();
         /*
        Softassert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir.
        Eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)
         */
        System.out.println("assertion'lardan fail olan olursa, burasi calismaz");
        /*
           this() : aynı class içerisinde constructor çağırmak için kullanılır.
           this. ise aynı class içinde variable çağırmak için kullanılır sanırım böyleydi
         */
    }



}
