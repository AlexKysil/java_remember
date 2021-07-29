package UItests.contacts;

import UItests.BaseTest;
import dataObjects.newContactData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactDelete extends BaseTest {

      newContactData newContact = new newContactData("Contact2BeDeleted", null, null, null, null, null);

    @BeforeTest
    public void preconditions(){
        appmngr.navHelp.openHomePage();
        if (! appmngr.contactHelp.isElementPresent(By.name("selected[]"))) {
            appmngr.getContactHelp().openCreateNewContact();
            appmngr.contactHelp.createContact(newContact);
        }
    }

    @Test
    public void testContactDeletion(){
        appmngr.navHelp.openHomePage();
        appmngr.contactHelp.selectFirstContactInList();
        appmngr.contactHelp.clickDeleteContactBTN();
        appmngr.contactHelp.confirmContactDeletion();
    }
}
