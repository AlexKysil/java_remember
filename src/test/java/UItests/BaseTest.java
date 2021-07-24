package UItests;

import UItests.appmanager.ApplicationManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public final ApplicationManager appmngr = new ApplicationManager();

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
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
