package UItests.groups;

import UItests.BaseTest;
import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;


public class GroupDelete extends BaseTest {

  newGroupData newGroup = new newGroupData("Group2BeDeleted", null, null);

  @BeforeTest
  public void preconditions(){
    appmngr.navHelp.openGroupPage();
    if (! appmngr.groupHelp.isElementPresent(By.name("selected[]"))) {
      appmngr.groupHelp.createGroup(newGroup);
    }
  }

  @Test
  public void testGroupDeletion() {
    appmngr.navHelp.openGroupPage();
    int totalGroups = appmngr.groupHelp.getExistingGroupsCount();
    List<newGroupData> before = appmngr.groupHelp.getGroupNames();
    appmngr.groupHelp.selectFirstGroupInList();
    appmngr.groupHelp.clickDeleteGroupBtn();
    appmngr.groupHelp.return2GroupPage();
    Assert.assertEquals(appmngr.groupHelp.getExistingGroupsCount(), totalGroups - 1);

    before.remove(0);
    List<newGroupData> after = appmngr.groupHelp.getGroupNames();

    Assert.assertEquals(before, after);
  }
}
