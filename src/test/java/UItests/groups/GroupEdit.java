package UItests.groups;

import UItests.BaseTest;
import dataObjects.newGroupData;
import org.testng.annotations.Test;

public class GroupEdit extends BaseTest {

    @Test
    public void testGroupUpdate(){
        appmngr.navHelp.openGroupPage();
        appmngr.groupHelp.selectFirstGroupInList();
        appmngr.groupHelp.clickEditGroupBTN();
        appmngr.groupHelp.fillInRequiredNewGroupFields(new newGroupData("updatedGroup", "updated description", "updatedDescription 2"));
        appmngr.groupHelp.clickUpdateGroupBTN();
    }
}
