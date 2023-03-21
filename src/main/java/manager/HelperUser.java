package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("a[ng-reflect-router-link='login']"));

    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }

    public void submitLogin() {
        click(By.cssSelector("button[type='submit']"));

    }

    public String getMessage() {
        //pause(2000);
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));

        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void closeWindow() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text() = ' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text() = ' Logout ']"));
    }

}
