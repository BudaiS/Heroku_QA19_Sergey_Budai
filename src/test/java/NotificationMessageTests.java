import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotificationMessageTests extends BaseTest {
    private int lineLengthExpected = 19;

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }

    @Test
    public void notificationMessageTests() {
        WebElement clickHere = driver.findElement(By.linkText("Click here"));
        clickHere.click();
        WebElement notificationMessage = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("flash"))));
        String textActual = notificationMessage.getText();
        int lineLengthActual = textActual.length();
        Assert.assertEquals(lineLengthActual, lineLengthExpected, "Checking through string length");


    }
}
