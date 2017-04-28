package LoveHolidaysGP;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverConfigurer;

/**
 * Created by dhinesh.dillum on 27/04/17.
 */
public class MMBPage extends WebDriverConfigurer {

    public static final By SIGN_IN_BUTTON = By.xpath("//*[@type='submit']");
    public static final By BOOKING_REF_FIELD = By.xpath("//*[@name='referenceWithLetters']");
    public static final By WARNINGMESSAGE = By.xpath("//*[@class='mmb-login__form__field']//*[@name='referenceWithLetters']");
    public static final By ERRORMESSAGE = By.xpath("//*[@class='error'][contains(text(), 'Sorry')]");
    public static final By PASSENGER_SURNAME_FIELD = By.xpath("//*[@name='surname']");

    public MMBPage(WebDriver driver) {
        super(driver);
    }

    public void enterBookingRef(String reference) {
        driver.findElement(BOOKING_REF_FIELD).sendKeys(reference);
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public void assertWarningMessage(String expectedWarningMessage) {
        String actualWarningMessage = driver.findElement(WARNINGMESSAGE).getAttribute("oninvalid").toString();
        String trimmedMessage = actualWarningMessage.substring(actualWarningMessage.indexOf("y")+3, 105).trim();
        Assert.assertTrue(trimmedMessage.contains(expectedWarningMessage));
    }

    public void enterPassengerSurname(String surname) {
        driver.findElement(PASSENGER_SURNAME_FIELD).sendKeys(surname);
        driver.findElement(SIGN_IN_BUTTON).click();
    }

    public void assertErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = driver.findElement(ERRORMESSAGE).getText();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }

}
