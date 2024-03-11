import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static Utlity.BaseDriver.driver;

/*

US_202_RegisterNegative:

1. Web tarayıcısını açın ve "demowebshop.tricentis.com" adresine gidin.
2. Anasayfada "Register" butonuna tıklayın.
3. "Your Personal Details" bölümünde test datada verilen bilgileri doldurun:
"Register" butonuna tıklayarak kayıt işlemi gerçekleştirin.

Environment:
https://demowebshop.tricentis.com

Kişisel Bilgiler:
Cinsiyet: Erkek (Male)
Ad: Sdet3
Soyad: Tears4
E-posta: sdettears2@gmail.com
Şifre: Pass1234
Şifre Onay: Pass1234
 */

public class US_202_Negative_Register_User {
    @Test
    public void NegativeRegister(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement Register= driver.findElement(By.xpath("//a[text()='Register']"));
        Register.click();

        WebElement male= driver.findElement(By.xpath("//*[@id='gender-male']"));
        male.click();

        WebElement firstName= driver.findElement(By.xpath("//*[@id='FirstName']"));
        firstName.click();

        WebElement lastName= driver.findElement(By.xpath("//*[@id='LastName']"));
        lastName.click();







    }
}
