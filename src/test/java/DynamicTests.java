import base.BaseTests;
import com.applitools.eyes.MatchLevel;
import org.junit.Test;

public class DynamicTests extends BaseTests {

    @Test
    public void testDynamicContent(){
        driver.get(System.getProperty("site.dynamic.url"));
        eyesManager.getEyes().setMatchLevel(MatchLevel.LAYOUT);
        eyesManager.validateWindow();
    }
}
