import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Utlity.BaseDriver.*;

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

 Kullanıcı, aynı e-posta adresiyle kayıt yapmaya çalıştığında "The specified email already exists" mesajını görüntüler.
- Kullanıcı, hesap doğrulama sayfasına yönlendirilir.
 */

public class US_202_Negative_Register_User extends BaseDriver {
    @Test
    public void NegativeRegister(){

        Actions aksiyonlar=new Actions(driver);
        WebElement register= driver.findElement(By.xpath("//a[text()='Register']"));
        aksiyonlar.moveToElement(register).click().build().perform();

        WebElement male= driver.findElement(By.xpath("//*[@id='gender-male']"));
        aksiyonlar.moveToElement(male).click().build().perform();

        WebElement firstName= driver.findElement(By.xpath("//*[@id='FirstName']"));
        aksiyonlar.moveToElement(firstName).click().sendKeys("Sdet3").build().perform();

        WebElement lastName= driver.findElement(By.xpath("//*[@id='LastName']"));
        aksiyonlar.moveToElement(lastName).click().sendKeys("Tears4").build().perform();

        WebElement email= driver.findElement(By.xpath("//*[@id='Email']"));
        aksiyonlar.moveToElement(email).click().sendKeys("sdettears2@gmail.com").build().perform();

        WebElement password= driver.findElement(By.xpath("//*[@id='Password']"));
        aksiyonlar.moveToElement(password).click().sendKeys("Pass1234").build().perform();

        WebElement confirmPassword= driver.findElement(By.xpath("//*[@id='ConfirmPassword']"));
        aksiyonlar.moveToElement(confirmPassword).click().sendKeys("Pass1234").build().perform();

        WebElement RegisterButton= driver.findElement(By.xpath("//*[@id='register-button']"));
        aksiyonlar.moveToElement(RegisterButton).click().build().perform();

        WebElement msg= driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
        Assert.assertTrue(msg.getText().equals("The specified email already exists"),"girmiş olduğunuz email ile daha önce kayıt yapılmıştır");
        // msg.getText().equals yerine msg.getText().contains  kullanabiliriz
        System.out.println("msg.getText() = " + msg.getText());
        WaitClose();


















    }
}
