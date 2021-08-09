package UItests.groups;

import UItests.BaseTest;

import dataObjects.newGroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreate extends BaseTest {
    newGroupData newGroup = new newGroupData("xany valid group name", "test description 1", "test description second 2");

    @Test
    public void testCreateGroup() {
        appmngr.navHelp.openGroupPage();
        int totalGroups = appmngr.groupHelp.getExistingGroupsCount();
        List<newGroupData> groupsBefore = appmngr.groupHelp.getGroupNames();
        appmngr.groupHelp.selectCreateNewGroup();
        appmngr.groupHelp.fillInRequiredNewGroupFields(newGroup);
        appmngr.groupHelp.clickSubmitBtn();
        appmngr.navHelp.openGroupPage();
        Assert.assertEquals(appmngr.groupHelp.getExistingGroupsCount(), totalGroups + 1);

//        int max = 0;
//        for (newGroupData i : groupsBefore){
//            if (i.getId() > max){
//                max = i.getId();
//            }
//        }
//        max++;
        int max2 = groupsBefore.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        max2++;
        newGroup.setId(max2);
        groupsBefore.add(newGroup);

        List<newGroupData> groupsAfter = appmngr.groupHelp.getGroupNames();

        Assert.assertEquals(groupsBefore, groupsAfter);
    }

}
