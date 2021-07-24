package UItests.appmanager;

import dataObjects.newContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper {
    WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInNewContactFields(newContactData newContactData) {
        driver.findElement(By.name("firstname")).sendKeys(newContactData.getFirstName());
        driver.findElement(By.name("lastname")).sendKeys(newContactData.getLastName());
        driver.findElement(By.name("nickname")).sendKeys(newContactData.getNickName());
        driver.findElement(By.name("mobile")).sendKeys(newContactData.getMobile());
        driver.findElement(By.name("email")).sendKeys(newContactData.getEmail());
    }

    public void openCreateNewContact() {
        driver.findElement(By.xpath("//a[text()='add new']")).click();
    }
}
