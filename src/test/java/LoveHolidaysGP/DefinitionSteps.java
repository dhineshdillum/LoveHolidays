package LoveHolidaysGP;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by dhinesh.dillum on 27/04/17.
 */
public class DefinitionSteps{

    LHHomepage lhHomepage;
    MMBPage mmbpage;
    public static WebDriver driver;

    @Before
    public void configureDrivers() {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/drivers/mac/chromedriver 6");
        lhHomepage = new LHHomepage(driver);
        lhHomepage.openTheLoveHolidayHomePage_PROD();
    }

    @Given("^that a user goes to MMB page$")
    public void that_a_user_goes_to_MMB_page() throws Throwable {
        configureDrivers();
        mmbpage = lhHomepage.goToMMBPage();
    }

    @When("^the user enters a reference number like \"([^\"]*)\"$")
    public void the_user_enters_a_reference_number_like(String reference) throws Throwable {
        mmbpage.enterBookingRef(reference);
    }

    @Then("^the message should contain this text \"([^\"]*)\"$")
    public void the_message_should_contain_this_text(String message) throws Throwable {
        mmbpage.assertWarningMessage(message);
    }

    @When("^the user enters \"([^\"]*)\" in the surname$")
    public void the_user_enters_Test_in_the_surname(String surname) throws Throwable {
        mmbpage.enterPassengerSurname(surname);
    }

    @Then("^we show the error message that contains \"([^\"]*)\"$")
    public void we_show_the_error_message_that_contains_Sorry_this_is_not_a_valid_booking_reference_If_you_have_booked_within_the_last_hours_please_wait_until_you_receive_your_LOV_or_LVE_reference_number_by_email_before_logging_in(String errorMessage) throws Throwable {
        mmbpage.assertErrorMessage(errorMessage);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
