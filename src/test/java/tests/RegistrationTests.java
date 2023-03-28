package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void RegistrationSuccess(){

        Random random = new Random();
        int i = random.nextInt(1000); //give random number
        int z = (int) (System.currentTimeMillis() / 1000) / 3600; //give random number

        User user = new User()
                .setFirstName("Mark")
                .setLastName("Hor")
                .setEmail("pop" + i + "@gmail.com")
                .setPassword("Pop12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
//        app.getHelperUser().checkPolicy(); //not work
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

    }

    @AfterMethod
    public void postCondition()  {
        app.getHelperUser().closeWindow();
    }
}
