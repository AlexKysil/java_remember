package UItests.contacts;

import UItests.BaseTest;
import org.testng.annotations.Test;

public class ContactDelete extends BaseTest {

    @Test
    public void testContactDeletion(){
        appmngr.contactHelp.selectFirstContactInList();
        appmngr.contactHelp.clickDeleteContactBTN();
        appmngr.contactHelp.confirmContactDeletion();
    }
}
