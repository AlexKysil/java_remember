package UItests.contacts;

import UItests.BaseTest;
import dataObjects.newContactData;
import org.testng.annotations.Test;

public class ContactCreate extends BaseTest {

    @Test
    public void testCreateNewContact() {
        appmngr.openCreateNewContact();
        appmngr.fillInNewContactFields(new newContactData("FirstName", "LastName", "NickName", "+380009999561", "any_valid_test_email@yopmail.com"));
        appmngr.clickSubmitBtn();
    }
}
