import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Us_208 extends BaseDriver {

    By cmptr=By.xpath("(//a[@href='/computers'])[1]");
    By dsktp=By.xpath("(//a[@href='/desktops'])[1]");
    By pc=By.xpath("//a[text()='Build your own cheap computer']");
    By addtoC=By.xpath("//input[@id='add-to-cart-button-72']");

    By sepeteEklendiMsg=By.xpath("//p[@class='content']");
    @Test
    public void US_208(){

        GirisYap();

        //Computers kategorisine gider
        Actions actionDriver=new Actions(driver);
        WebElement computers=driver.findElement(cmptr);
        actionDriver.moveToElement(computers).build().perform();

        //Desktops grubuna tıklar
        WebElement desktops= driver.findElement(dsktp);
        actionDriver.moveToElement(desktops).click().build().perform();

        //İlk bilgisayarın ismini alır ve bilgisayara tıklar
        WebElement masaustu= driver.findElement(pc);
        String siparisIsim=masaustu.getText();
        actionDriver.moveToElement(masaustu).click().build().perform();

        //Sepete ekler
        WebElement sepeteEkle= driver.findElement(addtoC);
        actionDriver.moveToElement(sepeteEkle).click().build().perform();

        //Sepete eklendikten sonra alının doğrulama mesaajı
        WebElement eklendiMsg= driver.findElement(sepeteEklendiMsg);
        Assert.assertTrue(eklendiMsg.getText().contains("The product has been added to your "));
        wait.until(ExpectedConditions.textToBe(sepeteEklendiMsg,"The product has been added to your "));




        WaitClose();
    }
}
