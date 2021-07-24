package UItests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    WebDriver driver;

    public NavigationHelper(WebDriver driver){
        this.driver = driver;
    }

    public void openGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }
}
