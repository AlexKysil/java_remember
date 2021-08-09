package UItests.contacts;

import UItests.BaseTest;
import dataObjects.newContactData;
import dataObjects.newGroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreate extends BaseTest {
    newContactData contact2Create = new newContactData("FirstName", "LastName", "NickName", "+380009999561", "any_valid_test_email@yopmail.com", "aloha");
    String expectedGroupName = "aloha";

    @BeforeMethod
    public void preconditions(){
        appmngr.navHelp.openGroupPage();
        List<newGroupData> currentGroups = appmngr.groupHelp.getGroupNames();
        List<String> names = new ArrayList<String>();
        for (newGroupData gd : currentGroups){
            names.add(gd.getGroupName());
        }

        boolean isGroupExist = false;
        for (String n : names){
            if (!isGroupExist){
                if (n.equals(expectedGroupName)){
                    isGroupExist = true;
                }
            }
        }

        if(!isGroupExist){
            appmngr.groupHelp.createGroup(new newGroupData(expectedGroupName, null, null));
        }

    }


    @Test
    public void testCreateNewContact() {
        appmngr.navHelp.openHomePage();
        List<newContactData> contactsBefore = appmngr.contactHelp.getCurrentContactsList();
        appmngr.getContactHelp().openCreateNewContact();
        appmngr.getContactHelp().fillInNewContactFields(contact2Create);
        appmngr.contactHelp.clickSubmitBtn();
        appmngr.navHelp.openHomePage();
        List<newContactData> contactsAfter = appmngr.contactHelp.getCurrentContactsList();

        int maxID = contactsBefore.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId();
        maxID++;
        contactsBefore.add(new newContactData(contact2Create.getFirstName(), contact2Create.getLastName(), maxID));

        Comparator<? super newContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        contactsBefore.sort(byId);
        contactsAfter.sort(byId);

        Assert.assertEquals(contactsBefore, contactsAfter);

    }
}
