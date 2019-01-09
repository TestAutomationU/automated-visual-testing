import base.BaseTests;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SearchPage;

public class SearchTests extends BaseTests {

    private String APP_NAME = "Automation Bookstore";
    private SearchPage page = new SearchPage(driver);

    @BeforeClass
    public static void launchApp(){
        driver.get(System.getProperty("site.bookstore.url"));
    }

    @Test
    public void testSearchByFullTitle(){
        String title = "Agile Testing";
        page.search(title);
        validateWindow(APP_NAME);
    }

    @Test
    public void testSearchByFullTitle_Element(){
        String title = "Agile Testing";
        page.search(title);
        validateElement(By.id("pid3"));
        Assert.assertEquals("Number of books returned",
                1, page.getNumberOfVisibleBooks());
    }
}