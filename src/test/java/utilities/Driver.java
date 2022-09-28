package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    /*
    Testlerimiz çalıştırdığımızda her segerinde yeni driver oluşturduğu için her test methodu için yeni bir pencere (driver) açıyor.
    eğer driver'a bir değer atanmamışsa yani driver == null ise bir kere driver 'i çalıştırır diyerek bir kere if içini çalıştıracak
    ve driver artık bir kere çalıştığı için ve değer atandığı için null olmayacak ve direk return edecek ve diğer testlerimiz aynı
    pencere(driver ) üzerinde çalışacak
     */
    public static WebDriver getDriver(){
        if(driver== null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;

    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.close();
            driver = null;//kapandıktan sonra sonraki açmaları garanti altına almak için null yaptık
        }

    }

    public static void quitDriver(){
        driver.quit();
    }

}