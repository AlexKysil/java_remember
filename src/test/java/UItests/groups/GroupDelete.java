package UItests.groups;

import UItests.BaseTest;
import org.testng.annotations.Test;


public class GroupDelete extends BaseTest {

  @Test
  public void testGroupDeletion() {
    openGroupPage();
    selectFirstGroupInList();
    clickDeleteGroupBtn();
    return2GroupPage();
  }
}
