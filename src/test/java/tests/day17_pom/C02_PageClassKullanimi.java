package tests.day17_pom;

import Utilites.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;

public class C02_PageClassKullanimi {

    @Test
    public void test01() {

        AmazonPage amazonPage = new AmazonPage();

        // 1- amazona gidelim
        Driver.getDriver().get("https://www.amazon.com//");
        // Nutella aratalim
        amazonPage.aramakutusuElementi.sendKeys("Nutella"+ Keys.ENTER);
        // sonuclarda Nutella icerdigini test edelim
        String actualSonuc = amazonPage.aramaSonucuElementi.getText();
        String arananKelime = "Nutella";

        Assert.assertTrue(actualSonuc.contains(arananKelime));
        Driver.closeDriver();
    }
}
