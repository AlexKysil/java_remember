package UItests.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

public class ApplicationManager {
    public ContactHelper contactHelp;
    public NavigationHelper navHelp;
    public static WebDriver driver;
    public SessionHelper sessionHelp;
    public String browser;
    final String  expected_url = "http://localhost:8080/addressbook/";
    public GroupHelper groupHelp;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public ApplicationManager() {
        this.browser = BrowserType.CHROME;
    }

    public void init() {
        boolean wasdDriver = driver == null;
        if (driver == null) {
            if (browser.equals(BrowserType.CHROME)) {
                WebDriverManager.chromedriver().setup();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                WebDriverManager.firefoxdriver().setup();
            }

            if (browser.equals(BrowserType.CHROME)) {
                driver = new ChromeDriver();
            } else if (browser.equals(BrowserType.FIREFOX)) {
                driver = new FirefoxDriver();
            } else {
                driver = new ChromeDriver();
            }
        }

        groupHelp = new GroupHelper(driver);
        navHelp = new NavigationHelper(driver);
        contactHelp = new ContactHelper(driver);
        sessionHelp = new SessionHelper(driver);

        if(wasdDriver==true) {
            driver.get(expected_url);
            sessionHelp.login("admin", "secret");
        }
    }


    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public ContactHelper getContactHelp() {
        return contactHelp;
    }
}
