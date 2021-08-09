package UItests.contacts;

import UItests.BaseTest;
import dataObjects.newContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactDelete extends BaseTest {

      newContactData newContact = new newContactData("Contact2BeDeleted", null, null, null, null, null);

    @BeforeMethod
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
        List<newContactData> contactsBefore = appmngr.contactHelp.getCurrentContactsList();
        appmngr.contactHelp.selectFirstContactInList();
        appmngr.contactHelp.clickDeleteContactBTN();
        appmngr.contactHelp.confirmContactDeletion();
        appmngr.navHelp.openHomePage();

        List<newContactData> contactsAfter = appmngr.contactHelp.getCurrentContactsList();

        contactsBefore.remove(0);

        Comparator<? super newContactData> byID = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        contactsBefore.sort(byID);
        contactsAfter.sort(byID);

        Assert.assertEquals(contactsBefore, contactsAfter);
    }
}
