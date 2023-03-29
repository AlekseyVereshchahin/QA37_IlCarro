package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int z = (int) (System.currentTimeMillis() / 1000) ; //give random number

        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("pop" + z + "@gmail.com")
                .setPassword("Pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(10000);
//        app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        app.getHelperUser().pause(5000);

        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");

    }

    @Test
    public void registrationEmptyName() {
        Random random = new Random();
        int z = (int) (System.currentTimeMillis() / 1000) ; //give random number

        User user = new User()
                .setFirstName("")
                .setLastName("Hor")
                .setEmail("pop" + z + "@gmail.com")
                .setPassword("Pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(10000);
//      app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().pause(10000);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationEmptyLastname() {
        Random random = new Random();
        int z = (int) (System.currentTimeMillis() / 1000) ; //give random number

        User user = new User()
                .setFirstName("Mark")
                .setLastName("")
                .setEmail("pop" + z + "@gmail.com")
                .setPassword("Pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(10000);
//      app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().pause(5000);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationEmptyEmail() {
        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("")
                .setPassword("Pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(10000);
//      app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().pause(10000);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationIncorrectEmail() {
        int z = (int) (System.currentTimeMillis() / 1000) ; //give random number
        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("pop" + z + "gmail.com")
                .setPassword("Pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(10000);
//      app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().pause(5000);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationEmptyPassword() {
        Random random = new Random();
        int z = (int) (System.currentTimeMillis() / 1000) ; //give random number

        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("pop" + z + "@gmail.com")
                .setPassword("");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(5000);
//      app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().pause(5000);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationIncorrectPassword() {
        int z = (int) (System.currentTimeMillis() / 1000) ; //give random number
        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("pop" + z + "@gmail.com")
                .setPassword("pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(10000);
//      app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().pause(5000);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationEmptyCheckbox() {
        Random random = new Random();
        int z = (int) (System.currentTimeMillis() / 1000) ; //give random number

        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("pop" + z + "@gmail.com")
                .setPassword("Pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().pause(5000);

        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
    }

    @Test
    public void registrationRegisteredUser() {
        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("amaverik281@gmail.com")
                .setPassword("Aaaaaaa1!");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().pause(5000);
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().pause(5000);
        app.getHelperUser().submit();
        app.getHelperUser().pause(20000);
        Assert.assertEquals(app.getHelperUser().getErrorRegisteredUser(), "\"User already exists\"");
    }

    @AfterMethod
    public void postCondition() {
        app.getHelperUser().closeWindow();
    }
}
