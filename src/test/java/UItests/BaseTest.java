package UItests;

import UItests.appmanager.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public static final ApplicationManager appmngr = new ApplicationManager();

    @BeforeTest
    public void setUp() {
        appmngr.init();
    }

    @AfterTest
    public void teardown() {
        appmngr.stop();
    }

}
