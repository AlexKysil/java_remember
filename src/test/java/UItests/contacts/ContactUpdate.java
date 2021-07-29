package UItests.contacts;

import UItests.BaseTest;
import dataObjects.newContactData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactUpdate extends BaseTest {

    newContactData newContact = new newContactData("Contact2BeUpdated", null, null, null, null, null);
    newContactData contactUpdate = new newContactData("UpdatedFirstName", "UpdatedLastName", "UpdatedNickName", "+380009999562", "updated_any_valid_test_email@yopmail.com", null);

    @BeforeTest
    public void preconditions(){
        appmngr.navHelp.openHomePage();
        if (! appmngr.contactHelp.isElementPresent(By.name("selected[]"))) {
            appmngr.getContactHelp().openCreateNewContact();
            appmngr.contactHelp.createContact(newContact);
        }
    }

    @Test
    public void testContactDeletion() {
        appmngr.navHelp.openHomePage();
        appmngr.contactHelp.clickContactEdit();
        appmngr.getContactHelp().fillInNewContactFields(contactUpdate);
        appmngr.contactHelp.clickUpdateContactBTN();
    }
}
