package UItests.appmanager;

import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroupByIndex(int index){
        if(index >= 0){
            driver.findElements(By.name("selected[]")).get(index).click();
        }
    }

    public List<newGroupData> getGroupNames(){
        List<newGroupData> groups = new ArrayList<newGroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));

        for (WebElement element : elements){
            String name = element.getText();
            String id = element.getAttribute("value");
            newGroupData new_group = new newGroupData(id, name, null, null);
            groups.add(new_group);
        }

        return groups;
    }

}
