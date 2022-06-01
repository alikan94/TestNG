package tests.day19_smokeTest;

import Utilites.ConfigReader;
import Utilites.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;

public class PozitifLoginTest {

    BrcPage brcPage = new BrcPage();

    @Test
    public void positiveLoginTest() {

            // Bir test method olustur positiveLoginTest()
            //         https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));

            //        login butonuna bas
        brcPage.ilkLoginButonu.click();

            // test data user email: customer@bluerentalcars.com ,
        brcPage.emailTextBox.sendKeys(ConfigReader.getProperty("brcValidmail"));
            // test data password : 12345
        brcPage.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
            // login butonuna tiklayin
        brcPage.ikinciLoginButonu.click();
            // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName= brcPage.kullaniciProfilIsmi.getText();
        Assert.assertEquals(actualUserName,ConfigReader.getProperty("brcValidUserName"));

        Driver.closeDriver();
    }
/*
    @Test
    public void test01() {

        Driver obj = new Driver();
        obj.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        bu objenin çalışmasını istemiyoruz
        singleton pattern nedeniyle bu obj çalışmaz. bunu da Driver() constructorunu private yaparak
        başardık
    }
 */






}
