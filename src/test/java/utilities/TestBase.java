package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase {
    protected   WebDriver driver;
    //Beforeclass ve AfterClass notasyonlarını kullnaırken JUnıt teki gibi static yapmaya gerek yoktur
    @BeforeClass(groups = "grp1")
    public void setup()  {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass(groups = "grp1")
    public void tearDown() {
       // driver.close();
    }

}
