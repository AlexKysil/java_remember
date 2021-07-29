package UItests.groups;

import UItests.BaseTest;
import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupEdit extends BaseTest {

    newGroupData newGroup = new newGroupData("Group2BeModified", null, null);
    newGroupData updatedGroup = new newGroupData("updatedGroup", "updated description", "updatedDescription 2");

    @BeforeTest
    public void preconditions(){
        appmngr.navHelp.openGroupPage();
        if (! appmngr.groupHelp.isElementPresent(By.name("selected[]"))) {
            appmngr.groupHelp.createGroup(newGroup);
        }
    }

    @Test
    public void testGroupUpdate(){
        appmngr.navHelp.openGroupPage();
        appmngr.groupHelp.selectFirstGroupInList();
        appmngr.groupHelp.clickEditGroupBTN();
        appmngr.groupHelp.fillInRequiredNewGroupFields(updatedGroup);
        appmngr.groupHelp.clickUpdateGroupBTN();
    }
}
