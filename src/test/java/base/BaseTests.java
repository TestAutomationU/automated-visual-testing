package base;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BaseTests {

    protected static WebDriver driver;
    protected static Eyes eyes;

    @BeforeClass
    public static void setUp() {
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        driver = new ChromeDriver();
        initiateEyes();

        driver.get(System.getProperty("site.url"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
        eyes.abortIfNotClosed();
    }

    private static void initiateEyes(){
        eyes = new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));
    }

    public void validateWindow(){
        eyes.open(driver, "The Internet", Thread.currentThread().getStackTrace()[2].getMethodName());
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.checkWindow();
        eyes.close();
    }
}