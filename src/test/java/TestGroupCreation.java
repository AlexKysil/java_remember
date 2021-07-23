import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

public class TestGroupCreation {
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
  }
  @AfterTest
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
  @Test
  public void TestAddressbookCreateGroup() {
    driver.manage().window().setSize(new Dimension(1920, 1025));
    driver.findElement(By.name("user")).sendKeys("admin");
    driver.findElement(By.name("pass")).click();
    driver.findElement(By.name("pass")).sendKeys("secret");
    driver.findElement(By.cssSelector("input:nth-child(7)")).click();
    driver.findElement(By.linkText("groups")).click();
    driver.findElement(By.name("new")).click();
    driver.findElement(By.name("group_name")).click();
    driver.findElement(By.name("group_name")).sendKeys("any valid group name");
    driver.findElement(By.name("group_header")).click();
    driver.findElement(By.name("group_header")).sendKeys("test description 1");
    driver.findElement(By.name("group_footer")).click();
    driver.findElement(By.name("group_footer")).sendKeys("test description second 2");
    driver.findElement(By.name("submit")).click();
  }
}
