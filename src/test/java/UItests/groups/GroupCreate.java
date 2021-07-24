package UItests.groups;

import UItests.BaseTest;

import dataObjects.newGroupData;
import org.testng.annotations.Test;

public class GroupCreate extends BaseTest {

    @Test
    public void testCreateGroup() {
        appmngr.openGroupPage();
        appmngr.selectCreateNewGroup();
        appmngr.fillInRequiredNewGroupFields(new newGroupData("any valid group name", "test description 1", "test description second 2"));
        appmngr.clickSubmitBtn();
    }

}
