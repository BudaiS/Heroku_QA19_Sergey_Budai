import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTests extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/inputs");
    }

    @Test
    public void inputsTest() {
        WebElement inputs = driver.findElement(By.tagName("input"));
        inputs.sendKeys("asdfgh{];:");
        String actualResult = inputs.getAttribute("value");
        String expectedResult = "";
        Assert.assertEquals(actualResult, expectedResult, " ");
        inputs.sendKeys("10");
        inputs.sendKeys(Keys.ARROW_UP);
        inputs.sendKeys(Keys.ARROW_UP);
        inputs.sendKeys(Keys.ARROW_UP);
        inputs.sendKeys(Keys.ARROW_DOWN);
        actualResult = inputs.getAttribute("value");
        expectedResult = "12";
        Assert.assertEquals(actualResult, expectedResult, " ");


    }
}
