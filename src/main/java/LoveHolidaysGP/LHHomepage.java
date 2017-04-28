package LoveHolidaysGP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverConfigurer;

/**
 * Created by dhinesh.dillum on 27/04/17.
 */
public class LHHomepage extends WebDriverConfigurer {

    public static final By MMB_OPTION = By.xpath("//span[contains(text(), 'Manage')]");

    public LHHomepage(WebDriver driver) {
        super(driver);
    }

    public static void openTheLoveHolidayHomePage_PROD() {
        driver.get("https://www.loveholidays.com/");
    }

    public MMBPage goToMMBPage() {
        driver.findElement(MMB_OPTION).click();
        return new MMBPage(driver);
    }
}
