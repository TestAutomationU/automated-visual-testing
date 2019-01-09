import base.BaseTests;
import org.junit.Test;

public class ScrollTests extends BaseTests {

    private String APP_NAME = "The Internet";

    @Test
    public void testLargeDom() {
        driver.get(System.getProperty("site.largedom.url"));
        validateWindow(APP_NAME);
    }
}