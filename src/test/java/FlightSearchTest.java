import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by aotulana on 12/20/2018.
 */
public class FlightSearchTest extends TestBase {

    @BeforeTest
    public void setUp() {
        initiate();
        driver.findElement(By.id("tab-flight-tab-hp")).click();
    }

    @Test
    public void when_RoundTripIsSelected_Returns_ReturningDate() throws InterruptedException {
        driver.findElement(By.id("flight-type-roundtrip-label-hp-flight")).click();
        driver.findElement(By.id("flight-origin-hp-flight")).sendKeys("Murtala");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(@data-value,'Lagos, Nigeria (LOS-Murtala Muhammed Intl.)')]")));
        driver.findElement(By.xpath(".//a[contains(@data-value,'Lagos, Nigeria (LOS-Murtala Muhammed Intl.)')]")).click();
        driver.findElement(By.id("flight-destination-hp-flight")).sendKeys("Amsterdam");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[contains(@data-value,'Amsterdam, Netherlands (AMS-Schiphol)')]")));
        driver.findElement(By.xpath(".//a[contains(@data-value,'Amsterdam, Netherlands (AMS-Schiphol)')]")).click();
        driver.findElement(By.id("flight-departing-hp-flight")).click();
        driver.findElement(By.xpath(".//*[@id='flight-departing-wrapper-hp-flight']/div/div/button[2]")).click();
        driver.findElement(By.xpath(".//*[@id='flight-departing-wrapper-hp-flight']/div/div/div[2]/table/tbody/tr[2]/td[5]/button")).click();
        driver.findElement(By.id("flight-returning-hp-flight")).click();
        driver.findElement(By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/button[2]")).click();
        driver.findElement(By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/button[2]")).click();
        driver.findElement(By.xpath(".//*[@id='flight-returning-wrapper-hp-flight']/div/div/div[3]/table/tbody/tr[4]/td[3]/button")).click();
        driver.findElement(By.id("traveler-selector-hp-flight")).click();
        driver.findElements(By.xpath(".//button[@class='uitk-step-input-button uitk-step-input-plus']")).get(0).click();
        driver.findElements(By.xpath(".//button[@class='uitk-step-input-button uitk-step-input-plus']")).get(1).click();
        Select childAgeDropdown1 = new Select(driver.findElement(By.id("flight-age-select-1-hp-flight")));
        childAgeDropdown1.selectByValue("10");
        driver.findElement(By.xpath(".//*[@id='gcw-flights-form-hp-flight']/div[7]/label/button")).click();

    }
}
