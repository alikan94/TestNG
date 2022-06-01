package tests.day19_smokeTest;

import Utilites.ConfigReader;
import Utilites.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;

public class NegatifLoginTest {
    BrcPage brcPage = new BrcPage();

    @Test
    public void yanlisSifre() {

        // Bir test method olustur positiveLoginTest()
        //         https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

        //        login butonuna bas
        brcPage.ilkLoginButonu.click();

        // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidmail"));

        // test data password : 542341
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcWrongPassword"));

        // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
        // Degerleri girildiginde sayfaya basarili sekilde girileMEdigini test et
        Assert.assertTrue(brcPage.ikinciLoginButonu.isDisplayed());

        Driver.closeDriver();
    }

    // bu class'ta 2 test methodu daha olusturun
    // biri yanlis kullanici
    // biri de yanlis sifre ve yanlis kullanici adi

}
