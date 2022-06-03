package tests.day17_pom;

import utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;

public class C03_PageClassKullanimi {

    @Test
    public void test01() {
        FacebookPage facebookPage = new FacebookPage();
        Faker faker = new Faker();

        // facebook ana sayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");

        // kullanici mail kutusuna rasgele bir isim yazin
        facebookPage.mailKutusu.sendKeys(faker.internet().emailAddress());

        // kullanici sifre kutusnua rasgele bir sifre yazin
        facebookPage.sifreKutusu.sendKeys(faker.internet().password());

        // login buttonuna basin
        facebookPage.loginTusu.click();

        // giris yapilip yapilmadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        Driver.closeDriver();
    }
}
