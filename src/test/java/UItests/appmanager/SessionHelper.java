package UItests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends BaseHelper {

    public SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String account, String password) {
        driver.manage().window().maximize();
        clearAndInput(By.name("user"), account);
        clearAndInput(By.name("pass"), password);
        click(By.cssSelector("input:nth-child(7)"));
    }
}
