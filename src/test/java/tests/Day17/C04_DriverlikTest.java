package tests.Day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverlikTest {
    @Test
    public void  test01()  {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://bestbuy.com");
        Driver.getDriver().get("https://hepsiburada.com");
        Driver.closeDriver();
    }
}
