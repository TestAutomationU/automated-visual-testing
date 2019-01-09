import base.BaseTests;
import org.junit.Test;

public class TheInternetTests extends BaseTests {

    @Test
    public void testBottomFrame(){
        driver.get(System.getProperty("site.frames.url"));
        validateFrame("frame-bottom");
    }
}
