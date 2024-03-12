import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Us_208 extends BaseDriver {

    By cmptr=By.xpath("(//a[@href='/computers'])[1]");
    By dsktp=By.xpath("(//a[@href='/desktops'])[1]");
    By addtoC=By.xpath("//input[@id='add-to-cart-button-72']");

    By sepeteEklendiMsg=By.xpath("//p[@class='content']");

    By chart=By.xpath("(//a[@class='ico-cart'])[1]");
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
        JavascriptExecutor js=(JavascriptExecutor) driver;
        WebElement masaustu=driver.findElement(By.xpath("(//img[@alt='Picture of Build your own cheap computer'])[1]"));
        String cmptrInfo=masaustu.getText();
        js.executeScript("arguments[0].click();", masaustu);

        //Sepete ekler
        WebElement sepeteEkle= driver.findElement(addtoC);
        actionDriver.moveToElement(sepeteEkle).click().build().perform();

        //Sepete eklendikten sonra alının doğrulama mesaajı
        WebElement eklendiMsg= driver.findElement(sepeteEklendiMsg);
        Assert.assertTrue(eklendiMsg.getText().contains("The product has been added to your "));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sepeteEklendiMsg));

        //Yukarıdaki sepete gidiyor ve tıklıyor
        WebElement ySepet= driver.findElement(chart);
        actionDriver.moveToElement(ySepet).click().build().perform();

        //Sepetteki ürün ile eklenen ürünün aynı olup olmadığını doğruladık
        WebElement sepettekiIsim= driver.findElement(By.xpath("(//a[@href='/build-your-cheap-own-computer'])[1]"));
        Assert.assertTrue(sepettekiIsim.getText().contains(cmptrInfo),"Eklenen ürün ile sepetteki ürün aynı değil");

        //Kupon eklemeyi denemeliyim ve kuponum olmadığı için hata mesajı almalıyım.
        WebElement applyCoupon=driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        actionDriver.moveToElement(applyCoupon).click().build().perform();
        WebElement couponNegativeMsg= driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue(couponNegativeMsg.getText().contains("The coupon code you entered couldn't be applied to your order"), "kupon başarılı bir şekilde uygulandı.");


        WebElement applyGiftCard=driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        actionDriver.moveToElement(applyGiftCard).click().build().perform();
        WebElement giftNegativeMsg= driver.findElement(By.xpath("//div[@class='message']"));
        Assert.assertTrue(giftNegativeMsg.getText().contains("The coupon code you entered couldn't be applied to your order"), "Hediye kartı başarılı bir şekilde uygulandı.");










        WaitClose();
    }
}
