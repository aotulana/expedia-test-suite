import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by OKOH on 15/12/2018.
 */
public class WebpageTest extends TestBase {

    private static String pageTitle;

    @BeforeMethod
    public void setUp() {
        initiate();
    }

    @Test
    public void when_URLIsEntered_Return_RightPageTitle() {
        pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Expedia Travel: Search Hotels, Cheap Flights, Car Rentals & Vacations");
    }
}
