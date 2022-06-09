package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void test01() {
        AmazonPage amazonPage = new AmazonPage();
        // amazon ana sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // nutella araması yapalim
        amazonPage.aramakutusuElementi.sendKeys("nutella" + Keys.ENTER);
        // sonuclarin nutella icerdigini test edelim
        String expectedKelime = "nutella";
        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {

        Object[][] arananKelimeArrayi = {{"Nutella"}, {"Java"}, {"cigdem"}, {"Netherlands"}};

        return new Object[][]{};
    }

    @Test(dataProvider = "aranacakKelimeler") // arayacagimiz kelimeleri bir liste gibi tutup
    // bana yollayacak bir veri saglayaicisi olusturacagiz
    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage = new AmazonPage();
        // amazon ana sayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Nutella, Java, cigdem ve Netherlans icin arama yapalim
        amazonPage.aramakutusuElementi.sendKeys(arananKelime+Keys.ENTER);
        // sonuclarin aradigimiz kelime icerdigini test edelim
        String expectedKelime = arananKelime;
        String actualSonucYazisi = amazonPage.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        // sayfayi kapatalim
        Driver.closeDriver();
    }
}
