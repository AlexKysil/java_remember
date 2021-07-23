package UItests;

import dataObjects.newContactData;
import dataObjects.newGroupData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    String expected_url = "http://localhost:8080/addressbook/";
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(expected_url);
        login("admin", "secret");
    }

    private void login(String account, String password) {
        driver.manage().window().setSize(new Dimension(1920, 1025));
        driver.findElement(By.name("user")).sendKeys(account);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void clickSubmitBtn() {
        driver.findElement(By.name("submit")).click();
    }

    protected void fillInRequiredNewGroupFields(newGroupData newGroupData) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys(newGroupData.getGroupName());
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).sendKeys(newGroupData.getGroupDescription1());
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).sendKeys(newGroupData.getGroupDescription2());
    }

    protected void selectCreateNewGroup() {
        driver.findElement(By.name("new")).click();
    }

    protected void openGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void fillInNewContactFields(newContactData newContactData) {
        driver.findElement(By.name("firstname")).sendKeys(newContactData.getFirstName());
        driver.findElement(By.name("lastname")).sendKeys(newContactData.getLastName());
        driver.findElement(By.name("nickname")).sendKeys(newContactData.getNickName());
        driver.findElement(By.name("mobile")).sendKeys(newContactData.getMobile());
        driver.findElement(By.name("email")).sendKeys(newContactData.getEmail());
    }

    public void openCreateNewContact() {
        driver.findElement(By.xpath("//a[text()='add new']")).click();
    }

    protected void return2GroupPage() {
      driver.findElement(By.linkText("group page")).click();
    }

    protected void clickDeleteGroupBtn() {
      driver.findElement(By.name("delete")).click();
    }

    protected void selectFirstGroupInList() {
      driver.findElement(By.name("selected[]")).click();
    }
}
