package tests.day18_pom;

import Utilites.ConfigReader;
import Utilites.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;

public class C02_ConfigReaderKullanimi {
    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        FacebookPage facebookPage = new FacebookPage();

        // facebook ana sayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        // kullanici mail kutusuna rasgele bir isim yazin
        facebookPage.mailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));
        // kullanici sifre kutusnua rasgele bir sifre yazin
        facebookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        // login buttonuna basin
        facebookPage.loginTusu.click();
        // giris yapilip yapilmadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());
        // driveri kapat
        Driver.closeDriver();

    }
}
