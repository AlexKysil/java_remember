package UItests.appmanager;

import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper {
    WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInRequiredNewGroupFields(newGroupData newGroupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(newGroupData.getGroupName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(newGroupData.getGroupDescription1());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(newGroupData.getGroupDescription2());
    }

    public void selectCreateNewGroup() {
        driver.findElement(By.name("new")).click();
    }

    public void return2GroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    public void clickDeleteGroupBtn() {
        driver.findElement(By.name("delete")).click();
    }

    public void selectFirstGroupInList() {
        driver.findElement(By.name("selected[]")).click();
    }
}
