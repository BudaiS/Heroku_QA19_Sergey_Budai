import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TyposTests extends  BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/typos");
    }

    @Test
    public void typosTests() {
        WebElement firstTypos = driver.findElement(By.tagName("p"));
        WebElement secondTypos = driver.findElement(By.cssSelector("#content > div > p:nth-child(3)"));
        String firstPartOfTheText = firstTypos.getText();
        String secondPartOfTheText = secondTypos.getText();
        String actualResult = firstPartOfTheText + secondPartOfTheText;
        String expectedResult = "This example demonstrates a typo being introduced. It does it randomly on each page load." +
                "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(actualResult, expectedResult, "Spell check");

    }

}
