import base.BaseTests;
import com.applitools.eyes.MatchLevel;
import org.junit.Test;

public class DynamicTests extends BaseTests {

    private String APP_NAME = "The Internet";

    @Test
    public void testDynamicContent(){
        driver.get(System.getProperty("site.dynamic.url"));
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        validateWindow(APP_NAME);
    }
}
