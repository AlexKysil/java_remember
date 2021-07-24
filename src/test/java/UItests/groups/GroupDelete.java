package UItests.groups;

import UItests.BaseTest;
import org.testng.annotations.Test;


public class GroupDelete extends BaseTest {

  @Test
  public void testGroupDeletion() {
    appmngr.navHelp.openGroupPage();
    appmngr.groupHelp.selectFirstGroupInList();
    appmngr.groupHelp.clickDeleteGroupBtn();
    appmngr.groupHelp.return2GroupPage();
  }
}
