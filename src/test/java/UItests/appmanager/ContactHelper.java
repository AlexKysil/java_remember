package UItests.appmanager;

import dataObjects.newContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends BaseHelper {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void fillInNewContactFields(newContactData newContactData) {
        clearAndInput(By.name("firstname"),newContactData.getFirstName());
        clearAndInput(By.name("lastname"),newContactData.getLastName());
        clearAndInput(By.name("nickname"),newContactData.getNickName());
        clearAndInput(By.name("mobile"),newContactData.getMobile());
        clearAndInput(By.name("email"),newContactData.getEmail());
    }

    public void openCreateNewContact() {
        click(By.xpath("//a[text()='add new']"));
    }
}
