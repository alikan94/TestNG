package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegatifLoginTestDataProvider {
    BrcPage brcPage;

    @Test
    public void yanlisSifre() {
        brcPage = new BrcPage();
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
