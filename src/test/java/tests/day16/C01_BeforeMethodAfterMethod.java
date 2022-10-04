package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBase;
import utilities.TestBaseBeforeAfter;

public class C01_BeforeMethodAfterMethod extends TestBase {
    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");

    }
    @Test(groups = "grp1")
    public void bestBuyTesti() {
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void dtechproeducationTesti() {
        driver.get("https://www.techproeducation.com");
    }
}
