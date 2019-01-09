import base.BaseTests;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.SortableDataTablesPage;

public class TheInternetTests extends BaseTests {

    private SortableDataTablesPage page = new SortableDataTablesPage(driver);

    @BeforeClass
    public static void startVisualTestSuite(){
        eyesManager.setBatchName("Sort Table");
        driver.get(System.getProperty("sites.tables.url"));
    }

    @Test
    public void testSortByLastName(){
        page.sortLastNameColumn();
        eyesManager.validateElement(page.getTableElementLocator());
    }

    @Test
    public void testSortByFirstName(){
        page.sortFirstNameColumn();
        eyesManager.validateElement(page.getTableElementLocator());
    }

    @Test
    public void testSortByEmail(){
        page.sortEmailColumn();
        eyesManager.validateElement(page.getTableElementLocator());
    }

    @Test
    public void testSortByDueDate(){
        page.sortDueColumn();
        eyesManager.validateElement(page.getTableElementLocator());
    }

    @Test
    public void testSortByWebsite(){
        page.sortWebsiteColumn();
        eyesManager.validateElement(page.getTableElementLocator());
    }
}
