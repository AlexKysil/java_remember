package UItests.appmanager;

import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends BaseHelper {

    public GroupHelper(WebDriver driver) {
        super(driver);
    }

    public void fillInRequiredNewGroupFields(newGroupData newGroupData) {
        clearAndInput(By.name("group_name"), newGroupData.getGroupName());
        clearAndInput(By.name("group_header"), newGroupData.getGroupDescription1());
        clearAndInput(By.name("group_footer"), newGroupData.getGroupDescription2());
    }

    public void selectCreateNewGroup() {
        click(By.name("new"));
    }

    public void return2GroupPage() {
        click(By.linkText("group page"));
    }

    public void clickDeleteGroupBtn() {
        click(By.name("delete"));
    }

    public void selectFirstGroupInList() {
        click(By.name("selected[]"));
    }

    public void clickEditGroupBTN() {
        click(By.name("edit"));
    }

    public void clickUpdateGroupBTN() {
        click(By.name("update"));
    }

    public void createGroup(newGroupData groupData){
        selectCreateNewGroup();
        fillInRequiredNewGroupFields(groupData);
        clickSubmitBtn();
    }

    public int getExistingGroupsCount(){
        return driver.findElements(By.name("selected[]")).size();
    }

}
