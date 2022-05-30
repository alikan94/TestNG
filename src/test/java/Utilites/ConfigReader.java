package Utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties properties;

    static {
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            // fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
            properties=new Properties();
            properties.load(fis); // fisin okudugu bilgileri propertiese yukledi

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){

        /*

        test methodundan yolladigimiz string key degerini alip
        properties classindan getProperty() methodunu kullanarak
        bu keye ait value'u bize getirdi

         */

        return properties.getProperty(key);
    }
}
