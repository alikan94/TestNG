package tests.day16_annotations;

import utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C06_SoftAssert extends TestBase {

    /*
    Soft assertion baslangic ve bitis satirlari arasındaki
    tum assertionlari yapip bitis satirina geldiginide
    bize buldugu tum hatalari rapor eder

    softassertin baslangici obje olusturmaktir

    softasserte bitis satirini soylemek icin assertAll() methodu kullanilir

    assertall demezsen raporlarma olmaz

    Assert = assertion
    soft assert = verification
     */


    @Test
    public void test01() {

        SoftAssert softAssert = new SoftAssert();

        // 1- amazon ana sayfaya git
        driver.get("https://www.amazon.com/");

        // 2- titleın Amazon icerdigini test edin
        String expectedTitle = "amazon";
        String actualTitle = driver.getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitle),"title amazon icermiyor");

        // 3- arama kutusunun erişilebilir oldugunu test edin,
        WebElement aramaKutusuElement = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusuElement.isEnabled(),"arama kutusuna ulasilamiyor");

        // 4- arama kutusuna nutella yazdirip aratin
        aramaKutusuElement.sendKeys("Nutella" + Keys.ENTER);

        // 5- arama yapildigini test edin
        WebElement sonucYaziElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonucYaziElement.isDisplayed(),"arama yapilamadi");

        // 6- arama sonucunun Nutella icerdigini test edin
        softAssert.assertTrue(sonucYaziElement.getText().contains("kutella"),"sonuc yazisi kutella icermiyor");

        softAssert.assertAll();

        /*
        Softassert'un hata bulsa bile calismaya devam etme ozelligi
        assertAll()'a kadardir.
        Eger assertAll()'da failed rapor edilirse calisma durur
        ve class'in kalan kismi calistirilmaz
        (Yani assertAll hardAsserdeki her bir assert gibidir, hatayi yakalarsa calisma durur)
         */

        System.out.println("assertion'lardan fail olan olursa, burasi calismaz");
    }
}
