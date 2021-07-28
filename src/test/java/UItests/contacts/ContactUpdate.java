package UItests.contacts;

import UItests.BaseTest;
import dataObjects.newContactData;
import org.testng.annotations.Test;

public class ContactUpdate extends BaseTest {
    @Test
    public void testContactDeletion() {
        appmngr.contactHelp.clickContactEdit();
        appmngr.getContactHelp().fillInNewContactFields(new newContactData("UpdatedFirstName", "UpdatedLastName", "UpdatedNickName", "+380009999562", "updated_any_valid_test_email@yopmail.com"));
        appmngr.contactHelp.clickUpdateContactBTN();
    }
}
