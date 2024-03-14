import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class US_209 extends BaseDriver {

    @Test
    public void US_209() throws AWTException {

        GirisYap();
        Actions actionD = new Actions(driver);
        Robot robot = new Robot();

        //Account sayfasına git
        WebElement myAccount = driver.findElement(By.xpath("//a[text()='My account']"));
        wait.until(ExpectedConditions.visibilityOf(myAccount));
        actionD.moveToElement(myAccount).click().build().perform();

        //Account sayfasının geçmenin doğrulanması
        WebElement accountTitle = driver.findElement(By.xpath("(//div[@class='title']//strong)[1]"));
        wait.until(ExpectedConditions.visibilityOf(accountTitle));
        Assert.assertEquals(accountTitle.getText(), "MY ACCOUNT", "Account sayfasına ulaşılamadı!");

        //Siparişlere tıklama ve doğrulama adımı.
        WebElement orders = driver.findElement(By.xpath("(//a[text()='Orders'])[1]"));
        actionD.moveToElement(orders).click().build().perform();

        //Siparişlerin var olup olmadığını doğrulama
        List<WebElement> liste = driver.findElements(By.xpath("//div[@class='order-list']//div//div//strong"));
        Assert.assertFalse(liste.isEmpty(), "Siparişler yer almamaktadır.");

        //Siparişler arasından bir siparişin detaylarına tıklama adımı
        List<WebElement> detailsListe = driver.findElements(By.xpath("//input[@value='Details']"));
        int randomSiparis = (int) (Math.random() * detailsListe.size());
        WebElement randomDetail = detailsListe.get(randomSiparis);
        actionD.moveToElement(randomDetail).click().build().perform();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/orderdetails/"), "İlgili siparişin detayları görüntülenemiyor.");
        WebElement orderNumber = driver.findElement(By.xpath("//div[@class='order-number']//strong"));
        String siparisNo = orderNumber.getText();
        String siparisNoSon = siparisNo.replaceAll("[^0-9]", "");
        System.out.println(siparisNoSon);
        wait.until(ExpectedConditions.visibilityOf(orderNumber));

        //Fatura işlemi
        WebElement fatura = driver.findElement(By.xpath("//a[text()='PDF Invoice']"));
        actionD.moveToElement(fatura).click().build().perform();
        Assert.assertNotNull(fatura, "Fatura bulunamadı");

        //İndirme kısmına geçmesi
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_J);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_J);

        MyFunc.Bekle(20);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        MyFunc.Bekle(20);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Set<String> idler=driver.getWindowHandles();
        Iterator gosterge= idler.iterator();
        String birinciSekmeId= gosterge.next().toString();
        String ikinciSekmeId= gosterge.next().toString();

        driver.switchTo().window(ikinciSekmeId);

        Assert.assertTrue(driver.getCurrentUrl().contains(siparisNoSon), "İndirilen dosya bulunamadı");
        System.out.println(driver.getCurrentUrl());
        System.out.println(ikinciSekmeId);

        //İndirilen faturanın detaylarının görüntülenmesi


    }
}
