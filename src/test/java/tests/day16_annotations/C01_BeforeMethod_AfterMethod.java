package tests.day16_annotations;

import utilities.TestBase;
import org.testng.annotations.Test;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    // @BeforeMethod ve @AfterMethod  notasyonlari
    // JUnit'deki @Before ve @After gibidir
    // her test method'undan once ve sonra calisirlar

    @Test
    public void test01() {

        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test02() {

        driver.get("https://www.bestbuy.com/");

    }

    @Test
    public void techproeduTest() {

        driver.get("https://www.techproeducation.com/");

    }
}
