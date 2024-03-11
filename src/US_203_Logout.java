import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


    public class US_203_Logout extends BaseDriver {

        @Test
        public void  Us203(){
            Actions aksiyon=new Actions(driver);
            GirisYap();
            WebElement logout=driver.findElement(By.xpath("//a[text()='Log out']"));
            aksiyon.moveToElement(logout).click().build().perform();
            WebElement confirm=driver.findElement(By.xpath(" //a[text()='Register']"));
            Assert.assertTrue(confirm.getText().contains("Register"),"Çıkış yapılamadı maalesef");

            WaitClose();




        }}


