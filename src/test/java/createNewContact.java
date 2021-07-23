import dataObjects.newContactData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class createNewContact {
    private WebDriver driver;
    String expected_url = "http://localhost:8080/addressbook/";

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

    @Test
    public void testCreateNewContact() {
        openCreateNewContact();
        fillInNewContactFields(new newContactData("FirstName", "LastName", "NickName", "+380009999561", "any_valid_test_email@yopmail.com"));
        clickSubmitBtn();
    }

    private void fillInNewContactFields(newContactData newContactData) {
        driver.findElement(By.name("firstname")).sendKeys(newContactData.getFirstName());
        driver.findElement(By.name("lastname")).sendKeys(newContactData.getLastName());
        driver.findElement(By.name("nickname")).sendKeys(newContactData.getNickName());
        driver.findElement(By.name("mobile")).sendKeys(newContactData.getMobile());
        driver.findElement(By.name("email")).sendKeys(newContactData.getEmail());
    }

    private void openCreateNewContact() {
        driver.findElement(By.xpath("//a[text()='add new']")).click();
    }

    private void clickSubmitBtn() {
        driver.findElement(By.name("submit")).click();
    }
}
