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

    public void fillLoginForm(String email, String password){
        type(By.cssSelector("#email"),email);
        type(By.cssSelector("#password"),password);
    }

    public void submitLogin(){
        click(By.cssSelector("button[type='submit']"));
        click(By.cssSelector("button.positive-button.ng-star-inserted"));

    }

    public boolean isLogged(){
        return isElementPresent(By.cssSelector(".ng-star-inserted[href='logout']"));
    }

    public void logout(){
        click(By.cssSelector(".ng-star-inserted[href='logout']"));
    }

}
