package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel","4/27/2023","4/28/2023");
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

//    @Test
//    public void searchAnyPeriodSuccess(){
//        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel","12/27/2023","2/28/2024");
//        app.getHelperCar().submit();
//        app.getHelperCar().pause(10000);
//        Assert.assertTrue(app.getHelperCar().isListOfCarAppeared());
//
//    }

}
