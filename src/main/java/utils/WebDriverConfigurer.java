package utils;

import org.openqa.selenium.WebDriver;

/**
 * Created by dhinesh.dillum on 25/04/17.
 */
public class WebDriverConfigurer {

    public static WebDriver driver;

    public WebDriverConfigurer(WebDriver driver) {
        this.driver = driver;
    }
}
