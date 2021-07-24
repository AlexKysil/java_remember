package UItests.groups;

import UItests.BaseTest;
import org.testng.annotations.Test;


public class GroupDelete extends BaseTest {

  @Test
  public void testGroupDeletion() {
    appmngr.openGroupPage();
    appmngr.selectFirstGroupInList();
    appmngr.clickDeleteGroupBtn();
    appmngr.return2GroupPage();
  }
}
