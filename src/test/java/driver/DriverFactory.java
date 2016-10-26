package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class DriverFactory {

    public static final String CHROME = "chrome";
    public static final String PHANTOMJS = "phantomjs";
    public static final String FIREFOX = "firefox";
    private static final String[] BROWSERS = {CHROME, PHANTOMJS, FIREFOX};

    // Get a new WebDriver Instance.
    public static WebDriver getDriver() {
        if (System.getenv("RANDOMIZE").trim().toLowerCase().equals("true")) {
            return randomBrowser();
        }
        String browser = System.getenv("BROWSER");

        return getWebDriver(browser);
    }

    private static WebDriver getWebDriver(String browser) {
        if (browser == null) {
            return new FirefoxDriver();
        }
        browser = browser.trim().toLowerCase();
        WebDriver driver;
        if (browser.equals(CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(PHANTOMJS)) {
            driver = new PhantomJSDriver();
        } else {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    private static WebDriver randomBrowser() {
        return getWebDriver(BROWSERS[(int) Math.floor(Math.random()*3)]);
    }

}