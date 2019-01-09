package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class SearchPage {
    private WebDriver driver;
    private By searchBar = By.id("searchBar");
    private By visibleBooks =
            By.xpath("//li[not(contains(@class, 'ui-screen-hidden'))]");
    private By hiddenBooks =
            By.xpath("//li[contains(@class, 'ui-screen-hidden')]");

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String text) {
        search(text, true);
    }

    public void search(String text, boolean waitForHidden) {
        clearSearch();
        driver.findElement(searchBar).sendKeys(text);

        if(waitForHidden) {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(presenceOfElementLocated(hiddenBooks));
        }
    }

    public void clearSearch() {
        driver.findElement(searchBar).clear();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(numberOfElementsToBe(hiddenBooks, 0));
    }

    public int getNumberOfVisibleBooks() {
        return findVisibleBooks().size();
    }

    private List<WebElement> findVisibleBooks(){
        return driver.findElements(visibleBooks);
    }
}