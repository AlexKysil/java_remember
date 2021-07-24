package UItests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    public ContactHelper contactHelp;
    public NavigationHelper navHelp;
    public WebDriver driver;
    public SessionHelper sessionHelp;

    String expected_url = "http://localhost:8080/addressbook/";
    public GroupHelper groupHelp;

    public void init() {
        driver = new ChromeDriver();
        groupHelp = new GroupHelper(driver);
        navHelp = new NavigationHelper(driver);
        contactHelp = new ContactHelper(driver);
        sessionHelp = new SessionHelper(driver);

        driver.get(expected_url);
        sessionHelp.login("admin", "secret");
    }


    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void clickSubmitBtn() {
        driver.findElement(By.name("submit")).click();
    }

    public ContactHelper getContactHelp() {
        return contactHelp;
    }
}
