package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("amaverik281@gmail.com","Aaaaaaa1!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("amaverik281@gmail.com","Aaaaaaa1!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}
