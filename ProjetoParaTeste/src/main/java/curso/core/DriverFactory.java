package curso.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    //	private static WebDriver driver;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
        @Override
        protected synchronized WebDriver initialValue() {
            return initDriver();
        }
    };

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        WebDriver driver = getDriver();

        driver.close();
        if (threadDriver != null) {
            threadDriver.remove();
        }
    }
}
