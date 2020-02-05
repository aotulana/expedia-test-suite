import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by OKOH on 15/12/2018.
 */
public class LoginTest extends TestBase {

    private static String emailErrorMessage;
    private static String passwordErrorMessage;

    @BeforeMethod
    public void setUp() {
        initiate();

        driver.findElement(By.id("header-account-menu")).click();
        driver.findElement(By.id("account-signin")).click();
        wait = new WebDriverWait(driver, 20);
    }

    @AfterMethod
    public void closeModal() throws InterruptedException {
        driver.findElement(By.id("modalCloseButton")).click();
        Thread.sleep(2000);
    }

    @Test
    public void when_EmailAndPasswordIsEmpty_Return_FieldErrors() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gss-signin-submit")));
        driver.findElement(By.id("gss-signin-submit")).click();

        emailErrorMessage = driver.findElement(By.id("signInEmailErrorMessage")).getText();
        Assert.assertEquals(emailErrorMessage, "Please enter an email address");

        passwordErrorMessage = driver.findElement(By.id("signInPasswordErrorMessage")).getText();
        Assert.assertEquals(passwordErrorMessage, "Please enter a password");
    }

    @Test
    public void when_PasswordIsEmpty_Return_PasswordFieldError() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gss-signin-email")));
        driver.findElement(By.id("gss-signin-email")).clear();
        driver.findElement(By.id("gss-signin-email")).sendKeys("test@test.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gss-signin-submit")));
        driver.findElement(By.id("gss-signin-submit")).click();

        passwordErrorMessage = driver.findElement(By.id("signInPasswordErrorMessage")).getText();
        Assert.assertEquals(passwordErrorMessage, "Please enter a password");
    }

    @Test
    public void when_EmailIsEmpty_Return_EmailFieldError() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gss-signin-password")));
        driver.findElement(By.id("gss-signin-password")).clear();
        driver.findElement(By.id("gss-signin-password")).sendKeys("123456");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("gss-signin-submit")));
        driver.findElement(By.id("gss-signin-submit")).click();

        emailErrorMessage = driver.findElement(By.id("signInEmailErrorMessage")).getText();
        Assert.assertEquals(emailErrorMessage, "Please enter an email address");
    }
}
