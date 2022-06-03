package tests.day18_pom;

import utilities.ConfigReader;
import utilities.Driver;
import org.testng.annotations.Test;

public class C01_ConfigReader {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));



    }
}
