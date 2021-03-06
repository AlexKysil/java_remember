package UItests.groups;

import UItests.BaseTest;
import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupEdit extends BaseTest {

    newGroupData newGroup = new newGroupData("Group2BeModified", null, null);
    newGroupData updatedGroup = new newGroupData("updatedGroup", "updated description", "updatedDescription 2");

    @BeforeMethod
    public void preconditions(){
        appmngr.navHelp.openGroupPage();
        if (! appmngr.groupHelp.isElementPresent(By.name("selected[]"))) {
            appmngr.groupHelp.createGroup(newGroup);
        }
    }

    @Test
    public void testGroupUpdate(){
        appmngr.navHelp.openGroupPage();
        int totalGroups = appmngr.groupHelp.getExistingGroupsCount();
        List<newGroupData> groupsBefore = appmngr.groupHelp.getGroupNames();
        appmngr.groupHelp.selectGroupByIndex(totalGroups-1);
        appmngr.groupHelp.clickEditGroupBTN();
        appmngr.groupHelp.fillInRequiredNewGroupFields(updatedGroup);
        appmngr.groupHelp.clickUpdateGroupBTN();
        appmngr.navHelp.openGroupPage();
        int totalGroupsAfterChanges = appmngr.groupHelp.getExistingGroupsCount();
        Assert.assertEquals(totalGroups, totalGroupsAfterChanges);

        updatedGroup.setId(groupsBefore.get(totalGroups -1).getId());
        groupsBefore.remove(totalGroups-1);
        groupsBefore.add(updatedGroup);

        List<newGroupData> groupsAfter = appmngr.groupHelp.getGroupNames();

//        Assert.assertEquals(new HashSet<Object>(groupsBefore), new HashSet<Object>(groupsAfter));

        Comparator<? super newGroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        groupsBefore.sort(byID);
        groupsAfter.sort(byID);

        Assert.assertEquals(groupsBefore, groupsAfter);
    }
}
