package UItests;

import UItests.appmanager.ApplicationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public final ApplicationManager appmngr = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass
    public void setupClass() {
        if (appmngr.browser == BrowserType.CHROME) {
            WebDriverManager.chromedriver().setup();
        } else if (appmngr.browser == BrowserType.FIREFOX) {
            WebDriverManager.firefoxdriver().setup();
        }

    }

    @BeforeTest
    public void setUp() {
        appmngr.init();
    }

    @AfterTest
    public void teardown() {
        appmngr.stop();
    }

}
