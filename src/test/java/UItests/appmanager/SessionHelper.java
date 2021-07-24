package UItests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper {
    WebDriver driver;

    public SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String account, String password) {
        driver.manage().window().maximize();
        driver.findElement(By.name("user")).sendKeys(account);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }
}
