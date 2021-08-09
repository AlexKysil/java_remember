package UItests.appmanager;

import dataObjects.newContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

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

        if (isElementPresent(By.name("new_group")) && newContactData.getGroupName() != null) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(newContactData.getGroupName());
        }
    }

    public void openCreateNewContact() {
        click(By.xpath("//a[text()='add new']"));
    }
    public void selectFirstContactInList() {
        click(By.name("selected[]"));
    }

    public void clickDeleteContactBTN(){
        click(By.cssSelector("[value='Delete']"));
    }

    public void confirmContactDeletion(){
        driver.switchTo().alert().accept();
    }

    public void clickContactEdit() {
        click(By.cssSelector("[title='Edit']"));
    }

    public void clickUpdateContactBTN() {
        click(By.cssSelector("[value='Update']"));
    }

    public void createContact(newContactData newContact) {
        openCreateNewContact();
        fillInNewContactFields(newContact);
        clickSubmitBtn();
    }

    public List<newContactData> getCurrentContactsList() {
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@name='entry']"));
        List<newContactData> contacts = new ArrayList<newContactData>();
        for (WebElement element : elements){
            String Lastname = element.findElement(By.xpath("td[2]")).getText();
            String FirstName = element.findElement(By.xpath("td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("id"));
            newContactData contact = new newContactData(FirstName, Lastname, id);
            contacts.add(contact);
        }
        return contacts;
    }

}
