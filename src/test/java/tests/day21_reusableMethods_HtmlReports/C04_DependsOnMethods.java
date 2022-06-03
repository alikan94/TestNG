package tests.day21_reusableMethods_HtmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;

public class C04_DependsOnMethods {
    @Test
    public void test01() throws IOException {
        // amazon sayfasina gidip fotografini cekelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        utilities.ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();
    }
}
