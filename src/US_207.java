import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_207 extends BaseDriver {
    @Test
    public void us_207(){
        Actions aksiyonlar = new Actions(driver);

        WebElement community = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        aksiyonlar.moveToElement(community).click().build().perform();


        WebElement button = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        aksiyonlar.moveToElement(button).click().build().perform();

        WebElement msj = driver.findElement(By.xpath("//div[@id='block-poll-vote-error-1']"));

        Assert.assertTrue(msj.isDisplayed(),"mesaj bulundu");


       GirisYap();


WaitClose();
    }
}
