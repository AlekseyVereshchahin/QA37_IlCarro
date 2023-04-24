package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd;

    HelperUser helperUser;
    HelperCar helperCar;

    public void init() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://ilcarro.web.app/search");
//      wd.navigate().back();

        helperUser = new HelperUser(wd);
        helperCar = new HelperCar(wd);

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void stop() {
        wd.quit();

    }

    public HelperCar getHelperCar() {
        return helperCar;
    }
}
