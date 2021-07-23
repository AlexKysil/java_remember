package UItests.groups;

import UItests.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import dataObjects.newGroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupCreate extends BaseTest {

    @Test
    public void testCreateGroup() {
        openGroupPage();
        selectCreateNewGroup();
        fillInRequiredNewGroupFields(new newGroupData("any valid group name", "test description 1", "test description second 2"));
        clickSubmitBtn();
    }

}
