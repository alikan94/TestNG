package tests.day17_pom;

import utilities.Driver;
import org.testng.annotations.Test;

public class C01_YeniDriverIlkClass {

    @Test
    public void test01(){
        Driver.getDriver().get("https://www.amazon.com/");
        /*
        Bugune kadar TestBase class'ina extends ederek kullandigimiz driver yerine
        bundan sonra Driver class'indan kullanacagimiz getDriver static method'unu kullanacagiz

        Driver.getDriver()    in
        driver                out
         */

        Driver.getDriver().get("https://www.facebook.com/");
        Driver.getDriver().get("https://www.bestbuy.com/");

        Driver.closeDriver();

    }
}
