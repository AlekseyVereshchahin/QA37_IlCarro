package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    public void fillLoginForm(User user) {
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }





    public void closeWindow() {
        if (isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text() = ' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text() = ' Logout ']"));
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));
        WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = element.isEnabled();
        return res && !result;
    }


    //______________________Registration____________

    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {//not work with one stroke sign
        //  click(By.id("terms-of-use")); //не работает --> 0х0
        click(By.cssSelector("label[for='terms-of-use']"));

//        JavascriptExecutor js = (JavascriptExecutor) wd;
//        js.executeScript("document.querySelector('#terms-of-use).click();");

    }

    public void checkPolicyXY() {
//        wd.manage().window().getSize(); //get size of screen
//        System.out.println("Wight screen-->" + size.getWight());
       if(!wd.findElement(By.id("terms-of-use")).isSelected())
       {
           WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
            Rectangle rect = label.getRect();
            int w = rect.getWidth();

            int xOffSet = -w / 2;
            Actions actions = new Actions(wd);
            actions.moveToElement(label, xOffSet, 0).click().release().perform();
        }
    }

    public String getErrorRegisteredUser() {
        return wd.findElement(By.cssSelector("h2.message")).getText();

    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        closeWindow();
    }
}




