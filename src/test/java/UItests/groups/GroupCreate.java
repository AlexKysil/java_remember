package UItests.groups;

import UItests.BaseTest;

import dataObjects.newGroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreate extends BaseTest {

    @Test
    public void testCreateGroup() {
        appmngr.navHelp.openGroupPage();
        int totalGroups = appmngr.groupHelp.getExistingGroupsCount();
        appmngr.groupHelp.selectCreateNewGroup();
        appmngr.groupHelp.fillInRequiredNewGroupFields(new newGroupData("any valid group name", "test description 1", "test description second 2"));
        appmngr.groupHelp.clickSubmitBtn();
        appmngr.navHelp.openGroupPage();
        Assert.assertEquals(appmngr.groupHelp.getExistingGroupsCount(), totalGroups + 1);
    }

}
