import Utlity.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_204_Login extends BaseDriver {
    @Test
    public void US_204() {

        driver.get("https://demowebshop.tricentis.com/");
        Actions action = new Actions(driver);
        WebElement logIn = driver.findElement(By.xpath("//*[text()='Log in']"));
        action.moveToElement(logIn).click().build().perform();
        WebElement email = driver.findElement(By.xpath("//*[@id='Email']"));
        email.sendKeys("sdettears@gmail.com");
        WebElement password = driver.findElement(By.xpath("//*[@id='Password']"));
        password.sendKeys("Pass1234");
        WebElement logInBtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        action.moveToElement(logInBtn).click().build().perform();
        WebElement check = driver.findElement(By.xpath("//a[text()='sdettears@gmail.com']"));
        Assert.assertTrue(check.getText().equals("sdettears@gmail.com"));
        WaitClose();

    }

}
