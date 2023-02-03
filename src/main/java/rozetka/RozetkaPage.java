package rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaPage {
    public final WebDriver driver;

    private final static By PAGINATION_AREA = By.xpath("//div[@class='pagination ng-star-inserted']");
    private final static By PAGES = By.xpath("//a[@class='pagination__link ng-star-inserted']");
    private final static By NEXT_PAGE = By.xpath("//a[@title='До наступної сторінки']");
    private final static By PREVIOUS_PAGE = By.xpath("//a[@title='До попередньої сторінки']");

    public RozetkaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://rozetka.com.ua/network-equipment/c80111/");
    }

    public WebElement goToPaginationArea() {
        return driver.findElement(PAGINATION_AREA);
    }

    public int getPageNumber (WebElement page) {
        String pageUrl = page.getAttribute("href");
        int hrefLength = pageUrl.length();
        if (hrefLength < 56 && hrefLength > 0) {
            return 1;
        }
        else {
            String pageNumber = pageUrl.substring(56, hrefLength-1);
            return Integer.parseInt(pageNumber);
        }
    }

    public void goToPageByNumber (int pageNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(PAGES));
        List<WebElement> pages = driver.findElements(PAGES);
        for (int i = 0; i < pages.size(); i++) {
            if (getPageNumber(pages.get(i)) == pageNumber) {
                pages.get(i).click();
            }
        }
    }

    public void goToTheNextPage () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(NEXT_PAGE)).click();
    }

    public void goToThePreviousPage () {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(PREVIOUS_PAGE)).click();
    }

}
