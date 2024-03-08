import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class US_201_Register_User extends BaseDriver {
    @Test
    public void Register(){
        driver.get("https://demowebshop.tricentis.com/");
        Actions aksiyonlar=new Actions(driver);
        WebElement register= driver.findElement(By.xpath("//a[text()='Register']"));
        aksiyonlar.moveToElement(register).click().build().perform();
        WebElement male= driver.findElement(By.id("gender-male"));
        aksiyonlar.moveToElement(male).click().build().perform();
        WebElement first= driver.findElement(By.id("FirstName"));
        first.sendKeys("Sdet");
        WebElement last= driver.findElement(By.id("LastName"));
        last.sendKeys("Tears");
        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("sdettears@gmail.com");
        WebElement pass= driver.findElement(By.id("Password"));
        pass.sendKeys("Pass1234");
        WebElement cpass= driver.findElement(By.id("ConfirmPassword"));
        cpass.sendKeys("Pass1234");
        WebElement rbtn= driver.findElement(By.id("register-button"));
        aksiyonlar.moveToElement(rbtn).click().build().perform();
        WebElement control= driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue(control.getText().contains("completed"));
        WaitClose();


    }
    //

}
