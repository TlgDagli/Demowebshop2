import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_207_Survey_Response extends BaseDriver {
    @Test
    public void Test1(){
       WebElement Login=driver.findElement(By.xpath("//a[text()='Log in']"));
       Actions aksiyon=new Actions(driver);
       MyFunc.Bekle(2);


       WebElement Excellent= driver.findElement(By.id("pollanswers-1"));
       aksiyon.moveToElement(Excellent).click().build().perform();
       MyFunc.Bekle(3);

       WebElement Vote= driver.findElement(By.id("vote-poll-1"));
       aksiyon.moveToElement(Vote).click().build().perform();
       MyFunc.Bekle(3);
       System.out.println("Kullanıcı girişi yapılmadığı için oy kullanılamamıştır.Lütfen giriş yapınız");






        //WebElement Login=driver.findElement(By.xpath("//a[text()='Log in']"));

        //Actions aksiyon=new Actions(driver);

        //MyFunc.Bekle(2);



        //aksiyon.moveToElement(Login).click().build().perform();
        //WebElement email=driver.findElement(By.id("Email"));
        //aksiyon.moveToElement(email).click().sendKeys("sdettears@gmail.com").build().perform();
        //MyFunc.Bekle(2);

        //WebElement Password=driver.findElement(By.id("Password"));
        //aksiyon.moveToElement(Password).click().sendKeys("Pass1234").build().perform();
        //MyFunc.Bekle(2);

        //WebElement btn=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        //aksiyon.moveToElement(btn).click().build().perform();
        //MyFunc.Bekle(2);
        //System.out.println("Kullanılan oylar başarıyla görüntülenmiştir");







        WaitClose();














    }


}
