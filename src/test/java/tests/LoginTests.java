package tests;

import manager.HelperUser;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }
    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("amaverik281@gmail.com","Aaaaaaa1!");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().closeWindow();

    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("amaverik281@gmail.com","Aaaaaaa1!");
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
        app.getHelperUser().closeWindow();


    }

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("amaverik281gmail.com","Aaaaaaa1!");
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[contains(text(),'look like email')]")));


    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("amaverik281@gmail.com","Aaaaaaa1");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//h2[contains(text(),'Login or Password incorrect')]")));
        app.getHelperUser().closeWindow();

    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("pop@gmail.com","PopAaaaaaaA1!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//h2[contains(text(),'Login or Password incorrect')]")));
        app.getHelperUser().closeWindow();

    }

//    @AfterMethod
//    public void postCondition(){
//        app.getHelperUser().closeWindow();
//    }
}
