import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import java.io.File;

/**
 * Created by OKOH on 15/12/2018.
 */
public class TestBase {
    public static WebDriver driver = null;
    public static WebDriverWait wait;

    public void initiate() {
        if(driver == null) {
            File classpathRoot = new File(System.getProperty("user.dir"));
            File chromeDriver = new File(classpathRoot, "browserDriver/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, 20);
            driver.manage().window().maximize();
        }
        driver.get("https://www.expedia.com");
    }

    @AfterSuite
    public void tearDown() {
        //driver.quit();
    }
}
