package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public String getMessage(){
        pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void closeWindow() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.cssSelector(".ng-star-inserted[href='logout']"));
    }

    public void logout() {
        click(By.cssSelector(".ng-star-inserted[href='logout']"));
    }

}
