import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_207 extends BaseDriver {
    @Test
    public void us_207(){


        WebElement community = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        community.click();

        WebElement button = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        button.click();

        WebElement msj = driver.findElement(By.xpath("//div[@id='block-poll-vote-error-1']"));

        Assert.assertTrue(msj.isDisplayed(),"mesaj bulundu");


       GirisYap();


WaitClose();
    }
}
