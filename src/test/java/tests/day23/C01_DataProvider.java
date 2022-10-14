package tests.day23;

import Pages.AmazonPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test
    public void test01() throws InterruptedException {
        AmazonPage amzpage = new AmazonPage();
        //Amazon sayfasına gidelim
        Thread.sleep(3000);
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        amzpage.aramakutusu.sendKeys("Nutella", Keys.ENTER);
        //sonuclarin nutella icerdigini test edelim
        String expectedKelime="Nutella";
        String actualKelime=amzpage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualKelime.contains(expectedKelime));
        Driver.closeDriver();


    }

    @Test(dataProvider = "aranacakKelimeler")
    public void test02(String kelimeler) throws InterruptedException {
        AmazonPage amazonPage = new AmazonPage();
        //amazona gidelim
        Thread.sleep(3000);
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        //java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.aramakutusu.sendKeys(kelimeler, Keys.ENTER);
        String expectedKelime="Nutella";
        String actualKelime=amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualKelime.contains(kelimeler));
        //sonuclarin aradigimiz kelime icerdigini test edelim
        //sayfayi kapatalim
        Driver.closeDriver();

    }
}
