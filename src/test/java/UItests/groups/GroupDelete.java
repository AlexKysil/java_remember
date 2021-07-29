package UItests.groups;

import UItests.BaseTest;
import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


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
    appmngr.groupHelp.selectFirstGroupInList();
    appmngr.groupHelp.clickDeleteGroupBtn();
    appmngr.groupHelp.return2GroupPage();
  }
}
