package UItests.contacts;

import UItests.BaseTest;
import dataObjects.newContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

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
    public void testContactEdition() {
        appmngr.navHelp.openHomePage();
        List<newContactData> contactsBefore = appmngr.contactHelp.getCurrentContactsList();
        newContactData object2Delete = contactsBefore.get(contactsBefore.size() -1);

        appmngr.contactHelp.clickContactEdit(object2Delete.getId());
        appmngr.getContactHelp().fillInNewContactFields(contactUpdate);
        appmngr.contactHelp.clickUpdateContactBTN();

        appmngr.navHelp.openHomePage();
        List<newContactData> contactsAfter = appmngr.contactHelp.getCurrentContactsList();

        contactsBefore.remove(object2Delete);
        contactsBefore.add(new newContactData(contactUpdate.getFirstName(), contactUpdate.getLastName(), object2Delete.getId()));

        Comparator<? super newContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);

        Assert.assertEquals(contactsBefore, contactsAfter);
    }
}
