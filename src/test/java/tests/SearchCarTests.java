package tests;

import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Rehovot, Israel","4/27/2023","4/29/2023");
        app.getHelperCar().submit();
        app.getHelperCar().pause(10000);
        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }

    @Test
    public void searchCurrentYearSuccess(){
        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel","6/30/2023","10/28/2023");
        app.getHelperCar().submit();
        app.getHelperCar().pause(10000);
        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }

    @Test
    public void searchAnyPeriodSuccess(){
        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel","1/27/2024","3/29/2024");
        app.getHelperCar().submit();
        app.getHelperCar().pause(10000);
        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
    }



    @Test
    public void negativeSearch(){
        app.getHelperCar().searchNotValidPeriod("Tel Aviv, Israel","1/10/2023","10/10/2023");
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperCar().isYallaButtonNotActive());
        Assert.assertEquals(app.getHelperUser().getErrorDateText(),"You can't pick date before today");
    }




    @BeforeMethod
    public void navigateByLogo(){
        app.getHelperCar().click(By.cssSelector(".logo"));
    }

}
