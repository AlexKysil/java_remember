package UItests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {
    public ContactHelper contactHelp;
    public NavigationHelper navHelp;
    public WebDriver driver;
    public SessionHelper sessionHelp;
    public String browser;
    String expected_url = "http://localhost:8080/addressbook/";
    public GroupHelper groupHelp;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else  {
            driver = new ChromeDriver();
        }
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
